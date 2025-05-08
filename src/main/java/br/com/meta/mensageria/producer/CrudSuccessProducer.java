package br.com.meta.mensageria.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudSuccessProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta (String mensagem){
        amqpTemplate.convertAndSend("crud-response-success-exchange",
                "crud-response-success-rout-key",
                mensagem);
    }
}
