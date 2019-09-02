package com.pradeep.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isVaidUser(String name,String password) {
		
		return name.equals("admin") && password.equals("admin@123");
	}

}
