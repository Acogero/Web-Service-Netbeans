/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.bd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Marcos Vinicius A. M. - Acogero - louis.seipher@gmail.com
 */
public class ConnectionFactory {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    
    public EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
