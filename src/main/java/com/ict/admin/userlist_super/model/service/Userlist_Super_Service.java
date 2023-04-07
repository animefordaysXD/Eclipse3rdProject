package com.ict.admin.userlist_super.model.service;

import java.util.List;

import com.ict.admin.userlist_super.model.vo.Userlist_Super_VO;

public interface Userlist_Super_Service {

	public int getTotalCount();

	public List<Userlist_Super_VO> getList(int begin, int end);

	public int getUserCreate(Userlist_Super_VO userlist_Super_VO);

	public int getUser_IdCheck(String user_id);

	public int getUser_NicknameCheck(String user_nickname);

	public int getUserDelete(String u_idx);

	public int getTotalCount_AllSearch(String u_allsearch);

	public List<Userlist_Super_VO> getList_U_AllSearch(int begin, int end, String u_allsearch);

	public int getTotalCount_U_Idx(String u_idx);

	public List<Userlist_Super_VO> getList_U_Idx(int begin, int end, String u_idx);

	public int getTotalCount_U_Email(String u_email);

	public List<Userlist_Super_VO> getList_U_Email(int begin, int end, String u_email);

	public int getTotalCount_U_NickName(String u_nickname);

	public List<Userlist_Super_VO> getList_U_NickName(int begin, int end, String u_nickname);

	public int getTotalCount_U_BDay(String u_bday);

	public List<Userlist_Super_VO> getList_U_BDay(int begin, int end, String u_bday);

}
