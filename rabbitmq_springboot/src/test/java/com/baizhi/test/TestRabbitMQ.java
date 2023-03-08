package com.baizhi.test;

import com.baizhi.RabbitmqSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入rabbiTemplate模板
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //hello word
    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
    //work
    @Test
    public void testWork(){
        rabbitTemplate.convertAndSend("work","hello work");
    }
    //广播
    @Test
    public void  testFanout(){
        rabbitTemplate.convertAndSend("logs","","这是广播日志");
    }
    //路由模式
    @Test
    public void testRouteDirect(){
        rabbitTemplate.convertAndSend("directExchange","error","error的日志信息");
    }
    //动态路由
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topicExchange","info.save","动态路由的info信息");
    }

}
