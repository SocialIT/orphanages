package com.socialIT.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.socialIT.entity.Orphanage;


public class OrphanageService extends GenericService {
	
	public void addOrphanage(Orphanage orphanage){
		EntityManager em = super.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(orphanage);
		em.getTransaction().commit();
	}

	public void updateOrphanage(Orphanage orphanage){
		EntityManager em = super.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(orphanage);
		em.getTransaction().commit();
	}
		
	public List<Orphanage> getOrphanages(){
		EntityManager em = super.getEntityManager();
		
		Query q = em.createQuery("SELECT or FROM Orphanage or");
		List<Orphanage> orphanages = new ArrayList<Orphanage>(q.getResultList());
		return orphanages;
	}
	
	public void deleteOrphanage(Orphanage orphanage){
		EntityManager em = super.getEntityManager();
		em.getTransaction().begin();
		em.remove(orphanage);
		em.getTransaction().commit();
	}
	
}
