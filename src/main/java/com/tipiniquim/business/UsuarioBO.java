/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;

import com.tipiniquim.dao.UsuarioDAO;
import com.tipiniquim.modelo.Usuario;
import com.tipiniquim.to.ClienteTO;
import com.tipiniquim.to.UsuarioTO;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
@Stateless
public class UsuarioBO {

  @Inject
  UsuarioDAO usuarioDAO;

  public void criandoUsuario(String usuario) throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    Usuario c = objectMapper.readValue(usuario, Usuario.class);

    if (c != null) {
      this.usuarioDAO.merge(c);

    }
  }

  public Usuario usuarioTeste() {
    Usuario u = new Usuario();

    u.setEmail("Email@email.com");
    u.setId(01);
    u.setNome("Nome Teste");
    u.setPassword("qwe123asd");

    return u;
  }
  
  public ClienteTO getUsr() {
	  List<UsuarioTO> usersTO = new ArrayList<UsuarioTO>();
	  List<Usuario> users = this.usuarioDAO.findAll();
	  
	  if (users != null) {
		  for (Usuario usuarioBD : users) {
			  UsuarioTO usuarioTO = new UsuarioTO(usuarioBD);

			  usersTO.add(usuarioTO);
		  }
	  }
	  
	  ClienteTO clienteTO = new ClienteTO(usersTO);
	  
	  return clienteTO;
  }
}
