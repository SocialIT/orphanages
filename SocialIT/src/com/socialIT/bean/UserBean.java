package com.socialIT.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.socialIT.service.UserService;


@ManagedBean
public class UserBean {
	
	private String userName;
	private String surname;
	private String name;
	private String password;
	private String password2;
	private String email;
	private String email2;
	private String phone;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	public boolean stringEmailVerify() {
		boolean verify = false;
		if (email.equals(email2)) {
			verify = true;
		}
		return verify;
	}

	public boolean verifyPassword() {
		boolean verifyPass = false;
		if (password.equals(password2)) {
			verifyPass = true;
		}
		return verifyPass;
	}

	public boolean verifyEmail() {
		return userService.isThereEmail(email);
	}

	public boolean verifyNickName() {
		return userService.isThereNickName(userName);
	}
	
	
	public void submit(){
		boolean emailVerify = stringEmailVerify();
		boolean passVerify = verifyPassword();
		boolean isEmailOK = verifyEmail();
		boolean isNickNameOK = verifyNickName();
		
		
		
		
		if (passVerify == true){
			
			userService.addUser(userName, name, surname, password, email, phone);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("Utilizatorul a fost creat")));
			
		}

		else
		// error messages
		{

			// email doesn't match
			if (emailVerify == false) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("Email-urile nu coincid")));
			}

			// passwords doesn't match
			if (passVerify == false) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Parolele nu coincid")));
			}

			// nick name is already used
			if (isNickNameOK == true) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Numele utilizatorul este deja folosit")));
			}
			// email is used
			if (isEmailOK == true) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("Email-ul este deja folosit")));	
			}
		}
}	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
