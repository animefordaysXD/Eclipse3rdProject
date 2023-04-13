package com.ict.admin.userlist_super.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.userlist_super.model.vo.Userlist_Super_VO;

@Repository
public class Userlist_Super_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("userlist_super.count");
	}

	public List<Userlist_Super_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("userlist_super.list", map);
	}

	public int getUserCreate(Userlist_Super_VO userlist_Super_VO) {
		return sqlSessionTemplate.insert("userlist_super.usercreate", userlist_Super_VO);
	}

	public int getUser_IdCheck(String user_id) {
		return sqlSessionTemplate.selectOne("userlist_super.user_idcheck", user_id);
	}

	public int getUser_NicknameCheck(String user_nickname) {
		return sqlSessionTemplate.selectOne("userlist_super.user_nicknamecheck", user_nickname);
	}

	public int getUserDelete(String u_idx) {
		return sqlSessionTemplate.delete("userlist_super.userdelete", u_idx);
	}

	public int getTotalCount_AllSearch(String u_allsearch) {
		return sqlSessionTemplate.selectOne("userlist_super.count_u_allsearch", u_allsearch);
	}

	public List<Userlist_Super_VO> getList_U_AllSearch(int begin, int end, String u_allsearch) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_allsearch", u_allsearch);
		return sqlSessionTemplate.selectList("userlist_super.list_u_allsearch", map);
	}

	public int getTotalCount_U_Idx(String u_idx) {
		return sqlSessionTemplate.selectOne("userlist_super.count_u_idx", u_idx);
	}

	public List<Userlist_Super_VO> getList_U_Idx(int begin, int end, String u_idx) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_idx", u_idx);
		return sqlSessionTemplate.selectList("userlist_super.list_u_idx", map);
	}

	public int getTotalCount_U_Email(String u_email) {
		return sqlSessionTemplate.selectOne("userlist_super.count_u_email", u_email);
	}

	public List<Userlist_Super_VO> getList_U_Email(int begin, int end, String u_email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_email", u_email);
		return sqlSessionTemplate.selectList("userlist_super.list_u_email", map);
	}

	public int getTotalCount_U_NickName(String u_nickname) {
		return sqlSessionTemplate.selectOne("userlist_super.count_u_nickname", u_nickname);
	}

	public List<Userlist_Super_VO> getList_U_NickName(int begin, int end, String u_nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_nickname", u_nickname);
		return sqlSessionTemplate.selectList("userlist_super.list_u_nickname", map);
	}

	public int getTotalCount_U_BDay(String u_bday) {
		return sqlSessionTemplate.selectOne("userlist_super.count_u_bday", u_bday);
	}

	public List<Userlist_Super_VO> getList_U_BDay(int begin, int end, String u_bday) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_bday", u_bday);
		return sqlSessionTemplate.selectList("userlist_super.list_u_bday", map);
	}

}
