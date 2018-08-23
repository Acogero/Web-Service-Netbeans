/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.tipiniquim.bd.ConnectionFactory;
import com.tipiniquim.modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public class UsuarioDAO {

  private Usuario u = new Usuario();

  @PersistenceContext(name = "meuPU")
  protected EntityManager em2;

  public Usuario merge(Usuario usuario) {

    try {

      this.em2.merge(usuario);

    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    } 

    return usuario;
  }

  public Usuario findById(int id) {

    try {
      this.u = em2.find(Usuario.class, id);
    } catch (Exception e) {
      System.out.println("Erro: " + e);

    } 

    return this.u;
  }

  public List<Usuario> findAll() {
    List<Usuario> listaUsuario = new ArrayList<Usuario>();

    try {
      listaUsuario = em2.createQuery("from Usuario u").getResultList();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }

    return listaUsuario;
  }

  public Usuario delete(int id) {

    try {
      this.u = em2.find(Usuario.class, id);

      if (this.u != null) {
        em2.remove(this.u);
      }

    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }

    return this.u;
  }
}
