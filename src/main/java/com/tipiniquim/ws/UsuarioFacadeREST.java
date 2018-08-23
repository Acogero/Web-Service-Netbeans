/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.ws;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.tipiniquim.business.UsuarioBO;
import com.tipiniquim.modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
@Stateless
@Path("/")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

  @EJB
  UsuarioBO usuarioBO;

  public UsuarioFacadeREST() {
    super(Usuario.class);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/Cadastrar")
  public Usuario cadastrar(String usuario) throws IOException {

    Usuario usrBO = this.usuarioBO.criandoUsuario(usuario);

    return usrBO;
  }
}