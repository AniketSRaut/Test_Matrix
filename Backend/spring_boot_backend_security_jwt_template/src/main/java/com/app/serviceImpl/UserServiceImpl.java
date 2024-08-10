package com.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.dto.LoginInputDto;
import com.app.dto.LoginOutPutDto;
import com.app.entity.UserEntity;
import com.app.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public LoginOutPutDto loginUser(LoginInputDto input) {
		

		UserEntity u =  userDao.findByEmailAndPasswordAndRole(input.getEmail(), input.getPassword(), input.getRole()).orElseThrow();
		if(u != null) {
			return new LoginOutPutDto(u.getId(),u.getName(),u.getRole().toString());
		}else {
			return null;
		}
		
	}

}
