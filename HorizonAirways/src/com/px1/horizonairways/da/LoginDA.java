package com.px1.horizonairways.da;

import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;

public interface LoginDA {

	public User verifyLogin(Login login);
	
}
