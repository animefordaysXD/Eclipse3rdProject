package com.ict.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/*
	 * public int getId(String email) { String a = email.trim(); int count =
	 * sqlSessionTemplate.selectOne("login.email", a);
	 * System.out.println("count is "+count); return count > 0 ? 1 : 0; }
	 */
	public int getId(String email) {
		 String a = email.trim();
		 System.out.println("a is " + a);
		 int count = sqlSessionTemplate.selectOne("login.email",a);
		    System.out.println("count is "+count);
		    return count > 0 ? 1 : 0;
//		String a = "abc@naver.com";
//		int b = sqlSessionTemplate.selectOne("login.email", a);
//		System.out.println("get Email is " + b);
//		return 0;
	}




}
