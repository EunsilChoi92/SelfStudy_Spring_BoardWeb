package com.springbook.view.boad;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")	//Model에 "board"라는 이름으로 저장되는 데이터가 있다면 그 데이터를 세션(HttpSession)에도 자동 저장하라는 설정
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";	//포워딩 방식(리다이렉트를 원하면 redirect:를 붙여야 함	
									//포워딩 방식은 최종 URL이 insertBoard.do로 그대로 남아있음
	}
	
	//글 수정	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	
	// 글 상세 조회
//	@RequestMapping(value="/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		mav.addObject("board", boardDAO.getBoard(vo));	//Model 정보 저장
//		mav.setViewName("getBoard-mvc.jsp");			//View 정보 저장
//		
//		return mav;
//	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));	//Model 정보 저장
		return "getBoard-mvc.jsp";	//View 이름 리턴
	}
	
	
	//겁색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditinoMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	
 	// 글 목록 검색
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView GetBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		mav.addObject("boardList", boardDAO.getBoardList(vo));	//Model 정보 저장
//		mav.setViewName("getBoardList-mvc.jsp");				//View 정보 저장
//		
//		return mav;
//	}
	
	
	@RequestMapping("/getBoardList.do")
	public String GetBoaradList(BoardVO vo, Model model) {
//	public String GetBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, 
//			BoardVO vo, BoardDAO boardDAO, Model model) {
//		
//		System.out.println("검색 조건: " + condition);
//		System.out.println("검색 단어: " + keyword);
		
		//NullCheck
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		//Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));	//Model 정보 저장
		return "getBoardList-mvc.jsp";	//View 이름 리턴
	}

}
