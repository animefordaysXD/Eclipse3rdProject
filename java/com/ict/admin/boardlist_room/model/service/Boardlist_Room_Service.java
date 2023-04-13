package com.ict.admin.boardlist_room.model.service;

import java.util.List;

import com.ict.admin.boardlist_room.model.vo.Boardlist_Room_VO;

public interface Boardlist_Room_Service {

	public int getTotalCount();

	public List<Boardlist_Room_VO> getList(int begin, int end);

	public int getBoardlist_Room_Admindelete(String room_idx);

	public int getTotalCount_AllSearch(String u_allsearch);

	public List<Boardlist_Room_VO> getBoardlist_Room_AllSearch(int begin, int end, String u_allsearch);

	public int getTotalCount_Boardlist_Room_Category(String category_type);

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Category(int begin, int end, String category_type);

	public int getTotalCount_Boardlist_Room_Title(String room_title);

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Title(int begin, int end, String room_title);

	public int getTotalCount_Boardlist_Room_U_Nickname(String u_nickname);

	public List<Boardlist_Room_VO> getList_Boardlist_Room_U_Nickname(int begin, int end, String u_nickname);

	public int getTotalCount_Boardlist_Room_Write_Datetime(String write_datetime);

	public List<Boardlist_Room_VO> getList_Boardlist_Room_Write_Datetime(int begin, int end, String write_datetime);
}
