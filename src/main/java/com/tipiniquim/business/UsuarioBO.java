/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.business;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipiniquim.dao.UsuarioDAO;
import com.tipiniquim.modelo.Usuario;
import java.io.IOException;


/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public class UsuarioBO {
    
    public UsuarioBO getInstance() {
        return new UsuarioBO();
    }
    
    public Usuario criandoUsuario(String usuario) throws IOException {
        
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Usuario c = objectMapper.readValue(usuario, Usuario.class);
        
        if (c != null) {
            return UsuarioDAO.getInstance().merge(c);
            
        } else {  
//            String mensagem = "Não salvou o usuário";
            return null;
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
}
