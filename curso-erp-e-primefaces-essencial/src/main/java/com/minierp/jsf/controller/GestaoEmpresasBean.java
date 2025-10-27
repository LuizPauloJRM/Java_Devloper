package com.minierp.jsf.controller;

import java.io.Serializable;
import javax.inject.Named;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.model.TipoEmpresa;


/*Acessiveis a pagina xhtml com essa anotação*/
@Named
/*Scoped: Requisição , vida util de uma instancia se inicia ao criar  */
@javax.faces.view.ViewScoped
public class GestaoEmpresasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/*Propriedade estatica*/
	//private static Integer NUMERO=0;
	
	/*Construtor*/
	//public GestaoEmpresasBean() {
		//NUMERO++;
	//}
	
	/*GET */
	//public static Integer getNUMERO() {
		//return NUMERO;
	//}
	private Empresa empresa = new Empresa();
	
	public void salvar() {
		System.out.println("Razão social : " +empresa.getRazaoSocial()
				+ " Nome fantasia "+empresa.getNomeFantasia()
				+ " Tipo: "+ empresa.getTipo());
	}
	
	public String ajuda(){
		return "AjudaGestaoEmpresas";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public TipoEmpresa [] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	
		
	
}
