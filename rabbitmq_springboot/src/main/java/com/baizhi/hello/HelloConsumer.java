package com.baizhi.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component //持久化 非独占 不是自动删除队列
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloConsumer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("message="+message);
    }
}
