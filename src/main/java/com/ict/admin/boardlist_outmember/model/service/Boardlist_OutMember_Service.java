package com.ict.admin.boardlist_outmember.model.service;

import java.util.List;

import com.ict.admin.boardlist_outmember.model.vo.Boardlist_OutMember_VO;

public interface Boardlist_OutMember_Service {

	public int getTotalCount();

	public List<Boardlist_OutMember_VO> getList(int being, int end);

	public int getBoardlist_OutMember_DeleteComplete(String u_idx);

	public int getTotalCount_AllSearch(String u_allsearch);

	public List<Boardlist_OutMember_VO> getBoardlist_OutMember_AllSearch(int begin, int end, String u_allsearch);

	public int getTotalCount_Boardlist_OutMember_Email(String u_email);

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_Email(int begin, int end, String u_email);

	public int getTotalCount_Boardlist_OutMember_NickName(String u_nickname);

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_NickName(int begin, int end, String u_nickname);

	public int getTotalCount_Boardlist_OutMember_BDay(String u_bday);

	public List<Boardlist_OutMember_VO> getList_Boardlist_OutMember_BDay(int begin, int end, String u_bday);
}
