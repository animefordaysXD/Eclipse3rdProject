package com.ict.admin.login_controller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.admin.login_controller.model.service.Admin_LoginService;
import com.ict.admin.login_controller.model.vo.Admin_LoginVO;

@Controller
public class Admin_LoginController {

	@Autowired
	private Admin_LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(Admin_LoginController.class);

	public void setLoginService(Admin_LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("admin_login.do")
	public ModelAndView getLogin() {
		return new ModelAndView("admin_login/admin_login");
	}

	@RequestMapping("getAdminLogin.do")
	@ResponseBody
	public String returnGetAdminLogin(@ModelAttribute Admin_LoginVO vo) {
		int result = loginService.getAdmin(vo);
		if (result > 0) {
			return "1";
		} else {
			return "0";
		}
	}

//	@RequestMapping("adminComplete.do")
//	public ModelAndView returnAdminComplete() {
//		return new ModelAndView("boardlist_member/boardlist_member");
//	}

}
