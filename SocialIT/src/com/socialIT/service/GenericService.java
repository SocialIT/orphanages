package com.socialIT.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericService {
	protected EntityManager em;
	public EntityManager getEntityManager(){
		if(em == null || !em.isOpen()){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SocialIT");
			em = emf.createEntityManager();
		}
		return em;
	}
}
