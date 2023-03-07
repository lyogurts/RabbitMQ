package directConnection;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
  @Test
  public void testSendMessage() throws IOException {
   //创建连接工厂
    Connection connection = RabbitMQUtils.getConnection();


    //创建通道
    Channel channel = connection.createChannel();
    //参数1：队列名称 如果队列不存在自动创建
    //参数2: 队列是否持久化
    // 参数3:是否独占队列
    // 参数4:队列是否自动删除
    // 参数5:其他属性
    channel.queueDeclare("hello",true,false,true,null);


    //发布消息
    //参数1：交换机名称
    //参数2：队列名称
    //参数3：传递消息额外设置
    //参数4：消息的具体内容
    channel.basicPublish("","hello",  MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitmq".getBytes());


    RabbitMQUtils.closeConnectionAndChanel(channel,connection);
//    channel.close();
//    connection.close();
    }
}
