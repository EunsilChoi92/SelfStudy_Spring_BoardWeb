package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDAO")
//public class BoardDAOMyBatis extends SqlSessionDaoSupport {
//DAO 클래스 구현 방법2
public class BoardDAOMyBatis {
	
//	@Autowired
//	@Override
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}
	
	//DAO 클래스 구현 방법2
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 insertBoard() 기능 처리");
//		getSqlSession().insert("BoardDAO.insertBoard", vo);
		
//		DAO 클래스 구현 방법2
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 updateBoard() 기능 처리");
//		getSqlSession().update("BoardDAO.updateBoard", vo);
		
//		DAO 클래스 구현 방법2
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 deleteBoard() 기능 처리");
//		getSqlSession().delete("BoardDAO.deleteBoard", vo);
		
//		DAO 클래스 구현 방법2
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 Board() 기능 처리");
//		return (BoardVO) getSqlSession().selectOne("BoardDAO.getBoard", vo);
		
//		DAO 클래스 구현 방법2
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis로 Board() 기능 처리");
//		return getSqlSession().selectList("BoardDAO.getBoardList", vo);
		
		//Dynamic SQL 사용 전
//		if(vo.getSearchCondition().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_T", vo);
//		} else if(vo.getSearchCondition().equals("CONTENT")) {
//			return mybatis.selectList("BoardDAO.getBoardList_C", vo);
//		}
//		
//		return null;
		
		//Dynamic SQL 사용 후
		return mybatis.selectList("BoardDAO.getBoardList", vo);
		
//		DAO 클래스 구현 방법2
//		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	
	
}
