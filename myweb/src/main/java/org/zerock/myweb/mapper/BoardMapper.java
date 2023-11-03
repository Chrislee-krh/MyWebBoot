package org.zerock.myweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.myweb.command.BoardVO;
import org.zerock.myweb.command.Criteria;

@Repository
@Mapper
public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);//게시판 등록
	public boolean updateBoard(BoardVO vo);//게시판 수정
	public void deleteBoard(String num);//게시판 삭제
	public List<BoardVO> getList();//게시판 목록 가져오기(모든)
	public BoardVO getContent(String num);//게시판 상세보기 
	
	//페이징 쿼리문 : 매개변수로 Criteria 클래스를 받아서 특정 페이지의 게시글을 출력하는 메서드
	public List<BoardVO> pagingList(Criteria cri);
	
	//전체 게시글 데이터 수
	public int getTotal();
	
	

}
