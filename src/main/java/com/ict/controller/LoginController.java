package com.ict.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="login.do")
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}

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

	@RequestMapping(value="registerComplete.do",method=RequestMethod.POST) 
	@ResponseBody
	public ModelAndView RegisterComplete(HttpServletRequest request){
		VO vo = new VO();
		CategoryVO cvo = new CategoryVO();
		ModelAndView mv = new ModelAndView("complete");
		vo.setU_email(request.getParameter("email"));
		vo.setU_pwd(request.getParameter("password"));
		vo.setU_name(request.getParameter("name"));
		vo.setU_gender(request.getParameter("gender"));
		vo.setU_bday(request.getParameter("birthday"));
		System.out.println(vo.getU_bday());
		
		return mv;
	}





}
