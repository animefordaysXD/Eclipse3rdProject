package com.ict.admin.adminlist_super.controller;

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

import com.ict.admin.adminlist_super.model.service.Adminlist_Super_Service;
import com.ict.admin.adminlist_super.model.vo.Adminlist_Super_VO;
import com.ict.admin.common.Paging;

@Controller
public class Adminlist_Super_Controller {

	@Autowired
	private Adminlist_Super_Service adminlist_Super_Service;

	@Autowired
	private Paging paging;

	String cPage;

	private static final Logger logger = LoggerFactory.getLogger(Adminlist_Super_Controller.class);

	public void setAdminlist_Super_Service(Adminlist_Super_Service adminlist_Super_Service) {
		this.adminlist_Super_Service = adminlist_Super_Service;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	// 관리자 리스트 출력
	@RequestMapping("adminlist_super.do")
	public ModelAndView getadminList_Super(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("adminlist_super/adminlist_super");
		// 전체 게시물의 수
		int count = adminlist_Super_Service.getTotalCount();
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

		// 시작 블록과 끝 블록 구하기
		paging.setBeginBlock(
				(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

		// 주의 사항
		// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}

		List<Adminlist_Super_VO> adminlist_super = adminlist_Super_Service.getList(paging.getBegin(), paging.getEnd());
		mv.addObject("adminlist_super", adminlist_super);
		mv.addObject("paging", paging);

		return mv;
	}

	// 관리자 생성
	@RequestMapping("admincreate_super.do")
	public ModelAndView admincreate_Super() {
		ModelAndView mv = new ModelAndView("adminlist_super/admincreate_super");
		return mv;
	}

	// id 중복 검사 하기
	@RequestMapping("admin_IdCheck.do")
	public @ResponseBody String admin_IdCheck(String admin_id) {
		int result = adminlist_Super_Service.getAdmin_IdCheck(admin_id);
		if (result > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	// Nickname 중복 검사 하기
	@RequestMapping("admin_NicknameCheck.do")
	public @ResponseBody String admin_NicknameCheck(String admin_nickname) {
		int result = adminlist_Super_Service.getAdmin_NicknameCheck(admin_nickname);
		if (result > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	// 관리자 생성 하기
	@RequestMapping("admincreate_super_ok.do")
	public ModelAndView admincreate_Super_OK(Adminlist_Super_VO adminlist_Super_VO,
			@RequestParam("admin_id") String admin_id, @RequestParam("admin_nickname") String admin_nickname) {
		ModelAndView mv = new ModelAndView("redirect:adminlist_super.do");

		adminlist_Super_VO.setAdmin_id(admin_id);
		adminlist_Super_VO.setAdmin_pwd("icteud1234");
		adminlist_Super_VO.setAdmin_salt("salt");
		adminlist_Super_VO.setAdmin_nickname(admin_nickname);

		int result = adminlist_Super_Service.getAdminCreate(adminlist_Super_VO);
		return mv;
	}

	// 관리자 삭제 하기
	@RequestMapping("adminlist_super_delete.do")
	public ModelAndView adminlist_Super_Delete(@ModelAttribute("admin_idx") String admin_idx) {

		int result = adminlist_Super_Service.getAdminDelete(admin_idx);

		return new ModelAndView("redirect:adminlist_super.do");
	}

	// 검색 하기
	@RequestMapping("adminlist_super_search.do")
	public ModelAndView adminlist_Super_Search(@ModelAttribute("search") String search,
			@ModelAttribute("radio") String radio) {
		ModelAndView mv = new ModelAndView("adminlist_super/adminlist_super");

		if (radio.equals("select_all")) {
			int count = adminlist_Super_Service.getTotalCount_AllSearch(search);
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

			List<Adminlist_Super_VO> adminlist_super_search = adminlist_Super_Service
					.getList_Admin_AllSearch(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("adminlist_super", adminlist_super_search);
			mv.addObject("paging", paging);

		} else if (radio.equals("select_admin_idx")) {
			int count = adminlist_Super_Service.getTotalCount_Admin_Idx(search);
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

			List<Adminlist_Super_VO> adminlist_super_search = adminlist_Super_Service
					.getList_Admin_Idx(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("adminlist_super", adminlist_super_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_admin_id")) {
			int count = adminlist_Super_Service.getTotalCount_Admin_Id(search);
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

			List<Adminlist_Super_VO> adminlist_super_search = adminlist_Super_Service
					.getList_Admin_Id(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("adminlist_super", adminlist_super_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_admin_nickname")) {
			int count = adminlist_Super_Service.getTotalCount_Admin_NickName(search);
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

			List<Adminlist_Super_VO> adminlist_super_search = adminlist_Super_Service
					.getList_Admin_NickName(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("adminlist_super", adminlist_super_search);
			mv.addObject("paging", paging);
		}

		return mv;
	}

}
