/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.dao;

import com.tipiniquim.bd.ConnectionFactory;
import com.tipiniquim.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public class UsuarioDAO extends Usuario {
    
    Usuario u = new Usuario();
    
    public static UsuarioDAO getInstance() {
        return new UsuarioDAO();
    }

    public Usuario merge(Usuario usuario) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            
//        EntityManager em = new ConnectionFactory().getConnection();

        EntityManager em = emf.createEntityManager();
        
        try {

            Usuario usuarioOld = em.find(Usuario.class, usuario.getId());
    
            em.getTransaction().begin();
            
            if(usuario.getId() == usuarioOld.getId()) {
                em.merge(usuario);
            } else {
                em.persist(usuario);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return usuario;
    }
    
    public Usuario findById(int id) {
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            u = em.find(Usuario.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        
        return u;
    }
    
    public List<Usuario> findAll() {
        EntityManager em = new ConnectionFactory().getConnection(); 
        List<Usuario> listaUsuario = new ArrayList<>();
        
        try {
            listaUsuario = em.createQuery("from Usuario u").getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        
        return listaUsuario;
    }
    
    public Usuario delete(int id) {
        EntityManager em = new ConnectionFactory().getConnection();  
                
        try {
            u = em.find(Usuario.class, id);
            
            em.getTransaction().begin();
            if (u != null) {
                em.remove(u);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        
        return u;
    } 
}
