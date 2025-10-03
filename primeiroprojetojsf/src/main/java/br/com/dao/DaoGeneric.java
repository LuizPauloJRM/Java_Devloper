package br.com.dao;

import br.com.jpautil.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoGeneric<E> {
	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
	

}
