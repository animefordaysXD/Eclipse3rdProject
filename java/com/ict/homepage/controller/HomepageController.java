package com.ict.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.homepage.model.service.homepage_Service;
import com.ict.homepage.model.vo.homepage_VO;
import com.ict.login.service.VO.VO;


@Controller
public class HomepageController {
	@Autowired
	private homepage_Service homepage_Service;

	public void setHomepage_Service(homepage_Service homepage_Service) {
		this.homepage_Service = homepage_Service;
	}

	@RequestMapping("manager.mymain.do")
	public ModelAndView MyMain1() {
		ModelAndView mv = new ModelAndView("homepage-views/manager.mymain");
		return mv;
	}

	@RequestMapping("supermanager.mymain.do")
	public ModelAndView MyMain2() {
		ModelAndView mv = new ModelAndView("homepage-views/supermanager.mymain");
		return mv;
	}

	@RequestMapping("login.mymain.do")
	public ModelAndView MyMain3() {
		ModelAndView mv = new ModelAndView("login-views/login.mymain");
		return mv;
	}

	@RequestMapping("homepage.do")
	public ModelAndView HomePage() {
		ModelAndView mv = new ModelAndView("homepage-views/homepage");
		return mv;

	}

	@RequestMapping("homepage_ok.do")
	public ModelAndView HomePageok( homepage_VO hvo, HttpServletRequest request) {
		//인설트 값 vo 쓰려면 넣어줘어야한다 
	 hvo.setRoom_title((String)request.getParameter("title"));
	 hvo.setCategory_type((String)request.getParameter("category_type"));
	 hvo.setRoom_count(Integer.parseInt(request.getParameter("name1")));
	 hvo.setRoom_region((String)request.getParameter("room_region"));
	hvo.setLatitude((String)request.getParameter("latAddress"));
	hvo.setLongitude((String)request.getParameter("lngAddress"));
	// hvo.setStart_datetime((String)request.getParameter("start_datetime"));
	  hvo.setStart_datetime((String)request.getParameter("start_datetime"));
	 hvo.setEnd_datetime((String)request.getParameter("end_datetime"));
	 hvo.setFinal_datetime((String)request.getParameter("final_datetime"));
	 hvo.setRoom_gender(Integer.parseInt(request.getParameter("gender")));
	 hvo.setRoom_content((String)request.getParameter("room_content"));
	

		System.out.println("title is " + hvo.getRoom_title());
		System.out.println("category_type is " + hvo.getCategory_type());
		System.out.println("name1 is " + hvo.getRoom_count());
		System.out.println("room_region is " + hvo.getRoom_region());
		System.out.println("longitude is " + hvo.getLongitude());
		System.out.println("latitude is " + hvo.getLatitude());
		System.out.println("start_datetime is " + hvo.getStart_datetime());
		System.out.println("end_datetime is " + hvo.getEnd_datetime());
		System.out.println("final_datetime is " + hvo.getFinal_datetime());
		System.out.println("gender is " + hvo.getRoom_gender());
		System.out.println("room_content is " + hvo.getRoom_content());
		System.out.println("getting Hash is " + request.getParameter("hash"));
		String getHash = homepage_Service.getHashForRoomMake(request.getParameter("hash"));
		System.out.println("hash는 " + getHash);
		hvo.setU_nickname(getHash);
		int result = homepage_Service.homepageInsert(hvo);
		return new ModelAndView("redirect:roomlist.do");
		

	}

	@RequestMapping("roomlist.do")
	public ModelAndView roomlist() {
		ModelAndView mv = new ModelAndView("homepage-views/roomList");
		List<homepage_VO> list = homepage_Service.homepageList();
		mv.addObject("list", list);

		return mv;
}
	public ModelAndView HomePageok(homepage_VO hvo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:roomlist.do");
		return mv;

	}

	@RequestMapping("roomList.do")
	public ModelAndView romm() {
		ModelAndView mv = new ModelAndView("homepage-views/roomList");
		List<homepage_VO> list = homepage_Service.homepageList();
		mv.addObject("list", list);


		return mv;
	}

}
