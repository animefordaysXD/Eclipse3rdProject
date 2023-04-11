package com.ict.admin.adminlist_super.model.service;

import java.util.List;

import com.ict.admin.adminlist_super.model.vo.Adminlist_Super_VO;

public interface Adminlist_Super_Service {

	public int getTotalCount();

	public List<Adminlist_Super_VO> getList(int begin, int end);

	public int getAdminCreate(Adminlist_Super_VO adminlist_Super_VO);

	public int getAdmin_IdCheck(String admin_id);

	public int getAdmin_NicknameCheck(String admin_nickname);

	public int getAdminDelete(String admin_idx);

	public int getTotalCount_AllSearch(String admin_allsearch);

	public List<Adminlist_Super_VO> getList_Admin_AllSearch(int begin, int end, String admin_allsearch);

	public int getTotalCount_Admin_Idx(String admin_idx);

	public List<Adminlist_Super_VO> getList_Admin_Idx(int begin, int end, String admin_idx);

	public int getTotalCount_Admin_Id(String admin_id);

	public List<Adminlist_Super_VO> getList_Admin_Id(int begin, int end, String admin_id);

	public int getTotalCount_Admin_NickName(String admin_nickname);

	public List<Adminlist_Super_VO> getList_Admin_NickName(int begin, int end, String admin_nickname);
}
