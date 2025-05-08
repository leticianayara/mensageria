package br.com.meta.mensageria.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudErrorProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend("crud-response-error-exchange",
                "crud-response-error-rout-key",
                mensagem);
    }
}
