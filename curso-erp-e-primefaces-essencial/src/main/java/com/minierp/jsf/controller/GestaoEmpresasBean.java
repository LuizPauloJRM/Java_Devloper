package com.minierp.jsf.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/*Acessiveis a pagina xhtml com essa anotação*/
@Named
/*Scoped: Requisição , vida util de uma instancia se inicia ao criar  */
@RequestScoped
public class GestaoEmpresasBean implements Serializable{
	/*Propriedade estatica*/
	private static Integer NUMERO=0;
	
	/*Construtor*/
	public GestaoEmpresasBean() {
		NUMERO++;
	}
	
	/*GET */
	public static Integer getNUMERO() {
		return NUMERO;
	}
}
