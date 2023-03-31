package com.ict.service;

import com.ict.service.VO.VO;

public interface LoginService {
	public int getId(String email);
	public int getNick(String nickName);
	public int getInsert(VO vo);
	public int getLogin(VO vo);
	public int getAdmin(VO vo);
}
