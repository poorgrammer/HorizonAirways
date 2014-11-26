package com.px1.horizonairways.service;

import com.px1.horizonairways.daimpl.LoginDAImpl;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;

public class LoginService {

	LoginDAImpl LoginDA;
	
	public LoginService() {
	}

	public void setLoginDA(LoginDAImpl loginDA) {
		LoginDA = loginDA;
	}

	public User validateUser(Login log){
		return LoginDA.verifyLogin(log);
	}
	
}
