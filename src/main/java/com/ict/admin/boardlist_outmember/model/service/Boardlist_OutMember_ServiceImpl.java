package com.ict.admin.boardlist_outmember.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.boardlist_outmember.model.dao.Boardlist_OutMember_DAO;
import com.ict.admin.boardlist_outmember.model.vo.Boardlist_OutMember_VO;

@Service
public class Boardlist_OutMember_ServiceImpl implements Boardlist_OutMember_Service {

	@Autowired
	private Boardlist_OutMember_DAO boardlist_OutMember_DAO;

	public void setBoardlist_OutMember_DAO(Boardlist_OutMember_DAO boardlist_OutMember_DAO) {
		this.boardlist_OutMember_DAO = boardlist_OutMember_DAO;
	}

	@Override
	public int getTotalCount() {
		return boardlist_OutMember_DAO.getTotalCount();
	}

	@Override
	public List<Boardlist_OutMember_VO> getList(int begin, int end) {
		return boardlist_OutMember_DAO.getList(begin, end);
	}

	@Override
	public int getBoardlist_OutMember_DeleteComplete(String u_idx) {
		return boardlist_OutMember_DAO.getBoardlist_OutMember_DeleteComplete(u_idx);
	}

	@Override
	public int getTotalCount_AllSearch(String u_allsearch) {
		return boardlist_OutMember_DAO.getTotalCount_AllSearch(u_allsearch);
	}

	@Override
	public List<Boardlist_OutMember_VO> getBoardlist_OutMember_AllSearch(int begin, int end, String u_allsearch) {
		return boardlist_OutMember_DAO.getBoardlist_OutMember_AllSearch(begin, end, u_allsearch);
	}

	@Override
	public int getTotalCount_Boardlist_OutMember_Email(String u_email) {
		return boardlist_OutMember_DAO.getTotalCount_Boardlist_OutMember_Email(u_email);
	}

	@Override
	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_Email(int begin, int end, String u_email) {
		return boardlist_OutMember_DAO.getList_Boardlist_OutMember_Email(begin, end, u_email);
	}

	@Override
	public int getTotalCount_Boardlist_OutMember_NickName(String u_nickname) {
		return boardlist_OutMember_DAO.getTotalCount_Boardlist_OutMember_NickName(u_nickname);
	}

	@Override
	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_NickName(int begin, int end, String u_nickname) {
		return boardlist_OutMember_DAO.getList_Boardlist_OutMember_NickName(begin, end, u_nickname);
	}

	@Override
	public int getTotalCount_Boardlist_OutMember_BDay(String u_bday) {
		return boardlist_OutMember_DAO.getTotalCount_Boardlist_OutMember_BDay(u_bday);
	}

	@Override
	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_BDay(int begin, int end, String u_bday) {
		return boardlist_OutMember_DAO.getList_Boardlist_OutMember_BDay(begin, end, u_bday);
	}
}
