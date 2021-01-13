package com.cnc.rabbitmq.Test;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 谭炜
 * @create 2020-12-09 23:41
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))

public class testmq {

    @RabbitHandler
    public void receive1(String message){
        System.out.println("message = " + message);
    }
}
