package com.ict.service;

import com.ict.service.VO.VO;

public interface LoginService {
	public int getId(VO vo);
	public int getNick(String nickName);
	public int getInsert(VO vo);
	public int getLogin(VO vo);
	public int getAdmin(VO vo);
	public int getKakao(VO vo);
	public int getNaver(VO vo);
	public int checkHash(String hash);
	public String getHash(String email);
}
