package org.zerock.myweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.command.ReplyVO;

@Mapper
@Repository
public interface ReplyMapper {
	public int insert(ReplyVO vo); //추가
	public ReplyVO read(int rno); //읽기
	public int delete(int rno); //지우기
	public int update(ReplyVO reply);
	// @Param 어노테이션(Mybatis)
	// Mybatis에서 두 개 이상의 데이터를 파라미터로 전달하려고 씀
	// 1. 별도의 객체 구성
	// 2. Map
	// 3. @Param을 이용(""로 이름 무작위로 바꿀 수 있음) 
	public List<ReplyVO> getListWithPaging(
		      @Param("cri") Criteria cri,
		      @Param("bno") int bno);
	
}
