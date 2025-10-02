package posjavamavenhibernate;

import javax.persistence.EntityManager;
import org.junit.Test;
import Model.UsuarioPessoa; // Importe a classe de modelo

public class testeHibernate {

    @Test
    public void testeHibernateUtil() {
        // Obtém o EntityManager para testar a conexão
        EntityManager em = HibernateUtil.getEntityManager();

        // Verifica se a conexão foi bem-sucedida (não nula)
        if (em != null) {
            System.out.println("✅ Conexão criada com sucesso!");

            // Exemplo de uma operação de persistência simples para confirmar o funcionamento
            em.getTransaction().begin();
            UsuarioPessoa usuario = new UsuarioPessoa();
            usuario.setNome("João");
            usuario.setSobrenome("Silva");
            em.persist(usuario);
            em.getTransaction().commit();
            System.out.println("✅ Entidade persistida com sucesso!");

            // Fecha o EntityManager
            em.close();
        } else {
            System.out.println("❌ Falha ao criar a conexão.");
        }
    }
}
