package br.com.cursojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import java.io.Serializable;

/**
 * Classe PessoaBean - Controlador JSF
 * 
 * @ManagedBean → Torna essa classe um Bean gerenciado pelo JSF,
 *                permitindo que seja acessado nas páginas .xhtml.
 * 
 * ESCOPOS DISPONÍVEIS:
 *  - @NoneScoped        → Cada vez que for chamado é criada uma nova instância (vida curtíssima).
 *  - @RequestScoped     → Vida curta: dura apenas 1 requisição (resposta enviada → Bean destruído).
 *  - @ViewScoped        → Vive enquanto a tela estiver aberta. Ao atualizar a página, mantém os dados.
 *  - @SessionScoped     → Mantém a instância durante toda a sessão do usuário (enquanto não der logout/fechar navegador).
 *  - @ApplicationScoped → Compartilha a mesma instância entre todos os usuários do sistema.
 * 
 * OBS: Quando usamos @ViewScoped ou @SessionScoped, a classe precisa implementar Serializable.
 */
@ManagedBean(name = "pessoaBean")  // Nome usado no XHTML: #{pessoaBean}
@ViewScoped                       // Mantém o Bean ativo enquanto a tela estiver aberta
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L; // Requisito do @ViewScoped

    // Atributos do formulário
    private String nome;
    private String sobrenome;
    private String nomeCompleto;

    // Binding: permite controlar o botão da tela diretamente no backend
    private HtmlCommandButton commandButton;

    /**
     * Método mostrarNome()
     * Concatena nome + sobrenome e salva no atributo nomeCompleto.
     * Retorna "" → permanece na mesma página.
     */
    public String mostrarNome() {
        nomeCompleto = nome + " " + sobrenome;
        return "";
    }

    /**
     * Método addNome()
     * Simula a adição de um nome e altera o texto do botão via binding.
     */
    public String addNome() {
        nomeCompleto = "Adicionado: " + nome + " " + sobrenome;

        if (commandButton != null) {
            commandButton.setValue("Nome já adicionado!");
            // commandButton.setDisabled(true); // Exemplo: desativar botão após clique
        }
        return "";
    }

    // ===================== Getters e Setters ======================

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
