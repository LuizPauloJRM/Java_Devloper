package br.com.cursojsf;

import javax.faces.bean.ManagedBean;

/*Nomeado para pessoaBean ao chamar Managed*/
@ManagedBean(name = "pessoaBean")
public class pessoaBean {
	private String nome;
	private String sobrenome;
	private String nomeCompleto;

	public String mostrarNome() {
		nomeCompleto = nome +" "+ sobrenome;
		return "";
	}

	/* Setters e Getters */
	/* Primeira estrutura de um managed Bean - Controlador */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
