package com.ict.admin.boardlist_member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.boardlist_member.model.dao.Boardlist_Member_DAO;
import com.ict.admin.boardlist_member.model.vo.Boardlist_Member_VO;

@Service
public class Boardlist_Member_ServiceImpl implements Boardlist_Member_Service {

	@Autowired
	private Boardlist_Member_DAO boardlist_Member_DAO;

	public void setBoardlist_Member_DAO(Boardlist_Member_DAO boardlist_Member_DAO) {
		this.boardlist_Member_DAO = boardlist_Member_DAO;
	}

	// 게시물 count 하기
	@Override
	public int getTotalCount() {
		return boardlist_Member_DAO.getTotalCount();
	}

	// paging 기법 전체 List 출력하기
	@Override
	public List<Boardlist_Member_VO> getList(int begin, int end) {
		return boardlist_Member_DAO.getList(begin, end);
	}

	@Override
	public int getBoardlist_Member_Nicknameupdate(String u_idx) {
		return boardlist_Member_DAO.getBoardlist_Member_Nicknameupdate(u_idx);
	}
	
	@Override
	public int getBoardlist_Member_getOutmember(String u_idx) {
		return boardlist_Member_DAO.getBoardlist_Member_getOutmember(u_idx);
	}

	@Override
	public int getTotalCount_AllSearch(String u_allsearch) {
		return boardlist_Member_DAO.getTotalCount_AllSearch(u_allsearch);
	}

	@Override
	public List<Boardlist_Member_VO> getBoardlist_Member_AllSearch(int begin, int end, String u_allsearch) {
		return boardlist_Member_DAO.getBoardlist_Member_AllSearch(begin, end, u_allsearch);
	}

	@Override
	public int getTotalCount_Boardlist_Member_Email(String u_email) {
		return boardlist_Member_DAO.getTotalCount_Boardlist_Member_Email(u_email);
	}

	@Override
	public List<Boardlist_Member_VO> getList_Boardlist_Member_Email(int begin, int end, String u_email) {
		return boardlist_Member_DAO.getList_Boardlist_Member_Email(begin, end, u_email);
	}

	@Override
	public int getTotalCount_Boardlist_Member_NickName(String u_nickname) {
		return boardlist_Member_DAO.getTotalCount_Boardlist_Member_NickName(u_nickname);
	}

	@Override
	public List<Boardlist_Member_VO> getList_Boardlist_Member_NickName(int begin, int end, String u_nickname) {
		return boardlist_Member_DAO.getList_Boardlist_Member_NickName(begin, end, u_nickname);
	}

	@Override
	public int getTotalCount_Boardlist_Member_BDay(String u_bday) {
		return boardlist_Member_DAO.getTotalCount_Boardlist_Member_BDay(u_bday);
	}

	@Override
	public List<Boardlist_Member_VO> getList_Boardlist_Member_BDay(int begin, int end, String u_bday) {
		return boardlist_Member_DAO.getList_Boardlist_Member_BDay(begin, end, u_bday);
	}

}
