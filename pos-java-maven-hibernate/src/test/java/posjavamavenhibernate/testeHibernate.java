package posjavamavenhibernate;

import javax.persistence.EntityManager;
import org.junit.Test;

public class testeHibernate {

	@Test
	public void testeHibernateUtil() {
		// Teste de conexão com banco
		EntityManager em = HibernateUtil.getEntityManager();
		System.out.println("✅ Conexão criada com sucesso: " + em);
		em.close();
	}
}
