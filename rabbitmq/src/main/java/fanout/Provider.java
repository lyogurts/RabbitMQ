package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //将通道声明指定交换机  参数1：交换机名称 参数2：交换机类型  fanout 广播类型
        channel.exchangeDeclare("logs","fanout");//广播，一条消息被多个消费者消费
        //发送消息
        channel.basicPublish("logs","",null,"fanout type message".getBytes());
        //释放
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
