package routingTopic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");
        //动态路由key
        String routekey = "user.save";
          channel.basicPublish("topics",routekey,null ,("这是动态订阅模型,route key ["+routekey+"]").getBytes());
    }
}
