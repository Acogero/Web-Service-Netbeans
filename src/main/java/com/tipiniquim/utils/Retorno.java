package com.tipiniquim.utils;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "Retorno")
public class Retorno implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int SUCESSO = 0;
    public static final int ERRO = 1;

    @JsonProperty("RETORNO")
    private int retorno;

    @JsonProperty("DADOS")
    private Object dados;

    @JsonProperty("MENSAGEM")
    private String mensagem;

    public Retorno() {
    }

    public Retorno(int retorno, Object dados, String mensagem) {
	this.retorno = retorno;
	
	this.dados = dados;
	
	this.mensagem = mensagem;
    }

    public int getRetorno() {
	return retorno;
    }

    public Object getDados() {
	return dados;
    }

    public String getMensagem() {
	return mensagem;
    }

    public static Retorno createRetornoSucesso(Object dados, String mensagem) {
	return new Retorno(SUCESSO, dados, mensagem);
    }

    public static Retorno createRetornoErro(String mensagem) {
	return new Retorno(ERRO, null, mensagem);
    }

    @Override
    public String toString() {
	return "Retorno [retorno=" + retorno + ", dados=" + dados + ", mensagem=" + mensagem + "]";
    }

}