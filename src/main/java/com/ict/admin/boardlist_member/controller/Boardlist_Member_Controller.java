package com.ict.admin.boardlist_member.controller;

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

import com.ict.admin.boardlist_member.model.service.Boardlist_Member_Service;
import com.ict.admin.boardlist_member.model.vo.Boardlist_Member_VO;
import com.ict.admin.common.Paging;

@Controller
public class Boardlist_Member_Controller {

	@Autowired
	private Boardlist_Member_Service boardlist_Member_Service;

	@Autowired
	private Paging paging;

	// cPage 전역변수화
	String cPage;

	private static final Logger logger = LoggerFactory.getLogger(Boardlist_Member_Controller.class);

	public void setBoardlist_Member_Service(Boardlist_Member_Service boardlist_Member_Service) {
		this.boardlist_Member_Service = boardlist_Member_Service;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	// 회원 리스트 생성하기
	@RequestMapping("boardlist_member.do")
	public ModelAndView getboardList_Member(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("boardlist_member/boardlist_member");
		// 전체 게시물의 수
		int count = boardlist_Member_Service.getTotalCount();
		paging.setTotalRecord(count);

		// 전체 페이지의수
		// 전체 게시물의 수 <= 한 페이지당 원글의 수 이면 총페이지는 1페이지
		if (paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		} else {
			// 전체 게시물의 수가 한 페이지당 원글의 수보다 많다면
			// ex) 전체 게시물 수 10, 한 페이지당 원글의 수 3 = 3.333 인데 인트니까 3
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			// 근데 여기서
			// 전체 게시물의 수와 한 페이지당 게시물의 수를 나눈 나머지가 0이 아니라면
			// 1을 더해 나머지 게시물이 전시될 총페이지를 1개 더 늘려준다.
			if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}

		// 현재 페이지 구하기
		// 뒤로 갔을때 현재 페이지로 돌아가야하니까 현재 페이지도 기록해둔다.
		// cPage로 전역변수화 시킨다.
		cPage = request.getParameter("cPage");
		if (cPage == null) {
			paging.setNowPage(1);
		} else {
			paging.setNowPage(Integer.parseInt(cPage));
		}

		// 시작 번호와 끝 번호 구하기
		// Ex) 현재페이지 = 1, 한 페이지 당 원글의 수 = 5
		// Ex) 시작번호 (1-1)*5+1 =1
		// Ex) 끝번호 (1-1)+5 = 5
		paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
		paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

		// 시작 블록과 끝 번호 구하기
		// 시작 블록
		paging.setBeginBlock(
				(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		// 끝 블록
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

		// 주의사항
		// 만약, 끝블록의 숫자가 전체 페이지의 수보다 크다면 끝블록은 전체 페이지 수로 조정한다.
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
		List<Boardlist_Member_VO> boardlist_member = boardlist_Member_Service.getList(paging.getBegin(),
				paging.getEnd());
		mv.addObject("boardlist_member", boardlist_member);
		mv.addObject("paging", paging);
		return mv;
	}

	// 관리자용 닉네임 변경
	@RequestMapping("boardlist_member_nicknameupdate.do")
	public ModelAndView boardlist_Member_Nicknameupdate(@RequestParam("u_idx") String u_idx) {
		int result = boardlist_Member_Service.getBoardlist_Member_Nicknameupdate(u_idx);
		return new ModelAndView("redirect:boardlist_member.do");
	}

	// 관리자용 회원 탈퇴시키기
	@RequestMapping("boardlist_member_getoutmember.do")
	public ModelAndView boardlist_Member_getOutmember(@RequestParam("u_idx") String u_idx) {
		int result = boardlist_Member_Service.getBoardlist_Member_getOutmember(u_idx);
		return new ModelAndView("redirect:boardlist_member.do");
	}

	// 검색하기
	@RequestMapping("boardlist_member_search.do")
	public ModelAndView boardlist_Member_Search(@ModelAttribute("search") String search,
			@ModelAttribute("radio") String radio) {
		ModelAndView mv = new ModelAndView("boardlist_member/boardlist_member");

		if (radio.equals("select_all")) {
			int count = boardlist_Member_Service.getTotalCount_AllSearch(search);
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

			List<Boardlist_Member_VO> boardlist_member_search = boardlist_Member_Service
					.getBoardlist_Member_AllSearch(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("boardlist_member", boardlist_member_search);
			mv.addObject("paging", paging);

		} else if (radio.equals("select_u_id")) {
			int count = boardlist_Member_Service.getTotalCount_Boardlist_Member_Email(search);
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

			List<Boardlist_Member_VO> boardlist_member_search = boardlist_Member_Service
					.getList_Boardlist_Member_Email(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_member", boardlist_member_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_nickname")) {
			int count = boardlist_Member_Service.getTotalCount_Boardlist_Member_NickName(search);
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

			List<Boardlist_Member_VO> boardlist_member_search = boardlist_Member_Service
					.getList_Boardlist_Member_NickName(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_member", boardlist_member_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_bday")) {
			int count = boardlist_Member_Service.getTotalCount_Boardlist_Member_BDay(search);
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

			List<Boardlist_Member_VO> boardlist_member_search = boardlist_Member_Service
					.getList_Boardlist_Member_BDay(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_member", boardlist_member_search);
			mv.addObject("paging", paging);
		}

		return mv;
	}
}
