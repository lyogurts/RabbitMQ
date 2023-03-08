package com.baizhi.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    @RabbitListener(bindings = @QueueBinding( //绑定队列和交换机
            value = @Queue, //临时队列
            exchange = @Exchange(value = "logs",type = "fanout") //绑定交换机
    ))
    public void receive(String message){
        System.out.println("message="+message);
    }

//第二个消费者
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "logs",type = "fanout")
    ))
    public void receive2(String message){
        System.out.println("message2="+message);
    }
}
