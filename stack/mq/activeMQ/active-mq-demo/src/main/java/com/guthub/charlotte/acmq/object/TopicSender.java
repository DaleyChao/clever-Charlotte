package com.guthub.charlotte.acmq.object;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Arrays;

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

        Girl girl;
        for (int i = 0;i<10;i++){
            girl = new Girl("name"+i,i+5);
            ObjectMessage textMessage = session.createObjectMessage(girl);
            producer.send(textMessage);
            MapMessage mapMessage = session.createMapMessage();
//            mapMessage.
        }

        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
