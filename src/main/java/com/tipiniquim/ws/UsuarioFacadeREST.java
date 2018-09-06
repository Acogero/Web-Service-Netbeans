/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.ws;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tipiniquim.business.UsuarioBO;
import com.tipiniquim.modelo.Usuario;
import com.tipiniquim.to.ClienteTO;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
@Stateless
@Path("/")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> implements UsuarioRestInter{

  @EJB
  UsuarioBO usuarioBO;

  public UsuarioFacadeREST() {
    super(Usuario.class);
  }

  @Override
  public Response cadastrar(String usuario) throws IOException {
      
    this.usuarioBO.criandoUsuario(usuario);
    return generateRetorno(usuario);
  }
  
  @Override
  public Response getUsr() throws IOException {
    return generateRetorno(getClienteTO());
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  private ClienteTO getClienteTO() throws IOException {
    return this.usuarioBO.getUsr();
  }
}
