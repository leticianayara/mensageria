package br.com.meta.services;

import br.com.meta.dto.VisitorDTO;
import br.com.meta.models.Visitor;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumeMessageService {

    @Autowired
    private VisitorService service;

    @RabbitListener(queues = {"crud-request-queue"})
    public void consumeMessage(String messageBody) throws IllegalArgumentException{

        Gson gson = new Gson();
        VisitorDTO visitorDTO = gson.fromJson(messageBody, VisitorDTO.class);

        if(visitorDTO.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }

        Visitor visitor = new Visitor(visitorDTO.getId(), visitorDTO.getName(), visitorDTO.getDescription());
        service.save(visitor);
    }
}
