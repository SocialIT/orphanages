package com.socialIT.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.socialIT.entity.Bank;
import com.socialIT.entity.Contact;
import com.socialIT.entity.Need;
import com.socialIT.entity.Orphanage;

@ManagedBean(name="orphanageService")
@ApplicationScoped
public class OrphanageService {

	@PersistenceContext
	public EntityManager em;
	
	private Orphanage orphanageObject;
	
	
	public void addOrphanage(String name, String details, String address, int location){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Orphanage orphanage = new Orphanage();
		orphanage.setName(name);
		orphanage.setDetails(details);
		orphanage.setAddress(address);
		orphanage.setLocationId(location);
		
		entityManager.persist(orphanage);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
	public void updateOrphanage(String name, String details, String address, int location, long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
	
	public Orphanage getOrphanageObject() {
		return orphanageObject;
	}

	public void setOrphanageObject(Orphanage orphanageObject) {
		System.out.println("obejct set");
		this.orphanageObject = orphanageObject;
	}

	public Orphanage getOrphanageById(long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Orphanage result = entityManager.find(Orphanage.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
	
	public List<Contact> getOrphanageContacts(long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Contact> contacts = entityManager.createQuery("select c from Contact c where c.orphanageId = :id",Contact.class)
				.setParameter("id", id)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return contacts;
	}

	public List<Need> getOrphanageNeeds(long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Need> needs = entityManager.createQuery("select need from Need need where need.orphanageId = :id", Need.class)
				.setParameter("id",id)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return needs;
	}
	
	public List<Bank> getOrphanageAccounts(long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Bank> bankAccount = entityManager.createQuery("select c from Bank c where c.orphanageId = :id", Bank.class)
				.setParameter("id", id)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return bankAccount;
		
	}

	public List<Orphanage> retriveOrphanages() {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Orphanage> orphanages = entityManager.createQuery("select c from Orphanage c", Orphanage.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		/*for(Orphanage result : orphanages){
			System.out.println(result.getName());
		}*/
		
		return orphanages;
	}
	
	public void deleteOrphanage(long id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Orphanage orphanage = entityManager.find(Orphanage.class,id);
		entityManager.remove(orphanage);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
}
