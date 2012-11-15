package com.socialIT.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.socialIT.entity.Orphanage;
import com.socialIT.entity.User;


public class UserService extends GenericService {
	
	/*public boolean isThereEmail(String email){ 
		boolean verifyEmail=false;
		//verifyEmail=userDao.isThereComponent("email", email);
		return verifyEmail;	
	}

	
	 public boolean isThereNickName(String nickname)
	 { 
		 boolean verifyNickName=false;
		 //verifyNickName=userDao.isThereComponent("nickName", nickname);
	 	return verifyNickName; 
	 }*/
	
	 public void addUser(User user){
		 EntityManager em = super.getEntityManager();
		 
		 em.getTransaction().begin();
		 em.persist(user);
		 em.getTransaction().commit();
		 em.close();
	 }

}
