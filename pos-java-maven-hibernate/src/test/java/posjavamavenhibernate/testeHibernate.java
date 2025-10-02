package posjavamavenhibernate;

import org.junit.Test;

import Model.UsuarioPessoa; // Importe a classe de modelo
import dao.DaoGeneric; // Seu DAO genérico para operações de persistência

public class testeHibernate {

	@Test
	public void testeHibernateUtil() {
		/*
		 * 🔹 Primeira forma (comentada): Testando a conexão diretamente com EntityManager
		 * 
		 * // Obtém o EntityManager para testar a conexão
		 * EntityManager em = HibernateUtil.getEntityManager();
		 * 
		 * // Verifica se a conexão foi bem-sucedida (não nula)
		 * if (em != null) {
		 *     System.out.println("✅ Conexão criada com sucesso!");
		 * 
		 *     // Exemplo de uma operação de persistência simples para confirmar o funcionamento
		 *     em.getTransaction().begin();
		 *     UsuarioPessoa usuario = new UsuarioPessoa();
		 *     usuario.setNome("João");
		 *     usuario.setSobrenome("Silva");
		 *     em.persist(usuario);
		 *     em.getTransaction().commit();
		 *     System.out.println("✅ Entidade persistida com sucesso!");
		 * 
		 *     // Fecha o EntityManager
		 *     em.close();
		 * } else {
		 *     System.out.println("❌ Falha ao criar a conexão.");
		 * }
		 */

		/*
		 * 🔹 Segunda forma (usando DaoGeneric): Mais limpa, aproveitando o DAO para salvar
		 * objetos sem precisar abrir e fechar transações manualmente.
		 */
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		// Criando um novo usuário para persistir no banco
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setIdade(45);
		pessoa.setLogin("teste");
		pessoa.setNome("Luiz Paulo");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Medeiros");
		pessoa.setEmail("luizpaulo@email.com");

		// Persistindo no banco com DAO genérico
		daoGeneric.salvar(pessoa);

		System.out.println("✅ Usuário salvo com sucesso via DaoGeneric!");
		
		
	}
	@Test
	public void testBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric= new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa= new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric= new DaoGeneric<UsuarioPessoa>();
		
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L, UsuarioPessoa.class);
		System.out.println(pessoa);
		
	}
	
}
