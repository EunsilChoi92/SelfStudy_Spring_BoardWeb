package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login-mvc.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리...");
		if(userDAO.getUser(vo) != null) {
			return "getBoardList.do";
		} else {
			return "login-mvc.jsp";
		}
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)  {
//		
//		System.out.println("로그인 처리");
//		
//		//1. 사용자 입력 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		//2. DB 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		
//		//3. 화면 네비게이션
//		ModelAndView mav = new ModelAndView();
//		
//		if(user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login-mvc.jsp");
//		}
//		return mav;
//		
//	}

}
