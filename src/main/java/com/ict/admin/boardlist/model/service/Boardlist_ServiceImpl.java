package com.ict.admin.boardlist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.boardlist.model.dao.Boardlist_DAO;
import com.ict.admin.boardlist.model.vo.Boardlist_VO;

@Service
public class Boardlist_ServiceImpl implements Boardlist_Service {

	@Autowired
	private Boardlist_DAO boardlist_DAO;

	public void setBoardlist_DAO(Boardlist_DAO boardlist_DAO) {
		this.boardlist_DAO = boardlist_DAO;
	}

	@Override
	public int getTotalCount() {
		return boardlist_DAO.getTotalCount();
	}

	@Override
	public List<Boardlist_VO> getList(int begin, int end) {
		return boardlist_DAO.getList(begin, end);
	}

	@Override
	public int getBoardHit(String post_idx) {
		return boardlist_DAO.getBoardHit(post_idx);
	}

	@Override
	public Boardlist_VO getBoardOneList(String post_idx) {
		return boardlist_DAO.getBoardOneList(post_idx);
	}
}
