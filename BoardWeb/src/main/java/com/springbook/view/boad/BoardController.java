package com.springbook.view.boad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do";	//포워딩 방식(리다이렉트를 원하면 redirect:를 붙여야 함	
									//포워딩 방식은 최종 URL이 insertBoard.do로 그대로 남아있음
	}
	
	//글 수정	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("board", boardDAO.getBoard(vo));	//Model 정보 저장
		mav.setViewName("getBoard-mvc.jsp");			//View 정보 저장
		
		return mav;
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public ModelAndView GetBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("boardList", boardDAO.getBoardList(vo));	//Model 정보 저장
		mav.setViewName("getBoardList-mvc.jsp");				//View 정보 저장
		
		return mav;
	}

}
