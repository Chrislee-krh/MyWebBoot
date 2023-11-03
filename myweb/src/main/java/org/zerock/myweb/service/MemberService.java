package org.zerock.myweb.service;

import org.zerock.myweb.command.MemberVO;

public interface MemberService {
	
	public int idCheck(String id);
	public int join(MemberVO vo);
	public int login(MemberVO vo);

}
