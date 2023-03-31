package com.ict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.DAO;
import com.ict.service.VO.VO;

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


}
