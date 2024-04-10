package one.digitalInovation.api_padroes_de_projetos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalInovation.api_padroes_de_projetos.model.entity.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  @GetMapping("/{cep}/json")
  Endereco buscaEnderecoPorCep(@PathVariable String cep);
}
