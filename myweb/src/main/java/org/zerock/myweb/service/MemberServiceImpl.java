package org.zerock.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myweb.command.MemberVO;
import org.zerock.myweb.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;

	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public int join(MemberVO vo) {
		return mapper.join(vo);
	}

	@Override
	public int login(MemberVO vo) {
		return mapper.login(vo);
	}
	
}
