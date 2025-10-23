package com.minierp.jsf.model;

/**
 * Enum que representa os tipos de empresas (personalidades jurídicas).
 * Esta abordagem centraliza as constantes e suas descrições em um único
 * local, melhorando a segurança de tipo e a manutenção do código.
 * Cada constante possui uma descrição associada para facilitar a exibição
 * em interfaces de usuário, como o formulário de cadastro.
 */
public enum TipoEmpresa {
	
	/**
	 * Microempreendedor Individual (MEI).
	 */
	MEI("Microempreendedor Individual"),
	
	/**
	 * Empresa Individual de Responsabilidade Limitada (EIRELI).
	 */
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	
	/**
	 * Sociedade Limitada (LTDA).
	 */
	LTDA("Sociedade Limitada"),
	
	/**
	 * Sociedade Anônima (S/A).
	 */
	SA("Sociedade Anônima");
	
	/**
	 * Campo privado para armazenar a descrição do tipo de empresa.
	 */
	private String descricao;
	
	/**
	 * Construtor do enum.
	 * Um construtor de um enum é implicitamente privado e é chamado
	 * automaticamente para cada constante definida no momento da inicialização.
	 * 
	 * @param descricao A descrição textual do tipo de empresa.
	 */
	TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna a descrição completa do tipo de empresa.
	 * 
	 * @return A descrição do tipo de empresa.
	 */
	public String getDescricao() {
		return descricao;
	}
}
