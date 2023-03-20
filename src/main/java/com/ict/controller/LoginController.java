package com.ict.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.LoginService;
import com.ict.service.MailSendService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Autowired
	private MailSendService mailService;
	
	@RequestMapping(value="register.do")
	public ModelAndView getRegister() {
		
		return new ModelAndView("register");
	}
	@RequestMapping(value="registerOK.do",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getRegisterOk(HttpServletRequest request) {
		String email = request.getParameter("email");
		int result =0;
		if(email.length()<1) {			
		 result =0;
		}else {
		System.out.println("email is "+ email);
		 result = loginService.getId(email);
		System.out.println(result);
		}
		if(result==1) {
			ModelAndView mv = new ModelAndView("register");
//			mv.addObject("emailUse", "사용 불가능합니다");
			mv.addObject("email", email);
			request.setAttribute("emailUse", "사용 불가능합니다");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("register");
//			mv.addObject("emailUse", "사용 가능합니다");
			mv.addObject("email", email);
			request.setAttribute("emailUse", "사용 가능합니다");
			return mv;
		}
		
	}
	@GetMapping("mailCheck.do")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		return mailService.joinEmail(email);
	}
	

	

	
}
