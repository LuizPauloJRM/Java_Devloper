package com.minierp.jsf.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.model.RamoAtividade;
import com.minierp.jsf.model.TipoEmpresa;
import com.minierp.jsf.repository.Empresas;
import com.minierp.jsf.repository.RamoAtividades;
import com.minierp.jsf.util.FacesMessages;

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
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private RamoAtividades ramoAtividades;
    
    
    private List<Empresa>listaEmpresas;
    
    private String termoPesquisa;
    
    private Converter ramoAtividadeConverter;
    
    public void pesquisar() {
    	listaEmpresas = empresas.pesquisar(termoPesquisa);
    	
    	if(listaEmpresas.isEmpty()) {
    		messages.info("Sua pesquisa não retornou registros");
    	} 	
    }
    
    //Popular a lista com todas a empresas da base de dados
    public void todasEmpresas() {
    	listaEmpresas = empresas.todas();
    	
    }
    
    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        
        return listaRamoAtividades;
    }
    
    public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
    
    public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
    public String getTermoPesquisa() {
		return termoPesquisa;
	}
    
    public TipoEmpresa [] getTiposEmpresa() {
    	return TipoEmpresa.values();
    }
    public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
    
}
