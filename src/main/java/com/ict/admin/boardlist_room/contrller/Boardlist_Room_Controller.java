package com.ict.admin.boardlist_room.contrller;

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

import com.ict.admin.boardlist_room.model.service.Boardlist_Room_Service;
import com.ict.admin.boardlist_room.model.vo.Boardlist_Room_VO;
import com.ict.admin.common.Paging;

@Controller
public class Boardlist_Room_Controller {

	@Autowired
	private Boardlist_Room_Service boardlist_Room_Service;

	@Autowired
	private Paging paging;

	String cPage;

	private static final Logger logger = LoggerFactory.getLogger(Boardlist_Room_Controller.class);

	public void setBoardlist_Room_Service(Boardlist_Room_Service boardlist_Room_Service) {
		this.boardlist_Room_Service = boardlist_Room_Service;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@RequestMapping("boardlist_room.do")
	public ModelAndView getboardList_Room(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("boardlist_room/boardlist_room");
		// 전체 게시물의 수
		int count = boardlist_Room_Service.getTotalCount();
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
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}

		List<Boardlist_Room_VO> boardlist_room = boardlist_Room_Service.getList(paging.getBegin(), paging.getEnd());
		mv.addObject("boardlist_room", boardlist_room);
		mv.addObject("paging", paging);

		return mv;
	}

	// 관리자용 방 삭제
	@RequestMapping("boardlist_room_admindelete.do")
	public ModelAndView boardlist_Room_Admindelete(@RequestParam("room_idx") String room_idx) {
		int result = boardlist_Room_Service.getBoardlist_Room_Admindelete(room_idx);
		return new ModelAndView("redirect:boardlist_room.do");
	}

	// 검색 기능
	@RequestMapping("boardlist_room_search.do")
	public ModelAndView boardlist_Room_Search(@ModelAttribute("search") String search,
			@ModelAttribute("radio") String radio) {
		ModelAndView mv = new ModelAndView("boardlist_room/boardlist_room");
		if (radio.equals("select_all")) {
			int count = boardlist_Room_Service.getTotalCount_AllSearch(search);
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

			List<Boardlist_Room_VO> boardlist_room_search = boardlist_Room_Service
					.getBoardlist_Room_AllSearch(paging.getBegin(), paging.getEnd(), search);

			mv.addObject("boardlist_room", boardlist_room_search);
			mv.addObject("paging", paging);

		} else if (radio.equals("select_category")) {
			int count = boardlist_Room_Service.getTotalCount_Boardlist_Room_Category(search);
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

			List<Boardlist_Room_VO> boardlist_room_search = boardlist_Room_Service
					.getList_Boardlist_Room_Category(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_room", boardlist_room_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_room_title")) {
			int count = boardlist_Room_Service.getTotalCount_Boardlist_Room_Title(search);
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

			List<Boardlist_Room_VO> boardlist_room_search = boardlist_Room_Service
					.getList_Boardlist_Room_Title(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_room", boardlist_room_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_u_nickname")) {
			int count = boardlist_Room_Service.getTotalCount_Boardlist_Room_U_Nickname(search);
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

			List<Boardlist_Room_VO> boardlist_room_search = boardlist_Room_Service
					.getList_Boardlist_Room_U_Nickname(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_room", boardlist_room_search);
			mv.addObject("paging", paging);
		} else if (radio.equals("select_write_datetime")) {
			int count = boardlist_Room_Service.getTotalCount_Boardlist_Room_Write_Datetime(search);
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

			List<Boardlist_Room_VO> boardlist_room_search = boardlist_Room_Service
					.getList_Boardlist_Room_Write_Datetime(paging.getBegin(), paging.getEnd(), search);
			mv.addObject("boardlist_room", boardlist_room_search);
			mv.addObject("paging", paging);
		}
		return mv;

	}

}
