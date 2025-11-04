package com.minierp.jsf.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.minierp.jsf.model.Empresa;

/**
 * Classe responsável por realizar operações de acesso aos dados (DAO/Repository)
 * referente à entidade Empresa.
 * 
 * Esta classe é injetada em Services e ManagedBeans usando @Inject.
 */
@Named
@RequestScoped
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    // EntityManager responsável pela conexão com o banco via JPA
    @Inject
    private EntityManager manager;

    // Construtor padrão exigido pelo CDI
    public Empresas() {
    }

    // Construtor alternativo (útil em testes ou casos sem injeção)
    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    /* 
     * Busca uma empresa pelo seu ID.
     * Exemplo: empresas.porId(1L);
     */
    public Empresa porId(Long id) {
        return manager.find(Empresa.class, id);
    }

    /* 
     * Pesquisa todas as empresas cadastradas no banco.
     * Equivalente a: SELECT * FROM Empresa;
     */
    public List<Empresa> todasEmpresas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

    /* 
     * Pesquisa empresas filtrando pelo nome fantasia.
     * Usa o operador LIKE para buscar nomes iniciados pelo termo informado.
     * Exemplo: pesquisar("A") → retorna empresas começando com "A".
     */
    public List<Empresa> pesquisar(String nome) {
        String jpql = "from Empresa where nomeFantasia like :nomeFantasia";

        TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);

        /*Pesquisar por letra, tipando*/
        query.setParameter("nomeFantasia", nome + "%");

        return query.getResultList();
    }

    //Listar todas as empresas
    public List<Empresa> todas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

    /* 
     * Método guardar: insere ou atualiza a empresa no banco.
     * - Se for nova (sem ID), faz INSERT.
     * - Se já existir (com ID), faz UPDATE.
     */
    public Empresa guardar(Empresa empresa) {
        return manager.merge(empresa);
    }

    /* 
     * Remove uma empresa existente.
     * Antes de remover, busca pelo ID para garantir que o objeto esteja 
     * gerenciado pelo contexto de persistência.
     */
    public void remover(Empresa empresa) {
        // Antes de remover, buscar por id (garante que o objeto existe no banco)
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }
}
