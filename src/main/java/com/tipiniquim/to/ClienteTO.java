package com.tipiniquim.to;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ClienteTO {

	
    @JsonProperty("usuarios")
    private List<UsuarioTO> usuarios;
    
    public ClienteTO() {
    	this.usuarios = new ArrayList<UsuarioTO>();
    }
    
    public ClienteTO(List<UsuarioTO> listaUsuario) {
    	this.usuarios = listaUsuario;
    }

    /* GET AND SETTER */
	public List<UsuarioTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioTO> usuarios) {
		this.usuarios = usuarios;
	}
}
