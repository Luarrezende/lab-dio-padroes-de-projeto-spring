package one.digitalInovation.api_padroes_de_projetos.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import one.digitalInovation.api_padroes_de_projetos.model.entity.Cliente;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Long>{
}
