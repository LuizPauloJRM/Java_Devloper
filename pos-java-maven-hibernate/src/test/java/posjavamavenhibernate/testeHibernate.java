package posjavamavenhibernate;

import org.junit.Test;

import Model.UsuarioPessoa;
import dao.DaoGeneric;

public class testeHibernate {

    /**
     * Testa a inserção de um novo usuário no banco
     */
    @Test
    public void testInserir() {
        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = new UsuarioPessoa();
        pessoa.setIdade(30);
        pessoa.setLogin("luiz");
        pessoa.setNome("Luiz Paulo");
        pessoa.setSenha("123");
        pessoa.setSobrenome("Medeiros");
        pessoa.setEmail("luizpaulo@email.com");

        daoGeneric.salvar(pessoa);
        System.out.println("✅ Usuário salvo com sucesso: " + pessoa);
    }

    /**
     * Testa buscar um usuário pelo ID
     */
    @Test
    public void testBuscar() {
        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        if (pessoa != null) {
            System.out.println("🔎 Usuário encontrado: " + pessoa);
        } else {
            System.out.println("❌ Nenhum usuário encontrado com ID 1");
        }
    }

    /**
     * Testa atualização de dados (merge)
     */
    @Test
    public void testUpdate() {
        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        if (pessoa != null) {
            pessoa.setNome("Luiz Paulo Atualizado");
            pessoa.setEmail("novoemail@email.com");

            daoGeneric.updateMerge(pessoa);
            System.out.println(" Usuário atualizado: " + pessoa);
        } else {
            System.out.println(" Usuário para atualização não encontrado.");
        }
    }

    /**
     * Testa remoção de usuário
     */
    @Test
    public void testDelete() {
        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        if (pessoa != null) {
            daoGeneric.deletarPorId(pessoa);
            System.out.println(" Usuário deletado com sucesso!");
        } else {
            System.out.println(" Usuário para exclusão não encontrado.");
        }
    }
}
