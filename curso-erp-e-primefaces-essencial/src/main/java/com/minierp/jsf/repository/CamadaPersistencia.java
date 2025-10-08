package com.minierp.jsf.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.minierp.jsf.model.Empresa;
import com.minierp.jsf.model.RamoAtividade;

public class CamadaPersistencia {
	public static void main(String[]args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("minierp");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		/*Declarando os repositórios*/
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em); // Linha corrigida: o tipo da variável deve ser Empresas
		
		
		/*Buscando as informaçoes do banco*/
		List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa>listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);
		
		/*Criando empresa*/
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("Luiz Paulo");
		empresa.setCnpj("41.952.519/001-57");
		empresa.setRazaoSocial("Luiz Paulo Medeiros");
		/*empresa.setDataFundacao(new Date());*/
		empresa.setRamoAtividade(listaDeRamoAtividades.get(0));
		/*empresa.setTipo(TipoEmpresa."MEI");*/
		
		/*Salvando a empresa*/
		empresas.guardar(empresa);
		/*Commit da transação*/
		em.getTransaction().commit();
		
		/*Verificando se a inserção funciona*/
		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		System.out.println(listaDeEmpresas2);
		
		em.close();
		emf.close();
		
		
	}

}
