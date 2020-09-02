package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class TopicConsumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination topic = session.createTopic("top1");

        MessageConsumer consumer= session.createConsumer(topic);

        while (true){
            TextMessage textMessage = (TextMessage)consumer.receive();
            if(Integer.valueOf(textMessage.getText())%3==0) {
                textMessage.acknowledge();
                System.out.println("receive :"+textMessage.getText());

            }
//            session.commit();
        }

//        session.close();
//        connection.close();
//        System.out.println("System exit....");

    }
}
