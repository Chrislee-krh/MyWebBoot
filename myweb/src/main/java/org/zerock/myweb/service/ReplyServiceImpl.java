package org.zerock.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.command.ReplyVO;
import org.zerock.myweb.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register" + vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(int rno) {
		log.info("get" + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify" + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(int rno) {
		log.info("remove" + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		log.info("list" + bno);
		return mapper.getListWithPaging(cri, bno);
	}

}
