package com.ict.admin.userlist_super.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.admin.common.Paging;
import com.ict.admin.userlist_super.model.service.Userlist_Super_Service;
import com.ict.admin.userlist_super.model.vo.Userlist_Super_VO;

@Controller
public class Userlist_Super_Controller {

	@Autowired
	private Userlist_Super_Service userlist_Super_Service;

	@Autowired
	private Paging paging;

	String cPage;

	private static final Logger logger = LoggerFactory.getLogger(Userlist_Super_Controller.class);

	// 사용자 리스트 출력
	@RequestMapping("userlist_super.do")
	public ModelAndView getuserList_Super(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("userlist_super/userlist_super");
		// 전체 게시물의 수
		int count = userlist_Super_Service.getTotalCount();
		paging.setTotalRecord(count);

		// 전체 페이지의 수
		if (paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		} else {
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}

		// 현재 페이지 구하기
		cPage = request.getParameter("cPage");
		if (cPage == null) {
			paging.setNowPage(1);
		} else {
			paging.setNowPage(Integer.parseInt(cPage));
		}

		// 시작 번호와 끝 번호 구하기
		paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
		paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

		// 시작 블럭과 끝 블록 구하기
		// 시작 블록
		paging.setBeginBlock(
				(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		// 끝 블록
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

		// 주의 사항
		// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}

		List<Userlist_Super_VO> userlist_super = userlist_Super_Service.getList(paging.getBegin(), paging.getEnd());
		mv.addObject("userlist_super", userlist_super);
		mv.addObject("paging", paging);

		return mv;
	}

	// 사용자 생성 가기
	@RequestMapping("usercreate_super.do")
	public ModelAndView usercreate_Super() {
		ModelAndView mv = new ModelAndView("userlist_super/usercreate_super");
		return mv;
	}

	// id 중복 검사 하기
	@RequestMapping("user_IdCheck.do")
	public @ResponseBody String user_IdCheck(String user_id) {
		int result = userlist_Super_Service.getUser_IdCheck(user_id);
		if (result > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	// Nickname 중복 검사 하기
	@RequestMapping("user_NicknameCheck.do")
	public @ResponseBody String user_NicknameCheck(String user_nickname) {
		System.out.println("오니?" + user_nickname);
		int result = userlist_Super_Service.getUser_NicknameCheck(user_nickname);
		if (result > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	// 사용자 생성 하기
	@RequestMapping("usercreate_super_ok.do")
	public ModelAndView usercreate_Super_OK(Userlist_Super_VO userlist_Super_VO,
			@RequestParam("user_id") String u_email, @RequestParam("user_name") String u_name,
			@RequestParam("user_nickname") String u_nickname, @RequestParam("user_birthday") String u_bday,
			@RequestParam("gender_select") String u_gender) {
		ModelAndView mv = new ModelAndView("redirect:userlist_super.do");

		userlist_Super_VO.setU_email(u_email);
		userlist_Super_VO.setU_name(u_name);
		userlist_Super_VO.setU_nickname(u_nickname);
		userlist_Super_VO.setU_bday(u_bday);
		userlist_Super_VO.setU_gender(u_gender);

		int result = userlist_Super_Service.getUserCreate(userlist_Super_VO);

		return mv;
	}

	// 사용자 삭제 하기
	@RequestMapping("userlist_super_delete.do")
	public ModelAndView userlist_Super_Delete(@ModelAttribute("u_idx") String u_idx) {

		int result = userlist_Super_Service.getUserDelete(u_idx);
		return new ModelAndView("redirect:userlist_super.do");
	}

	// 검색 하기
	@RequestMapping("userlist_super_search.do")
	public ModelAndView userlist_Super_Search(@ModelAttribute("search") String search,
			@ModelAttribute("radio") String radio) {
		System.out.println("확인용" + radio + search);
		ModelAndView mv = new ModelAndView("userlist_super/userlist_super");

		if (radio.equals("select_all")) {
			int count = userlist_Super_Service.getTotalCount_AllSearch(search);
			System.out.println(count);
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}

			// 현재 페이지 구하기
			paging.setNowPage(1);

			// 시작 번호와 끝 번호 구하기
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작 블럭과 끝 블록 구하기
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의 사항
			// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}

			List<Userlist_Super_VO> userlist_super_search = userlist_Super_Service
					.getList_U_AllSearch(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("userlist_super", userlist_super_search);
			mv.addObject("paging", paging);

		} else if (radio.equals("select_u_idx")) {
			int count = userlist_Super_Service.getTotalCount_U_Idx(search);
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}

			// 현재 페이지 구하기
			paging.setNowPage(1);

			// 시작 번호와 끝 번호 구하기
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작 블럭과 끝 블록 구하기
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의 사항
			// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}

			List<Userlist_Super_VO> userlist_super_search = userlist_Super_Service.getList_U_Idx(paging.getBegin(),
					paging.getEnd(), search);

			mv.addObject("userlist_super", userlist_super_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_email")) {
			int count = userlist_Super_Service.getTotalCount_U_Email(search);
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}

			// 현재 페이지 구하기
			paging.setNowPage(1);

			// 시작 번호와 끝 번호 구하기
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작 블럭과 끝 블록 구하기
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의 사항
			// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}

			List<Userlist_Super_VO> userlist_super_search = userlist_Super_Service.getList_U_Email(paging.getBegin(),
					paging.getEnd(), search);
			mv.addObject("userlist_super", userlist_super_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_nickname")) {
			int count = userlist_Super_Service.getTotalCount_U_NickName(search);
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}

			// 현재 페이지 구하기
			paging.setNowPage(1);

			// 시작 번호와 끝 번호 구하기
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작 블럭과 끝 블록 구하기
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의 사항
			// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}

			List<Userlist_Super_VO> userlist_super_search = userlist_Super_Service.getList_U_NickName(paging.getBegin(),
					paging.getEnd(), search);
			mv.addObject("userlist_super", userlist_super_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_bday")) {
			int count = userlist_Super_Service.getTotalCount_U_BDay(search);
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}

			// 현재 페이지 구하기
			paging.setNowPage(1);

			// 시작 번호와 끝 번호 구하기
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작 블럭과 끝 블록 구하기
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의 사항
			// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}

			List<Userlist_Super_VO> userlist_super_search = userlist_Super_Service.getList_U_BDay(paging.getBegin(),
					paging.getEnd(), search);
			mv.addObject("userlist_super", userlist_super_search);
			mv.addObject("paging", paging);
		}

		return mv;
	}

}
