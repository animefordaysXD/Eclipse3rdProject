package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.DAO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	@Override
	public int getId(String email) {
		return dao.getId(email);
	}
	

}
