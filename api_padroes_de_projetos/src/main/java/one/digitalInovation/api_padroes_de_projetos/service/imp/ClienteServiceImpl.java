package one.digitalInovation.api_padroes_de_projetos.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalInovation.api_padroes_de_projetos.model.entity.Cliente;
import one.digitalInovation.api_padroes_de_projetos.model.entity.Endereco;
import one.digitalInovation.api_padroes_de_projetos.model.repository.ClientRepository;
import one.digitalInovation.api_padroes_de_projetos.model.repository.EnderecoRepository;
import one.digitalInovation.api_padroes_de_projetos.service.IClientService;
import one.digitalInovation.api_padroes_de_projetos.service.ViaCepService;

public class ClienteServiceImpl implements IClientService {
  @Autowired
  private ClientRepository clienteRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;
  @Autowired
  private ViaCepService viaCepService;


  @Override
  public Iterable<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente buscarPorId(Long id) {
    Optional<Cliente> cliente = clienteRepository.findById(id);
    return cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
  }

  @Override
  public void inserir(Cliente cliente) {
    salvarClienteComCep(cliente);
  }

  @Override
  public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
  }

  @Override
  public void deletar(Long id) {
    clienteRepository.deleteById(id);
  }

  private void salvarClienteComCep(Cliente cliente) {
    String cep = cliente.getEndereco().getCep();
    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
      Endereco novoEndereco = viaCepService.buscaEnderecoPorCep(cep);
      enderecoRepository.save(novoEndereco);
      return novoEndereco;
    });
    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);
  }
  
}
