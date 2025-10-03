package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

/**
 * Classe DAO genérica para operações básicas de persistência.
 * Permite salvar, pesquisar por objeto e pesquisar por ID.
 * 
 * @param <E> Tipo da entidade que será manipulada.
 */
public class DaoGeneric<E> {

    // EntityManager é o responsável pela comunicação com o banco
    private EntityManager entityManager = HibernateUtil.getEntityManager();

    /**
     * Método responsável por salvar uma entidade no banco de dados.
     * Abre uma transação, persiste e commita.
     */
    public void salvar(E entidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entidade); // persiste objeto no BD
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback(); // rollback em caso de erro
            e.printStackTrace();
        }
    }

    /**
     * Pesquisa uma entidade com base na Primary Key extraída do objeto.
     */
    public E pesquisar(E entidade) {
        Object id = HibernateUtil.getPrimaryKey(entidade);
        @SuppressWarnings("unchecked")
        E e = (E) entityManager.find(entidade.getClass(), id);
        return e;
    }

    /**
     * Pesquisa uma entidade diretamente pelo ID e classe.
     */
    public E pesquisar(Long id, Class<E> entidade) {
        @SuppressWarnings("unchecked")
        E e = (E) entityManager.find(entidade, id);
        return e;
    }

    /**
     * Atualiza uma entidade já existente (merge).
     */
    public E updateMerge(E entidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        E entidadeRetorno = null;
        try {
            transaction.begin();
            entidadeRetorno = entityManager.merge(entidade); // faz merge (atualiza ou insere)
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return entidadeRetorno;
    }

    /**
     * Deleta uma entidade com base no objeto.
     */
    public void deletarPorId(E entidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Object id = HibernateUtil.getPrimaryKey(entidade);
            entityManager.remove(entityManager.find(entidade.getClass(), id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
