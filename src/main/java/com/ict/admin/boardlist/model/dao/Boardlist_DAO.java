package com.ict.admin.boardlist.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.admin.boardlist.model.vo.Boardlist_VO;

@Repository
public class Boardlist_DAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("boardlist.count");
	}

	public List<Boardlist_VO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("boardlist.list", map);
	}

	public int getBoardHit(String post_idx) {
		return sqlSessionTemplate.update("boardlist.hitup", post_idx);
	}

	public Boardlist_VO getBoardOneList(String post_idx) {
		return sqlSessionTemplate.selectOne("boardlist.onelist", post_idx);
	}
}
