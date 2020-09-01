package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class SenderPriorityQueue {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //这里的true 和 false 是开启事务的意思
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("queue1");

        MessageProducer producer= session.createProducer(queue);
//        设置不持久化
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 0;i<10;i++){
            TextMessage textMessage = session.createTextMessage("hi: " + i);
            if(i%3==0){
                producer.setPriority(9);
            }else {
                producer.setPriority(1);

            }
            producer.send(textMessage);
        }

        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
