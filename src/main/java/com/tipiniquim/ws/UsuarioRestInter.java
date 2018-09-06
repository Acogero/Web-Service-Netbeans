/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.ws;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public interface UsuarioRestInter {
    
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/Cadastrar")
  public Response cadastrar(String usuario) throws IOException;
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get")
  public Response getUsr() throws IOException;
}
