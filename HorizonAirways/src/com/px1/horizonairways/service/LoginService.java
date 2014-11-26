package com.px1.horizonairways.service;

import com.px1.horizonairways.da.LoginDA;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;

public class LoginService {

	LoginDA LoginDA;
	
	public LoginService() {
	}

	public void setLoginDA(LoginDA loginDA) {
		LoginDA = loginDA;
	}

	public User validateUser(Login log){
		return LoginDA.verifyLogin(log);
	}
	
}
