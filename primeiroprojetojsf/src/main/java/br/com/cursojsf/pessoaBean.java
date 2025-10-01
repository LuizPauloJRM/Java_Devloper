package br.com.cursojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton; // Import necessário para o binding

/*Nomeado para pessoaBean ao chamar Managed*/
/*Scoped*/
/*
 * @NoneScope - Cada vez que for chamado é instanciado 
 * @ViewScoped - Enquanto tiver a tela aberta a instancia vai ser uma só
 * @SessionScoped - Mantém instancia durante diversas requisições, mantem na seção segurando os dados
 * @RequestScoped - (Padrão) , vida curta , termina quando a resposta é enviada ao cliente
 * @ApplicationScoped - Distribui os dados iguais para todas seções 
 */
@ViewScoped
@ManagedBean(name = "pessoaBean")
@RequestScoped
public class pessoaBean {
	
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	// Binding: permite que o backend controle o componente diretamente 
	private HtmlCommandButton commandButton;

	/* Método chamado pelo botão "Mostrar Nome" */
	public String mostrarNome() {
		nomeCompleto = nome + " " + sobrenome;
		return "";
	}
	
	/* Método extra para o botão com binding */
	public String addNome() {
		nomeCompleto = "Adicionado: " + nome + " " + sobrenome;

		// Exemplo: muda o texto do botão depois de clicar
		if (commandButton != null) {
			commandButton.setValue("Nome já adicionado!");
			// commandButton.setDisabled(true); // Caso queira desativar o botão após clique
		}
		
		return "";
	}

	/* Setters e Getters */
	/* Primeira estrutura de um ManagedBean - Controlador */
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	
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
