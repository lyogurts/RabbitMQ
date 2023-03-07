package routingDirect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接通道对象
        Channel channel = connection.createChannel();
        //通过通道声明交换机 参数1：交换机名称 参数2：direct 路由模式
        channel.exchangeDeclare("logs_direct","direct");
        String key = "info";
        channel.basicPublish("logs_direct",key,null,("这是direct模型发布的基于routekey: ["+key+"] 发送的消息").getBytes());
        //关闭资源
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
