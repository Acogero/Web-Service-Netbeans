/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
@Entity
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
  private int id;

  @Column(name = "nome")
  private String nome;
  @Column(name = "email")
  private String email;
  @Column(name = "senha")
  private String senha;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.senha;
  }

  public void setPassword(String password) {
    this.senha = password;
  }

}
