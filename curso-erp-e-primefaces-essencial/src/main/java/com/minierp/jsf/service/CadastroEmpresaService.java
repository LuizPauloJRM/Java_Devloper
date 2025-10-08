package com.minierp.jsf.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.repository.Empresas;

public class CadastroEmpresaService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Transactional
	public void salvar(Empresa empresa) {
		Empresa.guardar(empresa);
	}

	@Transactional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
