package com.minierp.id;

public class Main {
	public static void main(String[] args) {
		Pedidos pedidos = new Pedidos();
		/*Injeção de dependencias*/
		RelatorioService relatorioService = new RelatorioService();
		/*relatorioService.setPedidos(pedidos);*/
		
	}
}
