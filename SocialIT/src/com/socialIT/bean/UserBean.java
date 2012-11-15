package com.socialIT.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.socialIT.entity.User;


@ManagedBean
@SessionScoped
public class UserBean {
	
	List<User> users = new ArrayList<User>();

	
	
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
