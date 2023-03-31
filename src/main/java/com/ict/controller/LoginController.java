package com.ict.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.LoginService;
import com.ict.service.VO.CategoryVO;
import com.ict.service.VO.VO;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "login.do")
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "register.do")
	public ModelAndView getRegister(HttpServletRequest request) {
		String sns = request.getParameter("sns");
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("sns", sns);
		return mv;
	}

	@RequestMapping(value = "registerOK.do", method = RequestMethod.POST)
	@ResponseBody
	public String getRegisterOk(@RequestParam String email) {

		int result = 0;
		if (email.length() < 1) {
			result = 0;
		} else {
			System.out.println("email is " + email);
			result = loginService.getId(email);
			System.out.println(result);
		}
		if (result == 1) {

			return "1";
		} else {

			return "0";
		}

	}

	@RequestMapping(value = "registerComplete.do")
	@ResponseBody
	public String RegisterComplete(@ModelAttribute VO vo,@ModelAttribute CategoryVO cvo) {
		
		System.out.println("endTime : " + vo.getpTime2());
		System.out.println("cat ; " + cvo.getCategory());
		int result = loginService.getInsert(vo);
		if(result==1) {
		 return "complete";
		}else {
			
			return "fail";
		}
	}

	@PostMapping(value = "getNickChk.do")
	@ResponseBody
	public String getNickChk(@RequestParam String nickName) {
		int result = 0;
		result = loginService.getNick(nickName);
		

		if (result == 0) {
			return "0";
		} else {
			return "1";
		}

	}
	@RequestMapping("complete.do")
    public ModelAndView returnComplete() {
		return new ModelAndView("complete");
	}
	@RequestMapping("fail.do")
    public ModelAndView returnfail() {
		return new ModelAndView("fail");
	}
	@RequestMapping("adminLogin.do")
    public ModelAndView returnAdminLog() {
		return new ModelAndView("adminLogin");
	}
	@RequestMapping("getLogin.do")
	@ResponseBody
	public String returnLogin(@ModelAttribute VO vo) {
	int result = loginService.getLogin(vo);
	if(result>0) {
		return ("1");
	}else {
		return ("0");
	}
		
	}
	@RequestMapping("getAdminLogin.do")
	@ResponseBody
	public String returnGetAdminLogin(@ModelAttribute VO vo) {
		
	int result = loginService.getAdmin(vo);
	if(result>0) {
		return "1";
	}else {
		return "0";
	}
		
	}
	
	@RequestMapping("adminComplete.do")
    public ModelAndView returnAdminComplete() {
		return new ModelAndView("adminComplete");
	}
	
		
	
	

}
