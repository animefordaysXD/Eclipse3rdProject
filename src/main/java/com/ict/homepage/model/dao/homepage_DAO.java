package com.ict.homepage.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.homepage.model.vo.homepage_VO;

@Repository
public class homepage_DAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<homepage_VO> homepageList() {
		return sqlSessionTemplate.selectList("getList");
	}	

	//값을 입력해서 넣어줘야 하니까~?
	public int homepageInsert(homepage_VO hvo) throws Exception{
	 return sqlSessionTemplate.insert("homepage.insert", hvo);	
	}
	
	

}
