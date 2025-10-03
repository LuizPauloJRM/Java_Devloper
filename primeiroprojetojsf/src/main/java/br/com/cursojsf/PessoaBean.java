package br.com.cursojsf;

// Importações corretas para Jakarta EE
import jakarta.faces.view.ViewScoped; // Anotação de escopo do JSF para Jakarta Faces
import jakarta.inject.Named;

import java.io.Serializable; // Import necessário para beans @ViewScoped e @SessionScoped

// Dependências do seu projeto
import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

/**
 * Classe PessoaBean - Controlador JSF
 *
 * @Named → Torna essa classe um Bean gerenciado pelo CDI,
 *          permitindo que seja acessado nas páginas .xhtml.
 *          É o substituto moderno para a antiga anotação @ManagedBean.
 *
 * ESCOPOS DISPONÍVEIS (CDI):
 *  - @Dependent         → Ciclo de vida dependente do objeto que o injeta (padrão se nenhum escopo for especificado).
 *  - @RequestScoped     → Vida curta: dura apenas 1 requisição (resposta enviada → Bean destruído).
 *  - @ViewScoped        → (Do JSF) Vive enquanto a tela estiver aberta. Ao atualizar a página, mantém os dados.
 *  - @SessionScoped     → Mantém a instância durante toda a sessão do usuário (enquanto não der logout/fechar navegador).
 *  - @ApplicationScoped → Compartilha a mesma instância entre todos os usuários do sistema.
 *
 * OBS: Quando usamos @ViewScoped, @SessionScoped ou @ApplicationScoped, a classe precisa implementar Serializable.
 */
@Named
@ViewScoped // Mantém o Bean ativo enquanto a tela estiver aberta.
public class PessoaBean implements Serializable { // Implemente Serializable para ViewScoped

    private static final long serialVersionUID = 1L; // Necessário para Serializable

    private Pessoa pessoa = new Pessoa();
    private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();

    public void salvar() {
        daoGeneric.salvar(pessoa);
        // Limpa o objeto pessoa após salvar para deixar o formulário pronto para um novo cadastro
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    // Você pode adicionar outros métodos aqui, como carregar lista de pessoas, deletar, etc.
}
