package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável por inicializar o Hibernate
 * usando o arquivo persistence.xml.
 * 
 * O padrão é utilizar um EntityManagerFactory único (Singleton)
 * para toda a aplicação.
 */
public class HibernateUtil {
	
	/* Ler arquivo persistence , ao subir pro banco para fazer alterações */
	public static EntityManagerFactory factory = null;

	static {
		init();
	}

	private static void init() {
		try {
			// Cria a fábrica se ainda não existir
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Promove a parte de persistência , criando EntityManager */
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	/*Retorno de primary Key*/
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
