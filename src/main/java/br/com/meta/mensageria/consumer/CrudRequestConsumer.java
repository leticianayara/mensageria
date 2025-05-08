package br.com.meta.mensageria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CrudRequestConsumer {

    @RabbitListener(queues = {"crud-request-queue"})
    public void receberMensagem (@Payload Message message){

    }
}
