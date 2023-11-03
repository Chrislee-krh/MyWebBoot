package org.zerock.myweb.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.command.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@MybatisTest //단위 테스트
@SpringBootTest // 전체 테스트
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase 이것만 치면 ds못 부름
//위는 실 DB에 연결시 필요한 어노테이션. 직접 DB연결안해도 TEST 가능케함

public class MyBatisTest {
	   
	   @Setter(onMethod_ = {@Autowired})
	   private ReplyMapper mapper;
	   
	   @Test
	   public void testMapper() {
	      log.info(mapper);
	   }

	   //insert 테스트
	   //테스트 전에 해당 번호의 게시물이 존재하는지 여부를 확인
	   private int[] bnoArr = {123 ,93, 20, 35, 176, 200};

	   @Test
	   public void testCreate() {
	      IntStream.rangeClosed(1,11).forEach(i -> {
	         ReplyVO vo = new ReplyVO();
	            //게시물 번호
	         vo.setBno(bnoArr[i % 5]);
	         vo.setReply("댓글 테스트 " +i);
	         vo.setReplyer("replyer"+i);
	         mapper.insert(vo);
	      });
	   }
	   
	   @Test
	   public void testRead() { 
	      int targetRno = 13;
	      ReplyVO vo = mapper.read(targetRno);
	      log.info(vo);
		}

	   @Test
	   public void testDelete() {
		   int targetRno = 13;
		   mapper.delete(targetRno);
	   }
	   
	   @Test
	   public void testUpdate(){
	      int targetRno = 16;
	      ReplyVO vo = mapper.read(targetRno);
	      vo.setReply("Update Reply ");
	      int count = mapper.update(vo);
	      log.info("UPDATE COUNT: " + count);
	   }
	   
	   @Test
	   public void testList() {
	      Criteria cri = new Criteria();
	      //3145745
	      List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[1]);
	      replies.forEach(reply -> log.info(reply));
	   }
   
	}