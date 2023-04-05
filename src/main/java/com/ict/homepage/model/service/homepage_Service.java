package com.ict.homepage.model.service;

import java.util.List;


import com.ict.homepage.model.vo.homepage_VO;

public interface homepage_Service {

	List<homepage_VO> homepageList();
	int homepageInsert(homepage_VO hvo);
	
	
}
