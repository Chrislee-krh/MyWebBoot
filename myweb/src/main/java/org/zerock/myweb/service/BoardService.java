package org.zerock.myweb.service;

import java.util.List;

import org.zerock.myweb.command.BoardVO;
import org.zerock.myweb.command.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList(); //게시물 리스트 가져오는 메서드
	public void register(BoardVO vo);  //게시물 등록 메서드
	public BoardVO getContent(String num); //게시물 상세보기 메서드
	public void update(BoardVO vo); //게시물 수정
	public void delete(String num); //게시물 삭제
	
	//페이징 처리 
	public List<BoardVO> getList(Criteria cri); //페이징 처리된 게시글 
	public int getTotal();						//전체 게시글 수

}
