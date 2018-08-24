/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.business;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipiniquim.dao.UsuarioDAO;
import com.tipiniquim.modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
@Stateless
public class UsuarioBO
{

  @Inject
  UsuarioDAO usuarioDAO;

  public Usuario criandoUsuario(String usuario) throws IOException
  {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    Usuario c = objectMapper.readValue(usuario, Usuario.class);

    if (c != null)
    {
      return this.usuarioDAO.merge(c);

    }
    else
    {
      //            String mensagem = "Não salvou o usuário";
      return null;
    }
  }

  public Usuario usuarioTeste()
  {
    Usuario u = new Usuario();

    u.setEmail("Email@email.com");
    u.setId(01);
    u.setNome("Nome Teste");
    u.setPassword("qwe123asd");

    return u;
  }
  
  public List<Usuario> getUsr() {
	  return this.usuarioDAO.findAll();
  }
}
