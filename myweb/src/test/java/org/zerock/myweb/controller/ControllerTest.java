package org.zerock.myweb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.zerock.myweb.command.ReplyVO;
import org.zerock.myweb.service.ReplyService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebMvcTest(controllers = ReplyController.class) //테스트를 위한 컨트롤러를 지정
public class ControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	//ReplyController에서 잡고 있는 Bean객체에 대해서 Mock형태의 객체를 생성
	@MockBean
	ReplyService replyService;
	
	@Test
	@DisplayName("데이터 생성 테스트")
	public void createReplyTest() throws Exception {
		//Mock 객체에서 특정 메서드가 실행되는 경우, 실제 return을 줄 수 없어서 상황의 가정이 필요.
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBno(93);
		replyVO.setReply("Controller를 이용한 웹 테스트");
		replyVO.setReplyer("testuser");
		Gson gson = new Gson();
		String replyVOJson = gson.toJson(replyVO);
		log.info(replyVOJson);
		
		mockMvc.perform(post("/replies/new")
				.content(replyVOJson)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is(200));
	}
}
