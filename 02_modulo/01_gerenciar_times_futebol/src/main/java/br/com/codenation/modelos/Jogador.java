package br.com.codenation.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
  private Long id;
  private Long idTime;
  private String nome;
  private LocalDate dataNascimento;
  private Integer nivelHabilidade;
  private BigDecimal salario;
  private Boolean capitao;

  public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
                 Integer nivelHabilidade, BigDecimal salario) {
    super();
    this.id = id;
    this.idTime = idTime;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nivelHabilidade = nivelHabilidade;
    this.salario = salario;
    this.capitao = false;
  }

  public Long getId() {
    return id;
  }

  public Long getIdTime() {
    return idTime;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public Integer getNivelHabilidade() {
    return nivelHabilidade;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public Boolean isCapitao() {
    return capitao;
  }

  public void setCapitao(Boolean cap) {
    this.capitao = cap;
  }
}
