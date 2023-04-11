package com.ict.admin.boardlist_outmember.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.admin.boardlist_outmember.model.service.Boardlist_OutMember_Service;
import com.ict.admin.boardlist_outmember.model.vo.Boardlist_OutMember_VO;
import com.ict.admin.common.Paging;

@Controller
public class Boardlist_OutMember_Controller {

	@Autowired
	private Boardlist_OutMember_Service boardlist_OutMember_Service;

	@Autowired
	private Paging paging;

	String cPage;

	private static final Logger logger = LoggerFactory.getLogger(Boardlist_OutMember_Controller.class);

	public void setBoardlist_OutMember_Service(Boardlist_OutMember_Service boardlist_OutMember_Service) {
		this.boardlist_OutMember_Service = boardlist_OutMember_Service;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@RequestMapping("boardlist_outmember.do")
	public ModelAndView getboardList_OutMember(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("boardlist_outmember/boardlist_outmember");

		// 전체 게시물의 수
		int count = boardlist_OutMember_Service.getTotalCount();
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

		// 주의사항
		// 만약, 끝 블록의 숫자가 전체 페이지의 수보다 크다면 끝 블록은 전체 페이지 수로 조정한다.
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}

		List<Boardlist_OutMember_VO> boardlist_outmember = boardlist_OutMember_Service.getList(paging.getBegin(),
				paging.getEnd());
		mv.addObject("boardlist_outmember", boardlist_outmember);
		mv.addObject("paging", paging);
		return mv;

	}

	// 탈퇴회원 정보 완적 삭제하기
	@RequestMapping("boardlist_member_deletecomplete.do")
	public ModelAndView boardlist_OutMember_DeleteComplete(@RequestParam("u_idx") String u_idx) {
		int result = boardlist_OutMember_Service.getBoardlist_OutMember_DeleteComplete(u_idx);
		return new ModelAndView("redirect:boardlist_outmember.do");
	}

	// 검색하기
	@RequestMapping("boardlist_outmember_search.do")
	public ModelAndView boardlist_OutMember_Search(@ModelAttribute("search") String search,
			@ModelAttribute("radio") String radio) {
		ModelAndView mv = new ModelAndView("boardlist_outmember/boardlist_outmember");
		if (radio.equals("select_all")) {
			int count = boardlist_OutMember_Service.getTotalCount_AllSearch(search);
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

			List<Boardlist_OutMember_VO> boardlist_outmember_search = boardlist_OutMember_Service
					.getBoardlist_OutMember_AllSearch(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("boardlist_outmember", boardlist_outmember_search);
			mv.addObject("paging", paging);

		} else if (radio.equals("select_u_id")) {
			int count = boardlist_OutMember_Service.getTotalCount_Boardlist_OutMember_Email(search);
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

			List<Boardlist_OutMember_VO> boardlist_outmember_search = boardlist_OutMember_Service
					.getList_Boardlist_OutMember_Email(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_outmember", boardlist_outmember_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_nickname")) {
			int count = boardlist_OutMember_Service.getTotalCount_Boardlist_OutMember_NickName(search);
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

			List<Boardlist_OutMember_VO> boardlist_outmember_search = boardlist_OutMember_Service
					.getList_Boardlist_OutMember_NickName(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_outmember", boardlist_outmember_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_bday")) {
			int count = boardlist_OutMember_Service.getTotalCount_Boardlist_OutMember_BDay(search);
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

			List<Boardlist_OutMember_VO> boardlist_outmember_search = boardlist_OutMember_Service
					.getList_Boardlist_OutMember_BDay(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_outmember", boardlist_outmember_search);
			mv.addObject("paging", paging);
		}

		return mv;
	}

}
