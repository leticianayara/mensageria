package br.com.meta.services;

import br.com.meta.dto.VisitorDTO;
import br.com.meta.models.Visitor;
import br.com.meta.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository repository;

    public VisitorDTO save(Visitor visitor){
       visitor = repository.save(visitor);
        return getVisitorDTO(visitor);
    }

    private VisitorDTO getVisitorDTO(Visitor visitor) {
        return new VisitorDTO(visitor);
    }
}
