package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class TopicSender {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //这里的true 和 false 是开启事务的意思
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination topic = session.createTopic("top1");

        MessageProducer producer= session.createProducer(topic);
//        设置不持久化
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 0;i<10;i++){
            TextMessage textMessage = session.createTextMessage(""+i);
            producer.send(textMessage);
        }

        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
