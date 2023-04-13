package com.ict.login.service;

import com.ict.login.service.VO.VO;

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
	public int setProf(VO vo);
	public VO getProf(String hash);
	public String getAttendDates(String hash);
	public int insertAttend(VO vo);
	public int insertCity(VO vo);
	public int insertNick(VO vo);
}
