package com.ict.admin.boardlist_room.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.boardlist_room.model.vo.Boardlist_Room_VO;

@Repository
public class Boardlist_Room_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("boardlist_room.count");
	}

	public List<Boardlist_Room_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("boardlist_room.list", map);
	}

	public int getBoardlist_Room_Admindelete(String room_idx) {
		return sqlSessionTemplate.update("boardlist_room.room_admindelete", room_idx);
	}

	public int getTotalCount_AllSearch(String u_allsearch) {
		return sqlSessionTemplate.selectOne("boardlist_room.count_boardlist_room_allsearch", u_allsearch);
	}

	public List<Boardlist_Room_VO> getBoardlist_Room_AllSearch(int begin, int end, String u_allsearch) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_allsearch", u_allsearch);
		return sqlSessionTemplate.selectList("boardlist_room.list_boardlist_room_allsearch", map);
	}

	public int getTotalCount_Boardlist_Room_Category(String category_type) {
		return sqlSessionTemplate.selectOne("boardlist_room.count_boardlist_room_category_type", category_type);
	}

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Category(int begin, int end, String category_type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("category_type", category_type);
		return sqlSessionTemplate.selectList("boardlist_room.list_boardlist_room_category_type", map);
	}

	public int getTotalCount_Boardlist_Room_Title(String room_title) {
		return sqlSessionTemplate.selectOne("boardlist_room.count_boardlist_room_room_title", room_title);
	}

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Title(int begin, int end, String room_title) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("room_title", room_title);
		return sqlSessionTemplate.selectList("boardlist_room.list_boardlist_room_room_title", map);
	}

	public int getTotalCount_Boardlist_Room_U_Nickname(String u_nickname) {
		return sqlSessionTemplate.selectOne("boardlist_room.count_boardlist_room_u_nickname", u_nickname);
	}

	public List<Boardlist_Room_VO> getList_Boardlist_Room_U_Nickname(int begin, int end, String u_nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("u_nickname", u_nickname);
		return sqlSessionTemplate.selectList("boardlist_room.list_boardlist_room_u_nickname", map);
	}

	public int getTotalCount_Boardlist_Room_Write_Datetime(String write_datetime) {
		return sqlSessionTemplate.selectOne("boardlist_room.count_boardlist_room_write_datetime", write_datetime);
	}

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Write_Datetime(int begin, int end, String write_datetime) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", Integer.toString(begin));
		map.put("end", Integer.toString(end));
		map.put("write_datetime", write_datetime);
		return sqlSessionTemplate.selectList("boardlist_room.list_boardlist_room_write_datetime", map);
	}

}
