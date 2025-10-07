package com.minierp.jsf.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("minierp");
		
	}
	
}
