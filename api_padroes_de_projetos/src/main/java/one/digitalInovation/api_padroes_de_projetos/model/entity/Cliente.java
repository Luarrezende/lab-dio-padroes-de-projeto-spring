package one.digitalInovation.api_padroes_de_projetos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  @ManyToOne
  private Endereco endereco;

  public Cliente() {
  }

  public Cliente(Long id, String nome, Endereco endereco) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
