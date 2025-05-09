package br.com.meta.repositories;

import br.com.meta.models.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, String> {
}
