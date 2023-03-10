package routingTopic;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定队列与交换机并设置获取交换机中动态路由
        channel.queueBind(queue,"topics","user.*");

        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
            }
        });
    }
}
