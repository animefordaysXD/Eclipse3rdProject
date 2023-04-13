package com.ict.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.login.dao.DAO;
import com.ict.login.service.VO.VO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int getId(VO vo) {
		return dao.getId(vo);
	}
	@Override
	public int getNick(String nickName) {
		return dao.getNick(nickName);
	}
	@Override
	public int getInsert(VO vo) {
		return dao.getInsert(vo);
	}
	@Override
	public int getLogin(VO vo) {
		return dao.getLogin(vo);
	}
	@Override
	public int getAdmin(VO vo) {
		return dao.getAdmin(vo);
	}
	@Override
	public int getKakao(VO vo) {
		return dao.getKakao(vo);
	}
	@Override
	public int getNaver(VO vo) {
		return dao.getNaver(vo);
	}
	@Override
	public int checkHash(String hash) {
		return dao.checkHash(hash);
	}
	@Override
	public String getHash(String email) {
		return dao.getHash(email);
	}
	@Override
	public int setProf(VO vo) {
		return dao.setProf(vo);
	}
	@Override
	public VO getProf(String hash) {
		return dao.getProf(hash);
	}
	@Override
	public String getAttendDates(String hash) {
		return dao.getAttendDates(hash);
	}
	@Override
	public int insertAttend(VO vo) {
		return dao.insertAttend(vo);
	}
	@Override
	public int insertCity(VO vo) {
		return dao.insertCity(vo);
	}
	@Override
	public int insertNick(VO vo) {
		return dao.insertNick(vo);
	}


}
