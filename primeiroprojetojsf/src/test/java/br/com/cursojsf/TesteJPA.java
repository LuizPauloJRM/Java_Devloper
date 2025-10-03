package br.com.cursojsf;

import jakarta.persistence.Persistence;

public class TesteJPA {
	public static void main(String[] args) {
		// Chama o método para criar a fábrica de gerenciadores.
		// Apenas chamar essa linha fará com que o Hibernate tente conectar ao banco.
		// Se a conexão for bem-sucedida, não haverá exceção.
		Persistence.createEntityManagerFactory("primeiroprojetojsf");

		// Ou, para testar sua classe JPAUtil, você pode fazer:
		// JPAUtil.getFactory();
		// System.out.println("Conexão estabelecida com sucesso!");
	}
}
