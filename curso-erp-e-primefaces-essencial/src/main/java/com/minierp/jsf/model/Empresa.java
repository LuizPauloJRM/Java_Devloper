package com.minierp.jsf.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que representa uma empresa no sistema Mini ERP.
 * Esta classe é um simples POJO (Plain Old Java Object),
 * usada para armazenar os dados do formulário.
 */
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String razaoSocial;
    private String nomeFantasia;
    private TipoEmpresa tipo;      // Enum (LTDA, SA, MEI, etc.)
    private String cnpj;           // CNPJ formatado (##.###.###/####-##)
    private LocalDate dataFundacao;
    private Double faturamento;

    /* ========================
       Construtor padrão
    =========================*/
    public Empresa() {
    }

    /* ========================
       Getters e Setters
    =========================*/
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }
}
