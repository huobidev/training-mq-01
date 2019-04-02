package io.kimmking.github;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    public static String QueueName = "test-queue";
    public static String TopicName = "test-topic";

    // 演示
    public static void main(String args[]) throws Exception{

        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）

        // 发送一个消息到topic
        Topic topic = session.createTopic(TopicName);
        //6、使用会话对象创建生产者对象
        MessageProducer queueProducer = session.createProducer(topic);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage1 = session.createTextMessage("hello!test-topic");
        //8、发送消息
        queueProducer.send(textMessage1);

        // 发送一个消息到queue
        Queue queue = session.createQueue(QueueName);
        //9、使用会话对象创建生产者对象
        MessageProducer topicProducer = session.createProducer(queue);
        //10、使用会话对象创建一个消息对象
        TextMessage textMessage2 = session.createTextMessage("hello!test-queue");
        //11、发送消息
        topicProducer.send(textMessage2);


        //12、关闭资源
        queueProducer.close();
        topicProducer.close();
        session.close();
        connection.close();


    }


}
