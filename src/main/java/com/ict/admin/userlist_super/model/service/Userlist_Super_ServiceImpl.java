package com.ict.admin.userlist_super.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.userlist_super.model.dao.Userlist_Super_DAO;
import com.ict.admin.userlist_super.model.vo.Userlist_Super_VO;

@Service
public class Userlist_Super_ServiceImpl implements Userlist_Super_Service {

	@Autowired
	private Userlist_Super_DAO userlist_Super_DAO;

	public void setUserlist_Super_DAO(Userlist_Super_DAO userlist_Super_DAO) {
		this.userlist_Super_DAO = userlist_Super_DAO;
	}

	@Override
	public int getTotalCount() {
		return userlist_Super_DAO.getTotalCount();
	}

	@Override
	public List<Userlist_Super_VO> getList(int begin, int end) {
		return userlist_Super_DAO.getList(begin, end);
	}

	@Override
	public int getUserCreate(Userlist_Super_VO userlist_Super_VO) {
		return userlist_Super_DAO.getUserCreate(userlist_Super_VO);
	}

	@Override
	public int getUser_IdCheck(String user_id) {
		return userlist_Super_DAO.getUser_IdCheck(user_id);
	}

	@Override
	public int getUser_NicknameCheck(String user_nickname) {
		return userlist_Super_DAO.getUser_NicknameCheck(user_nickname);
	}

	@Override
	public int getUserDelete(String u_idx) {
		return userlist_Super_DAO.getUserDelete(u_idx);
	}

	@Override
	public int getTotalCount_AllSearch(String u_allsearch) {
		return userlist_Super_DAO.getTotalCount_AllSearch(u_allsearch);
	}

	@Override
	public List<Userlist_Super_VO> getList_U_AllSearch(int begin, int end, String u_allsearch) {
		return userlist_Super_DAO.getList_U_AllSearch(begin, end, u_allsearch);
	}

	@Override
	public int getTotalCount_U_Idx(String u_idx) {
		return userlist_Super_DAO.getTotalCount_U_Idx(u_idx);
	}

	@Override
	public List<Userlist_Super_VO> getList_U_Idx(int begin, int end, String u_idx) {
		return userlist_Super_DAO.getList_U_Idx(begin, end, u_idx);
	}

	@Override
	public int getTotalCount_U_Email(String u_email) {
		return userlist_Super_DAO.getTotalCount_U_Email(u_email);
	}

	@Override
	public List<Userlist_Super_VO> getList_U_Email(int begin, int end, String u_email) {
		return userlist_Super_DAO.getList_U_Email(begin, end, u_email);
	}

	@Override
	public int getTotalCount_U_NickName(String u_nickname) {
		return userlist_Super_DAO.getTotalCount_U_NickName(u_nickname);
	}

	@Override
	public List<Userlist_Super_VO> getList_U_NickName(int begin, int end, String u_nickname) {
		return userlist_Super_DAO.getList_U_NickName(begin, end, u_nickname);
	}

	@Override
	public int getTotalCount_U_BDay(String u_bday) {
		return userlist_Super_DAO.getTotalCount_U_BDay(u_bday);
	}

	@Override
	public List<Userlist_Super_VO> getList_U_BDay(int begin, int end, String u_bday) {
		return userlist_Super_DAO.getList_U_BDay(begin, end, u_bday);
	}

}
