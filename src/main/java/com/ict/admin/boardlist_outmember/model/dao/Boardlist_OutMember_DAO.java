package com.ict.admin.boardlist_outmember.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.boardlist_outmember.model.vo.Boardlist_OutMember_VO;

@Repository
public class Boardlist_OutMember_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("boardlist_outmember.count");
	}

	public List<Boardlist_OutMember_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("boardlist_outmember.list", map);
	}
	
	public int getBoardlist_OutMember_DeleteComplete(String u_idx) {
		return sqlSessionTemplate.delete("boardlist_outmember.outmember_deletecomplete", u_idx); 
	}

	public int getTotalCount_AllSearch(String u_allsearch) {
		return sqlSessionTemplate.selectOne("boardlist_outmember.count_boardlist_outmember_allsearch", u_allsearch);
	}

	public List<Boardlist_OutMember_VO> getBoardlist_OutMember_AllSearch(int begin, int end, String u_allsearch) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_allsearch", u_allsearch);
		return sqlSessionTemplate.selectList("boardlist_outmember.list_boardlist_outmember_allsearch", map);
	}

	public int getTotalCount_Boardlist_OutMember_Email(String u_email) {
		return sqlSessionTemplate.selectOne("boardlist_outmember.count_boardlist_outmember_u_email", u_email);
	}

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_Email(int begin, int end, String u_email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_email", u_email);
		return sqlSessionTemplate.selectList("boardlist_outmember.list_boardlist_outmember_u_email", map);
	}

	public int getTotalCount_Boardlist_OutMember_NickName(String u_nickname) {
		return sqlSessionTemplate.selectOne("boardlist_outmember.count_boardlist_outmember_u_nickname", u_nickname);
	}

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_NickName(int begin, int end, String u_nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_nickname", u_nickname);
		return sqlSessionTemplate.selectList("boardlist_outmember.list_boardlist_outmember_u_nickname", map);
	}

	public int getTotalCount_Boardlist_OutMember_BDay(String u_bday) {
		return sqlSessionTemplate.selectOne("boardlist_outmember.count_boardlist_outmember_u_bday", u_bday);
	}

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_BDay(int begin, int end, String u_bday) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_bday", u_bday);
		return sqlSessionTemplate.selectList("boardlist_outmember.list_boardlist_outmember_u_bday", map);
	}

}
