package com.ict.admin.boardlist_member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.boardlist_member.model.vo.Boardlist_Member_VO;

@Repository
public class Boardlist_Member_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 총 게시물 count하기
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("boardlist_member.count");
	}

	// 페이징 기법으로 전체 List 출력하기
	public List<Boardlist_Member_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("boardlist_member.list", map);
	}

	public int getTotalCount_AllSearch(String u_allsearch) {
		return sqlSessionTemplate.selectOne("boardlist_member.count_boardlist_member_allsearch", u_allsearch);
	}

	public List<Boardlist_Member_VO> getBoardlist_Member_AllSearch(int begin, int end, String u_allsearch) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_allsearch", u_allsearch);
		return sqlSessionTemplate.selectList("boardlist_member.list_boardlist_member_allsearch", map);
	}

	public int getTotalCount_Boardlist_Member_Email(String u_email) {
		return sqlSessionTemplate.selectOne("boardlist_member.count_boardlist_member_u_email", u_email);
	}

	public List<Boardlist_Member_VO> getList_Boardlist_Member_Email(int begin, int end, String u_email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_email", u_email);
		return sqlSessionTemplate.selectList("boardlist_member.list_boardlist_member_u_email", map);
	}

	public int getTotalCount_Boardlist_Member_NickName(String u_nickname) {
		return sqlSessionTemplate.selectOne("boardlist_member.count_boardlist_member_u_nickname", u_nickname);
	}

	public List<Boardlist_Member_VO> getList_Boardlist_Member_NickName(int begin, int end, String u_nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_nickname", u_nickname);
		return sqlSessionTemplate.selectList("boardlist_member.list_boardlist_member_u_nickname", map);
	}

	public int getTotalCount_Boardlist_Member_BDay(String u_bday) {
		return sqlSessionTemplate.selectOne("boardlist_member.count_boardlist_member_u_bday", u_bday);
	}

	public List<Boardlist_Member_VO> getList_Boardlist_Member_BDay(int begin, int end, String u_bday) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_bday", u_bday);
		return sqlSessionTemplate.selectList("boardlist_member.list_boardlist_member_u_bday", map);
	}
}
