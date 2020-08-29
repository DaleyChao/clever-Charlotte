package com.guthub.charlotte.acmq.object;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Arrays;

/**
 * @author Daniel
 */
public class TopicConsumer2 {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin","admin123","tcp://127.0.0.1:61616"
        );
        //转换object需要添加信任
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList(Girl.class.getPackage().getName()));

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Destination topic = session.createTopic("top1");

        MessageConsumer consumer= session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if(message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
//                    if(Integer.valueOf(textMessage.())%3==0) {
                        //                textMessage.acknowledge();
                        System.out.println("receive :" + textMessage.getText());
//                    }
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }else if(message instanceof ObjectMessage){
                    ObjectMessage textMessage = (ObjectMessage) message;
                    try {
                        Girl girl = (Girl)textMessage.getObject();
                        System.out.println("receive :" + (girl.getName() +" " + girl.getAge()));

                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }});
//        while (true){
//            TextMessage textMessage = (TextMessage)consumer.receive();
//            if(Integer.valueOf(textMessage.getText())%3==0) {
////                textMessage.acknowledge();
//                System.out.println("receive :"+textMessage.getText());
//
//            }
//            session.commit();
//        }

//        session.close();
//        connection.close();
//        System.out.println("System exit....");

    }
}
