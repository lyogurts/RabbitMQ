package com.baizhi.routeDirect;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteDirectConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(),
                    exchange = @Exchange(name = "directExchange"),
                    key = {"info","error"}
            )
    })
    public void receive(String message){
        System.out.println("message="+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "directExchange"),
                    key = {"info"}
            )
    })
    public void receive2(String message){
        System.out.println("message2="+message);
    }
}
