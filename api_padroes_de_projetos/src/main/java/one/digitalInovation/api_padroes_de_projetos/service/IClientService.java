package one.digitalInovation.api_padroes_de_projetos.service;

import one.digitalInovation.api_padroes_de_projetos.model.entity.Cliente;

public interface IClientService {
  Iterable<Cliente> findAll();
  Cliente buscarPorId(Long id);
  void inserir(Cliente cliente);
  void atualizar(Long id, Cliente cliente);
  void deletar(Long id);
}
