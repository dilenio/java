package br.com.codenation.modelos;

import java.time.LocalDate;

public class Time {
  public Long id;
  public String nome;
  public LocalDate dataCriacao;
  public String corUniformePrincipal;
  public String corUniformeSecundario;

  public Time(Long id, String nome, LocalDate dataCriacao,
              String corUniformePrincipal, String corUniformeSecundario) {
    super();
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.corUniformePrincipal = corUniformePrincipal;
    this.corUniformeSecundario = corUniformeSecundario;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public String getCorUniformePrincipal() {
    return corUniformePrincipal;
  }

  public String getCorUniformeSecundario() {
    return corUniformeSecundario;
  }
}
