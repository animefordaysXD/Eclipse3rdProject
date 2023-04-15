package com.ict.admin.boardlist.model.service;

import java.util.List;

import com.ict.admin.boardlist.model.vo.Boardlist_VO;

public interface Boardlist_Service {

	public int getTotalCount();

	public List<Boardlist_VO> getList(int begin, int end);

	public int getBoardHit(String post_idx);

	public Boardlist_VO getBoardOneList(String post_idx);

}
