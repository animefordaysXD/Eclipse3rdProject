package com.ict.homepage.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.homepage.model.service.homepage_Service;
import com.ict.homepage.model.vo.homepage_VO;
import com.ict.homepage.model.vo.notification_VO;


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
	public ModelAndView HomePageok( homepage_VO hvo, HttpServletRequest request,@RequestParam("result")int result) {
		System.out.println("homepageOK Result is : " + result);
		//인설트 값 vo 쓰려면 넣어줘어야한다 
		hvo.setRomm_idx(result);
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
		int result2 = homepage_Service.homepageInsert(hvo);
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
	@RequestMapping("makeNotif.do")
	public ResponseEntity<?> makeNot(@RequestParam("hash") String hash, @ModelAttribute notification_VO avo) {
	    System.out.println("makeNot hash is : " + hash);
	    int idx = homepage_Service.getUserIdx(hash);
	    System.out.println("idx is : " + idx);
	    avo.setU_idx(idx);
	    int result = homepage_Service.createRoomNoti(avo);
	    System.out.println("result is : " + result);
	    
	    // Return the result as a JSON object within a ResponseEntity
	    return new ResponseEntity<>(Collections.singletonMap("result", result), HttpStatus.OK);
	}
	
	@RequestMapping("getNotif.do")
	@ResponseBody
	public ResponseEntity<List<notification_VO>> getNotifs(@RequestParam("hash") String hash) {
	    int idx = homepage_Service.getUserIdx(hash);
	    int count = homepage_Service.getNotifCount(idx);
	    List<notification_VO> list = new ArrayList<notification_VO>();
	    
	        list.addAll(homepage_Service.getNotif(idx));
	        for (notification_VO notif : list) {
	            notif.setNot_check(notif.getNot_idx()); // set not_check to not_idx
	        }

	    
	    return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping("deleteNotif.do")
	@ResponseBody
	public String deleteNotif(@RequestParam("not_idx")int idx) {
		int count = homepage_Service.deleteNotif(idx);
		if(count>1) {
			return "1";
		}else {
			return "0";
		}
		
	}
	
}
