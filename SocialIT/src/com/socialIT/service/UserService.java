package com.socialIT.service;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.socialIT.entity.Orphanage;
import com.socialIT.entity.User;


@ManagedBean(name="userService")
public class UserService {
	
	public boolean isThereEmail(String email)
	{ 
		boolean verifyEmail=false;
		//verifyEmail=userDao.isThereComponent("email", email);
		return verifyEmail;	
	}

	
	 public boolean isThereNickName(String nickname)
	 { 
		 boolean verifyNickName=false;
		 //verifyNickName=userDao.isThereComponent("nickName", nickname);
	 	return verifyNickName; 
	 }
	
	 public void addUser(String userName, String name, String surname, String password, String email, String phone){
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SocialIT");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			User user = new User();
			user.setUserName(userName);
			user.setFirstName(name);
			user.setLastName(surname);
			
			
	
			
			
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		 
		 
	 }

}
