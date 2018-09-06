/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.ws;

import java.io.IOException;

import javax.ws.rs.core.Response;



/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public abstract class AbstractFacade<T> {

    @SuppressWarnings("unused")
    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected Response generateRetorno(Object obj) throws IOException {    	
    	return Response.status(Response.Status.OK).header("Content-Type", "application/json; charset=UTF8").entity(obj).build();
    }
    
    protected Response generateRetornoErro(String mensagem) throws IOException {

    	return Response.status(Response.Status.OK).header("Content-Type", "application/json; charset=UTF8").entity(mensagem).build();
    }
}
