package org.zerock.myweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.myweb.command.MemberVO;

@Repository
@Mapper
public interface MemberMapper {
	
	public int join(MemberVO vo);	//회원가입
	public int login(MemberVO vo);	//로그인
	public int idCheck(String id);	//아이디 중복 체크(회원가입)

}
