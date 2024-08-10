package com.app.service;

import com.app.dto.LoginInputDto;
import com.app.dto.LoginOutPutDto;

public interface UserService {
	
	public LoginOutPutDto loginUser(LoginInputDto input);

}
