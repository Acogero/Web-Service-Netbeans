/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tipiniquim.ws;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.postgresql.util.Base64;

import com.tipiniquim.utils.JsonUtils;
import com.tipiniquim.utils.Retorno;

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
    	
    	Logger logger = Logger.getLogger("INFO");
    	logger.info("Gerando Retorno");
    	Retorno retorno = Retorno.createRetornoSucesso(obj, "Sucesso");
    	
    	String retornoStr = JsonUtils.objectToJsonWithRootName(retorno); 
    	logger.info("String retorno gerado");
    	
    	return Response.status(Response.Status.OK).header("Content-Type", "application/json; charset=UTF8").entity(retornoStr).build();
    }
    
    @SuppressWarnings("unused")
	private String toBase64(String value) {
    	return Base64.encodeBytes(value.getBytes());
    }

    protected Response generateRetornoErro(String mensagem) throws IOException {

    	Retorno retorno = Retorno.createRetornoErro(mensagem);

    	return Response.status(Response.Status.OK).header("Content-Type", "application/json; charset=UTF8").entity(JsonUtils.objectToJsonWithRootName(retorno)).build();
    }

/*
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
*/
}
