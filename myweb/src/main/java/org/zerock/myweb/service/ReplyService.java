package org.zerock.myweb.service;

import java.util.List;

import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.command.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	public ReplyVO get(int rno);
	public int modify(ReplyVO vo);
	public int remove(int rno);
	public List<ReplyVO> getList(Criteria cri, int bno);
	
}
