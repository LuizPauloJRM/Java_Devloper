package br.com.jpautil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	// A fábrica de gerenciadores de entidades, estática para ser única na aplicação.
	private static EntityManagerFactory factory;

	static {
		// Bloco estático, executado apenas uma vez quando a classe é carregada.
		if (factory == null) {
			// Cria a fábrica usando o nome da unidade de persistência definida no persistence.xml.
			factory = Persistence.createEntityManagerFactory("primeiroprojetojsf");
		}
	}

	// Método estático para obter um EntityManager a partir da fábrica.
	// Cada chamada retorna um novo EntityManager.
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	// Método opcional para obter a fábrica de forma centralizada.
	public static EntityManagerFactory getFactory() {
		return factory;
	}
}