package com.ict.homepage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.homepage.model.dao.homepage_DAO;
import com.ict.homepage.model.vo.homepage_VO;

@Service
public class homepage_Servicempl implements homepage_Service {
	@Autowired
	private homepage_DAO homepage_DAO;

	public void setHomepage_DAO(homepage_DAO homepage_DAO) {
		this.homepage_DAO = homepage_DAO;
	}


	
	// 오버라이드 해줘야 homepage_Servicempl 오류가 안남 .
	@Override
	public int homepageInsert(homepage_VO hvo) {
		try {
			return homepage_DAO.homepageInsert(hvo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<homepage_VO> homepageList() {
		return homepage_DAO.homepageList();
	}
	
	

}
