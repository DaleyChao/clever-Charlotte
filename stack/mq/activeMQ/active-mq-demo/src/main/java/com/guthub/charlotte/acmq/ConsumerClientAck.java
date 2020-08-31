package com.guthub.charlotte.acmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Daniel
 */
public class ConsumerClientAck {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 开启手动应答，必须关闭事务
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue("user");

        MessageConsumer consumer= session.createConsumer(queue);

        for (int i = 0;i<10;i++){
            TextMessage textMessage = (TextMessage)consumer.receive();
            System.out.println("receive :"+textMessage.getText());
            textMessage.acknowledge();
        }
        session.close();
        connection.close();
        System.out.println("System exit....");

    }
}
