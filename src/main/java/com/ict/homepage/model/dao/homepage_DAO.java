package com.ict.homepage.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.homepage.model.vo.notification_VO;
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
	
	public String getHashForRoomMake(String hash) {
		return sqlSessionTemplate.selectOne("getHashForRoomMake", hash);
	}
	
	public int createRoomNoti(notification_VO avo) {
		int result= sqlSessionTemplate.insert("createRoomNot", avo);
		return avo.getRoom_idx();
	}
	public int getUserIdx(String hash) {
		return sqlSessionTemplate.selectOne("getUIDX", hash);
	}
	public List<notification_VO> getNotif(int idx){
		return sqlSessionTemplate.selectList("getNotif", idx);
	}
	public int getNotifCount(int idx) {
		return sqlSessionTemplate.selectOne("getNotifCount", idx);
	}
	public int deleteNotif(int idx) {
		
		return sqlSessionTemplate.delete("deleteNotif", idx);
	}
	

}
