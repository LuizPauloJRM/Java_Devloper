package com.minierp.jsf.repository;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.minierp.jsf.model.Empresa;

@Named
@RequestScoped
public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	/*Pesquisa por todas empresas*/
	public List<Empresa> todasEmpresas() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	/*Pesquisa por empresas*/
	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";

		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
		
		/*Pesquisar por letra, tipando*/
		query.setParameter("nomeFantasia", nome + "%");

		return query.getResultList();
	}
	
	public List<Empresa> todas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	/*Método guardar, atualizar com banco de dados*/
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}
	/*Remover*/
	public void remover(Empresa empresa) {
		/*Antes de remover buscar por id, so remove objetos que ta no contexto, assim existindo na base de dados*/
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}
