package com.socialIT.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.socialIT.entity.Location;


@ManagedBean(name="locationService")
public class LocationService {
	
	
	@PersistenceContext
	public EntityManager em;
		
	public List<Location> getAllLocations(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Location> locations = entityManager.createQuery("select c from Location c", Location.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return locations;
	}
	
	public Integer getLocationByName(String location){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Location locationObject = entityManager.createQuery("select c from Location c where c.location = :location",Location.class)
				.setParameter("location",location)
				.getSingleResult();				
		System.out.println("locatio id is "+locationObject.getId());
		return locationObject.getId();
	}

}
