package com.ict.login.controller;

import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.SecureRandom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.homepage.model.service.homepage_Service;
import com.ict.homepage.model.vo.homepage_VO;
import com.ict.login.service.LoginService;
import com.ict.login.service.VO.CategoryVO;
import com.ict.login.service.VO.VO;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
		}
	

	
	
	
	
	
	
	

	@RequestMapping(value = "login.do")
	public ModelAndView getLogin() {
		return new ModelAndView("login-views/login");
	}

	@RequestMapping(value = "register.do")
	public ModelAndView getRegister(HttpServletRequest request) {
		String sns = request.getParameter("sns");
		ModelAndView mv = new ModelAndView("login-views/register");
		mv.addObject("sns", sns);
		return mv;
	}

	@RequestMapping(value = "registerOK.do", method = RequestMethod.POST)
	@ResponseBody
	public String getRegisterOk(@ModelAttribute VO vo) {

		int result = 0;
		if (vo.getEmail().length() < 1) {
			result = 0;
		} else {
			
			result = loginService.getId(vo);
			System.out.println(result);
		}
		if (result >= 1) {

			return "1";
		} else {

			return "0";
		}

	}

	@RequestMapping(value = "registerComplete.do")
	@ResponseBody
	public String RegisterComplete(@ModelAttribute VO vo, @ModelAttribute CategoryVO cvo) {
		System.out.println("endTime : " + vo.getpTime2());
		//System.out.println("cat ; " + vo.getGetCat());
		StringBuilder sb = new StringBuilder();
		List<String> catList = cvo.getCategory();
		for (String k : catList) {
			sb.append(k+",");
		}
		String hash = Hash(8);
			
		
		vo.setHash(hash);
		System.out.println(sb.toString());
		vo.setGetCat(sb.toString());
		int result = loginService.getInsert(vo);
		if(result==1) {
		 return "login-views/complete";
		}else {
			
			return "login-views/fail";
		}
	}

	public String Hash(int length) {
		StringBuilder hash;
		 while(true) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		  SecureRandom random = new SecureRandom();
		   hash = new StringBuilder(length);
		  for (int i = 0; i < length; i++) {
	          int randomIndex = random.nextInt(CHARACTERS.length());
	          char randomChar = CHARACTERS.charAt(randomIndex);
	          hash.append(randomChar);
		  }
		  int result = loginService.checkHash(hash.toString());
		  if(result==0) {
			  break;
		  }
		 }
			  		 
		  return hash.toString();       
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
    public ModelAndView returnComplete(@RequestParam(required = false) String email,HttpSession session) {
		if(email!=null) {
			byte[] decodedBytes = Base64.getDecoder().decode(email);
			String decodedEmail = new String(decodedBytes);
			System.out.println("email is: " + email);
			System.out.println("decodedEmail is: " + decodedEmail);
			
			String hash = loginService.getHash(decodedEmail);
			if(email==null||hash==null||decodedBytes==null) {
				System.out.println(hash);
			return new ModelAndView("redirect:login.do");
			}else {
				ModelAndView mv = new ModelAndView("login-views/mymain");
				System.out.println("worked ");
				mv.addObject("hash",hash);
				return mv;
			}
		}
		else {
			return new ModelAndView("redirect:login.do");
		}
		
		
	}

		
	
	@RequestMapping("fail.do")
    public ModelAndView returnfail() {
		return new ModelAndView("login-views/fail");
	}
	@RequestMapping("index.do")
    public ModelAndView returnIndex() {
		return new ModelAndView("homepage-views/index");
	}
//	@RequestMapping("adminLogin.do")
//    public ModelAndView returnAdminLog() {
//		return new ModelAndView("login-views/adminLogin");
//	}
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
//	@RequestMapping("getAdminLogin.do")
//	@ResponseBody
//	public String returnGetAdminLogin(@ModelAttribute VO vo) {
//		
//	int result = loginService.getAdmin(vo);
//	if(result>0) {
//		return "1";
//	}else {
//		return "0";
//	}
//		
//	}
	
	@RequestMapping("adminComplete.do")
    public ModelAndView returnAdminComplete() {
		return new ModelAndView("login-views/adminComplete");
	}
	
	@RequestMapping("findPassword.do")
	public ModelAndView findPassword() {
		return new ModelAndView("login-views/passwordFind");
	}
	
	@RequestMapping("kakaoLogin.do")
	@ResponseBody
	public String getKakao(@ModelAttribute VO vo) {
		System.out.println("vo email " + vo.getEmail());
		int result = loginService.getKakao(vo);
		System.out.println("kakao result " + result);
		if(result>0) {
			return "complete.do";
		}else {
			return "register.do?sns=kakao";
		}
	}
	
	@RequestMapping("getNaver.do")
	@ResponseBody
	public String getNaver(@ModelAttribute VO vo,HttpSession session,HttpServletResponse response) {
		int result = loginService.getNaver(vo);
		
		System.out.println("result is " + result);
		if(result > 0) {	
			
			/*
			 * String characters =
			 * "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; int length
			 * = 16; Random random = new Random(); StringBuilder sb = new
			 * StringBuilder(length); for (int i = 0; i < length; i++) { int index =
			 * random.nextInt(characters.length()); sb.append(characters.charAt(index)); }
			 * Cookie authCookie = new Cookie("authToken", sb.toString());
			 * authCookie.setMaxAge(60 * 60 * 24); // Set the cookie to expire in 24 hours
			 * 
			 * // Set the HttpOnly flag response.setHeader("Set-Cookie",
			 * String.format("%s=%s; Max-Age=%d; HttpOnly", authCookie.getName(),
			 * authCookie.getValue(), authCookie.getMaxAge()));
			 */
			 
			  return "1";
			} else {
			 
			  return "0";
			}
	}
	
	
	
	
		
	
	

}
