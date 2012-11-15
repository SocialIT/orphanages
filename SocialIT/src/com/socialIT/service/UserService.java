package com.socialIT.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.socialIT.entity.User;


public class UserService extends GenericService {
	
	 public void addUser(User user){
		 EntityManager em = super.getEntityManager();
		 
		 em.getTransaction().begin();
		 em.persist(user);
		 em.getTransaction().commit();
		 em.close();
	 }
	 
	 public List<User> getUsers(){
		 EntityManager em = super.getEntityManager();
		 
		 Query q = em.createQuery("SELECT u FROM User u");
		 List<User> users = new ArrayList<User>(q.getResultList());
		 return users;
	 }

}
