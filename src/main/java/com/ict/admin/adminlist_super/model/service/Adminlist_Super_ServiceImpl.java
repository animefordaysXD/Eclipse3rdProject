package com.ict.admin.adminlist_super.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.admin.adminlist_super.model.dao.Adminlist_Super_DAO;
import com.ict.admin.adminlist_super.model.vo.Adminlist_Super_VO;

@Service
public class Adminlist_Super_ServiceImpl implements Adminlist_Super_Service {

	@Autowired
	private Adminlist_Super_DAO adminlist_Super_DAO;

	public void setAdminlist_Super_DAO(Adminlist_Super_DAO adminlist_Super_DAO) {
		this.adminlist_Super_DAO = adminlist_Super_DAO;
	}

	@Override
	public int getTotalCount() {
		return adminlist_Super_DAO.getTotalCount();
	}

	@Override
	public List<Adminlist_Super_VO> getList(int begin, int end) {
		return adminlist_Super_DAO.getList(begin, end);
	}

	@Override
	public int getAdminCreate(Adminlist_Super_VO adminlist_Super_VO) {
		return adminlist_Super_DAO.getAdminCreate(adminlist_Super_VO);
	}

	@Override
	public int getAdmin_IdCheck(String admin_id) {
		return adminlist_Super_DAO.getAdmin_IdCheck(admin_id);
	}

	@Override
	public int getAdmin_NicknameCheck(String admin_nickname) {
		return adminlist_Super_DAO.getAdmin_NicknameCheck(admin_nickname);
	}

	@Override
	public int getAdminDelete(String admin_idx) {
		return adminlist_Super_DAO.getAdminDelete(admin_idx);
	}

	@Override
	public int getTotalCount_AllSearch(String admin_allsearch) {
		return adminlist_Super_DAO.getTotalCount_AllSearch(admin_allsearch);
	}

	@Override
	public List<Adminlist_Super_VO> getList_Admin_AllSearch(int begin, int end, String admin_allsearch) {
		return adminlist_Super_DAO.getList_Admin_AllSearch(begin, end, admin_allsearch);
	}

	@Override
	public int getTotalCount_Admin_Idx(String admin_idx) {
		return adminlist_Super_DAO.getTotalCount_Admin_Idx(admin_idx);
	}

	@Override
	public List<Adminlist_Super_VO> getList_Admin_Idx(int begin, int end, String admin_idx) {
		return adminlist_Super_DAO.getList_Admin_Idx(begin, end, admin_idx);
	}

	@Override
	public int getTotalCount_Admin_Id(String admin_id) {
		return adminlist_Super_DAO.getTotalCount_Admin_Id(admin_id);
	}

	@Override
	public List<Adminlist_Super_VO> getList_Admin_Id(int begin, int end, String admin_id) {
		return adminlist_Super_DAO.getList_Admin_Id(begin, end, admin_id);
	}

	@Override
	public int getTotalCount_Admin_NickName(String admin_nickname) {
		return adminlist_Super_DAO.getTotalCount_Admin_NickName(admin_nickname);
	}

	@Override
	public List<Adminlist_Super_VO> getList_Admin_NickName(int begin, int end, String admin_nickname) {
		return adminlist_Super_DAO.getList_Admin_NickName(begin, end, admin_nickname);
	}

}
