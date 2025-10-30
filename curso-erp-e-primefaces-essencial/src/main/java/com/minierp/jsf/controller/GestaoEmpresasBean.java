package com.minierp.jsf.controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped; // Escopo de visão (mantém o estado enquanto o usuário estiver na mesma view)

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.model.TipoEmpresa;

/**
 * Classe controladora responsável pela gestão das empresas.
 * É um Managed Bean acessado diretamente pelas páginas XHTML via EL #{gestaoEmpresasBean}.
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    /* Representa a empresa que está sendo criada/editada na tela */
    private Empresa empresa = new Empresa();

    /**
     * Método responsável por salvar a empresa.
     * (Aqui está apenas simulando o salvamento, exibindo no console.)
     */
    public void salvar() {
        System.out.println("Razão social: " + empresa.getRazaoSocial()
                + " | Nome fantasia: " + empresa.getNomeFantasia()
                + " | Tipo: " + empresa.getTipo());
    }
 
    /**
     * Método usado para navegar para a página de ajuda.
     * Retorna o nome do arquivo XHTML sem a extensão (.xhtml).
     */
    public String ajuda() {
        return "AjudaGestaoEmpresas?faces-redirect=true";
    }

    /* Getter e Setter */
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /* Retorna os tipos de empresa definidos no enum TipoEmpresa */
    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }
}
