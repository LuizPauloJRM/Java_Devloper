package com.minierp.jsf.model;

/**
 * Enum que define os tipos de empresa disponíveis no sistema.
 */
public enum TipoEmpresa {
    MEI("Microempreendedor Individual"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anônima"),
    EIRELI("Empresa Individual de Responsabilidade Limitada");

    private String descricao;

    TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
