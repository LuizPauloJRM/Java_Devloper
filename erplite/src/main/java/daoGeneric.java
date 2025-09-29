package br.com.mini.erp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class DaoGeneric<T> {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("miniERP");

    public T merge(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T merged = em.merge(entity);
            em.getTransaction().commit();
            return merged;
        } finally {
            em.close();
        }
    }

    public void delete(Class<T> clazz, Object id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T ref = em.find(clazz, id);
            if (ref != null) em.remove(ref);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<T> listAll(Class<T> clazz) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        } finally {
            em.close();
        }
    }
}
