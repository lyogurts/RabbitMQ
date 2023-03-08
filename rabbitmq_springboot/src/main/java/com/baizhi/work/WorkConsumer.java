package com.baizhi.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;

@Component
public class WorkConsumer {
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive(String message){
        System.out.println("message="+message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.out.println("message="+message);
    }
}

