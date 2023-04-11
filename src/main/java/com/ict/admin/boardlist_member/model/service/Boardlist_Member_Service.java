package com.ict.admin.boardlist_member.model.service;

import java.util.List;

import com.ict.admin.boardlist_member.model.vo.Boardlist_Member_VO;

public interface Boardlist_Member_Service {

	// 총 게시물 count하기
	public int getTotalCount();

	// 페이징 기법을 이용한 List 화 시키기
	public List<Boardlist_Member_VO> getList(int begin, int end);

	int getBoardlist_Member_Nicknameupdate(String u_idx);

	int getBoardlist_Member_getOutmember(String u_idx);

	public int getTotalCount_AllSearch(String u_allsearch);

	public List<Boardlist_Member_VO> getBoardlist_Member_AllSearch(int begin, int end, String u_allsearch);

	public int getTotalCount_Boardlist_Member_Email(String u_email);

	public List<Boardlist_Member_VO> getList_Boardlist_Member_Email(int begin, int end, String u_email);

	public int getTotalCount_Boardlist_Member_NickName(String u_nickname);

	public List<Boardlist_Member_VO> getList_Boardlist_Member_NickName(int begin, int end, String u_nickname);

	public int getTotalCount_Boardlist_Member_BDay(String u_bday);

	public List<Boardlist_Member_VO> getList_Boardlist_Member_BDay(int begin, int end, String u_bday);

}
