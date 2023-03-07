package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public class RabbitMQUtils {
    //静态，工厂，重量级资源，类加载执行只有一次
    private  static  ConnectionFactory connectionFactory;

    static {
        //创建连接工厂
         connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("42.193.98.249");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("virtualMachine");
    }
    public static Connection  getConnection(){
//        Connection connection = null;
        try {
            return  connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭通道和关闭连接方法
    public static  void  closeConnectionAndChanel(Channel channel,Connection connection){
        try {
            if (channel!=null) channel.close();
            if (connection!=null)connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
