package com.minierp.jsf.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.minierp.jsf.model.RamoAtividade;

public class RamoAtividades implements Serializable{
	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	public RamoAtividades() {

	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}

	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		/*Select do banco ,select ra. * from ramo_atividade ra; */
		criteriaQuery.select(root);
		/*por descrição "like" , buscar por todas empresa com letra determinada*/
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));

		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);

		return query.getResultList();
	}
}
