package com.ict.admin.boardlist_room.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.boardlist_room.model.dao.Boardlist_Room_DAO;
import com.ict.admin.boardlist_room.model.vo.Boardlist_Room_VO;

@Service
public class Boardlist_Room_ServiceImpl implements Boardlist_Room_Service {

	@Autowired
	private Boardlist_Room_DAO boardlist_Room_DAO;

	public void setBoardlist_Room_DAO(Boardlist_Room_DAO boardlist_Room_DAO) {
		this.boardlist_Room_DAO = boardlist_Room_DAO;
	}

	@Override
	public int getTotalCount() {
		return boardlist_Room_DAO.getTotalCount();
	}

	@Override
	public List<Boardlist_Room_VO> getList(int begin, int end) {
		return boardlist_Room_DAO.getList(begin, end);
	}

	@Override
	public int getBoardlist_Room_Admindelete(String room_idx) {
		return boardlist_Room_DAO.getBoardlist_Room_Admindelete(room_idx);
	}

	@Override
	public int getTotalCount_AllSearch(String u_allsearch) {
		return boardlist_Room_DAO.getTotalCount_AllSearch(u_allsearch);
	}

	@Override
	public List<Boardlist_Room_VO> getBoardlist_Room_AllSearch(int begin, int end, String u_allsearch) {
		return boardlist_Room_DAO.getBoardlist_Room_AllSearch(begin, end, u_allsearch);
	}

	@Override
	public int getTotalCount_Boardlist_Room_Category(String category_type) {
		return boardlist_Room_DAO.getTotalCount_Boardlist_Room_Category(category_type);
	}

	@Override
	public List<Boardlist_Room_VO> getList_Boardlist_Room_Category(int begin, int end, String category_type) {
		return boardlist_Room_DAO.getList_Boardlist_Room_Category(begin, end, category_type);
	}

	@Override
	public int getTotalCount_Boardlist_Room_Title(String room_title) {
		return boardlist_Room_DAO.getTotalCount_Boardlist_Room_Title(room_title);
	}

	@Override
	public List<Boardlist_Room_VO> getList_Boardlist_Room_Title(int begin, int end, String room_title) {
		return boardlist_Room_DAO.getList_Boardlist_Room_Title(begin, end, room_title);
	}

	@Override
	public int getTotalCount_Boardlist_Room_U_Nickname(String u_nickname) {
		return boardlist_Room_DAO.getTotalCount_Boardlist_Room_U_Nickname(u_nickname);
	}

	@Override
	public List<Boardlist_Room_VO> getList_Boardlist_Room_U_Nickname(int begin, int end, String u_nickname) {
		return boardlist_Room_DAO.getList_Boardlist_Room_U_Nickname(begin, end, u_nickname);
	}

	@Override
	public int getTotalCount_Boardlist_Room_Write_Datetime(String write_datetime) {
		return boardlist_Room_DAO.getTotalCount_Boardlist_Room_Write_Datetime(write_datetime);
	}

	@Override
	public List<Boardlist_Room_VO> getList_Boardlist_Room_Write_Datetime(int begin, int end, String write_datetime) {
		return boardlist_Room_DAO.getList_Boardlist_Room_Write_Datetime(begin, end, write_datetime);
	}

}
