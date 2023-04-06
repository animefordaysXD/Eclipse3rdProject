package com.ict.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.homepage.model.service.homepage_Service;
import com.ict.homepage.model.vo.homepage_VO;

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
