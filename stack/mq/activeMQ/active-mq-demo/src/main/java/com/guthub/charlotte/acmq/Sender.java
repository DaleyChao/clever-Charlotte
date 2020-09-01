package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class Sender {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //这里的true 和 false 是开启事务的意思
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("user");

        MessageProducer producer= session.createProducer(queue);
//        设置不持久化
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 0;i<10;i++){
            TextMessage textMessage = session.createTextMessage("hi: " + i);
            producer.send(textMessage);
        }

        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
