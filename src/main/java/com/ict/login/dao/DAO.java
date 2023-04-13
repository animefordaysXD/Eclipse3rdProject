package com.ict.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.login.service.VO.VO;

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
	public int getId(VO vo) {
		 
		 int count = sqlSessionTemplate.selectOne("login.email",vo);
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
	public int getKakao(VO vo) {
		System.out.println("kak email " + vo.getEmail());
		return sqlSessionTemplate.selectOne("login.getKakao",vo);
	}
	public int getNaver(VO vo) {
		return sqlSessionTemplate.selectOne("login.getNaver",vo);
	}
	public int checkHash(String hash) {
		return sqlSessionTemplate.selectOne("login.checkHash",hash);
	}
	public String getHash(String email) {
		return sqlSessionTemplate.selectOne("login.getHash",email);
	}
	
	public int setProf(VO vo) {
		return sqlSessionTemplate.update("login.setProf", vo);
	}
	public VO getProf(String hash) {
		return sqlSessionTemplate.selectOne("login.getProfile", hash);
	}
	public String getAttendDates(String hash) {
		return sqlSessionTemplate.selectOne("login.getAttendDates",hash);
	}
	public int insertAttend(VO vo) {
		return sqlSessionTemplate.update("login.setAttendDate",vo);
	}
	public int insertCity(VO vo) {
		return sqlSessionTemplate.update("login.setCity",vo);
	}
	public int insertNick(VO vo) {
		return sqlSessionTemplate.update("login.setNick", vo);
	}



}
