package com.minierp.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.repository.Empresas;

/**
 * Classe controladora responsável pela gestão das empresas.
 * É um Managed Bean acessado diretamente pelas páginas XHTML via EL #{gestaoEmpresasBean}.
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    //Dados vindo do repositorio
    @Inject
    private Empresas empresas;
    
    
    private List<Empresa>listaEmpresas;
    
    //Popular a lista com todas a empresas da base de dados
    public void todasEmpresas() {
    	listaEmpresas = empresas.todas();
    	
    }
    
    public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
    
    
}
