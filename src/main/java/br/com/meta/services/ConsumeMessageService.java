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
    public void consumeMessage(String messageBody) {

        Gson gson = new Gson();
        VisitorDTO visitorDTO = gson.fromJson(messageBody, VisitorDTO.class);
        Visitor visitor = new Visitor(visitorDTO.getId(), visitorDTO.getName(), visitorDTO.getDescription());
        service.save(visitor);
    }
}
