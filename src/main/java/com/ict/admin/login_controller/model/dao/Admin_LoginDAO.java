package com.ict.admin.login_controller.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.login_controller.model.vo.Admin_LoginVO;

@Repository
public class Admin_LoginDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getAdmin(Admin_LoginVO vo) {
		return sqlSessionTemplate.selectOne("admin_login.getAdmin", vo);
	}

}
