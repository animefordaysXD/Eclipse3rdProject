package com.ict.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.service.VO.VO;

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
	
	public int getNick(String nickName) {
		String a = nickName.trim();
		int count = sqlSessionTemplate.selectOne("login.nick",a);
		return count > 0 ? 1 : 0;
	}
	
	public int getInsert(VO vo) {
		int result = sqlSessionTemplate.insert("login.getReg", vo);
		return result;
	}
	public int getLogin(VO vo) {
		return sqlSessionTemplate.selectOne("login.getLog", vo);
	}
	public int getAdmin(VO vo) {
		return sqlSessionTemplate.selectOne("login.getAdmin",vo);
	}




}
