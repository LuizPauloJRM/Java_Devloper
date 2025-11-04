package com.minierp.jsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.repository.Empresas;
import com.minierp.jsf.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }


}