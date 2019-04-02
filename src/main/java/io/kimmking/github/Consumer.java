package io.kimmking.github;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    public static String QueueName = "test-queue";
    public static String TopicName = "test-topic";

    // 演示
    public static void main(String args[]) throws Exception{

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TopicName);
        MessageConsumer topicConsumer =session.createConsumer(topic);
        topicConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("receive a topic message: " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        Queue queue = session.createQueue(QueueName);
        MessageConsumer queueConsumer =session.createConsumer(queue);
        queueConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("receive a queue message: " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


        System.in.read(); // hold on thread

        topicConsumer.close();
        queueConsumer.close();

        session.close();
        connection.close();


    }


}
