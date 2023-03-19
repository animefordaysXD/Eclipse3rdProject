package com.ict.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping(value="register.do")
	public ModelAndView getRegister() {
		return new ModelAndView("register");
	}
	@RequestMapping(value="registerOK.do",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getRegisterOk(HttpServletRequest request) {
		String email = request.getParameter("email");
		System.out.println("email is "+ email);
		int result = loginService.getId(email);
		System.out.println(result);
		if(result==1) {
			ModelAndView mv = new ModelAndView("register");
			mv.addObject("emailUse", "사용 불가능합니다");
			mv.addObject("email", email);
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("register");
			mv.addObject("emailUse", "사용 가능합니다");
			mv.addObject("email", email);
			return mv;
		}
		
	}

	
}
