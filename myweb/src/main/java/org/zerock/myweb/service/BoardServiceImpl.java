package org.zerock.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myweb.command.BoardVO;
import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		// 전체 게시물 리스트 불러오기.... 
		return mapper.getList();
	}

	@Override
	public void register(BoardVO vo) {
		// 게시물 등록
		mapper.insertBoard(vo);
	}

	@Override
	public BoardVO getContent(String num) {
		// 게시물 상세보기
		return mapper.getContent(num);
	}

	@Override
	public void update(BoardVO vo) {
		// 게시물 수정하기... 
		boolean result = mapper.updateBoard(vo);
		System.out.println("성공실패? "+result);
	}

	@Override
	public void delete(String num) {
		// 게시물 삭제
		mapper.deleteBoard(num);
	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.pagingList(cri);
	}
	
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}

}
