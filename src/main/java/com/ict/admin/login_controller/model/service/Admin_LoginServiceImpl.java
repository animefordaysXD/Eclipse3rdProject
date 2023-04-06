package com.ict.admin.login_controller.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.login_controller.model.dao.Admin_LoginDAO;
import com.ict.admin.login_controller.model.vo.Admin_LoginVO;

@Service
public class Admin_LoginServiceImpl implements Admin_LoginService {

	@Autowired
	private Admin_LoginDAO loginDAO;

	public void setLoginDAO(Admin_LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public int getAdmin(Admin_LoginVO vo) {
		return loginDAO.getAdmin(vo);
	}

}
