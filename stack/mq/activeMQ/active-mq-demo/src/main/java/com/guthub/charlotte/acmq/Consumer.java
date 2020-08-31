package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class Consumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("queue1");

        MessageConsumer consumer= session.createConsumer(queue);


        for (int i = 0;i<10;i++){
            TextMessage textMessage = (TextMessage)consumer.receive();
            System.out.println("receive :"+textMessage.getText());
        }
        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
