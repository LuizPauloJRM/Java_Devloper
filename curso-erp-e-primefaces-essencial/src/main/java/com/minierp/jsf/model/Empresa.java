package com.minierp.jsf.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa a entidade Empresa, mapeada para a tabela "empresa" no banco de dados.
 * Implementa a interface Serializable para permitir que objetos da classe possam ser
 * convertidos em um fluxo de bytes e vice-versa, o que é útil para operações de rede
 * e persistência de dados.
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos de persistência e de negócio

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_fantasia", nullable = false, length = 80)
	private String nomeFantasia;

	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;

	@Column(nullable = false, length = 18)
	private String cnpj;

	@Column(name = "data_fundacao")
	private LocalDate dataFundacao;

	/*
	 * Relacionamento Muitos para Um (ManyToOne) com RamoAtividade.
	 * Muitas empresas podem estar associadas a um único ramo de atividade.
	 * A anotação @JoinColumn especifica a coluna que será usada para a junção na tabela de empresas.
	 */
	@ManyToOne
	@JoinColumn(name = "ramo_atividade_id", nullable = false)
	private RamoAtividade ramoAtividade;

	/*
	 * Mapeia o enum TipoEmpresa para uma coluna de tipo String no banco de dados.
	 * A anotação @Enumerated(EnumType.STRING) garante que o nome do enum seja persistido.
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private TipoEmpresa tipo;

	// Métodos Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public TipoEmpresa getTipo() {
		return tipo;
	}

	/**
	 * Setter para a propriedade 'tipo'.
	 * Este é o método que estava faltando ou implementado de forma incorreta e que causou o erro.
	 * @param tipo O tipo da empresa a ser definido.
	 */
	public void setTipo(TipoEmpresa tipo) {
		this.tipo = tipo;
	}

	// Métodos de utilidade

	/**
	 * Gera um código hash para o objeto com base no seu ID.
	 * Útil para operações em coleções, como HashMap e HashSet.
	 * @return O código hash do objeto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Compara se este objeto é igual a outro, com base no ID.
	 * @param obj O objeto a ser comparado.
	 * @return true se os objetos forem iguais, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Retorna uma representação em string do objeto, útil para fins de depuração.
	 * @return Uma string contendo o ID da empresa.
	 */
	@Override
	public String toString() {
		return "Empresa [id=" + id + "]";
	}
}
