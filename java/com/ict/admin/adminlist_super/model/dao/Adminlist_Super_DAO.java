package com.ict.admin.adminlist_super.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.adminlist_super.model.vo.Adminlist_Super_VO;

@Repository
public class Adminlist_Super_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("adminlist_super.count");
	}

	public List<Adminlist_Super_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("adminlist_super.list", map);
	}

	public int getAdminCreate(Adminlist_Super_VO adminlist_Super_VO) {
		return sqlSessionTemplate.insert("adminlist_super.admincreate", adminlist_Super_VO);
	}

	public int getAdmin_IdCheck(String admin_id) {
		return sqlSessionTemplate.selectOne("adminlist_super.admin_idcheck", admin_id);
	}

	public int getAdmin_NicknameCheck(String admin_nickname) {
		return sqlSessionTemplate.selectOne("adminlist_super.admin_nicknamecheck", admin_nickname);
	}

	public int getAdminDelete(String admin_idx) {
		return sqlSessionTemplate.delete("adminlist_super.admindelete", admin_idx);
	}

	public int getTotalCount_AllSearch(String admin_allsearch) {
		return sqlSessionTemplate.selectOne("adminlist_super.count_admin_allsearch", admin_allsearch);
	}

	public List<Adminlist_Super_VO> getList_Admin_AllSearch(int begin, int end, String admin_allsearch) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("admin_allsearch", admin_allsearch);
		return sqlSessionTemplate.selectList("adminlist_super.list_admin_allsearch", map);
	}

	public int getTotalCount_Admin_Idx(String admin_idx) {
		return sqlSessionTemplate.selectOne("adminlist_super.count_admin_idx", admin_idx);
	}

	public List<Adminlist_Super_VO> getList_Admin_Idx(int begin, int end, String admin_idx) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("admin_idx", admin_idx);
		return sqlSessionTemplate.selectList("adminlist_super.list_admin_idx", map);
	}

	public int getTotalCount_Admin_Id(String admin_id) {
		return sqlSessionTemplate.selectOne("adminlist_super.count_admin_id", admin_id);
	}

	public List<Adminlist_Super_VO> getList_Admin_Id(int begin, int end, String admin_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("admin_id", admin_id);
		return sqlSessionTemplate.selectList("adminlist_super.list_admin_id", map);
	}

	public int getTotalCount_Admin_NickName(String admin_nickname) {
		return sqlSessionTemplate.selectOne("adminlist_super.count_admin_nickname", admin_nickname);
	}

	public List<Adminlist_Super_VO> getList_Admin_NickName(int begin, int end, String admin_nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("admin_nickname", admin_nickname);
		return sqlSessionTemplate.selectList("adminlist_super.list_admin_nickname", map);
	}
}
