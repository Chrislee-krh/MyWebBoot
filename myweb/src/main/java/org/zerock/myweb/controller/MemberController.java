package org.zerock.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myweb.command.MemberVO;
import org.zerock.myweb.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("")
	public String goHome() {
		return "home";
	}
	
	//조인 화면 처리
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	//로그인 화면 처리
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	//ajax요청 받기... 
	//json 라이브러를 이용해서 처리... 
//	<dependency>
//	    <groupId>com.fasterxml.jackson.core</groupId>
//	    <artifactId>jackson-databind</artifactId>
//	    <version>2.15.2</version>
//	</dependency>
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	// 메서드 @ResponseBody 로 어노테이션 되어 있으면 메서드에서 리턴되는 값은 
	// View리졸버로 전달되지 않음. 해당 메서드를 호출한 곳으로 결과를 반환함.
	public int checkId(@RequestParam("id") String id) {
		int result = memberService.idCheck(id);
		
		return result;
	}
	
	//회원 가입 폼 처리
	@RequestMapping(value = "/joinForm")
	public String joinForm(MemberVO vo , RedirectAttributes RA) {
		int result = memberService.join(vo);
		
		if(result == 1) {  // insert 성공
			RA.addFlashAttribute("msg", "회원가입에 성공했습니다.");
		}else {  // insert 실패
			RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
		}
		
		return "redirect:/member/login";
	}
	
	
	//login 폼 처리
	@RequestMapping(value = "/loginForm" , method = RequestMethod.POST)
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
		
		int result = memberService.login(vo);
		
		if(result == 1) {  //1개의 카운트 값이 나왔다는 것은 로그인 성공
			// 세션 생성.... 
			session.setAttribute("user_id", vo.getId()); //세션에 아이디 저장...
			return "redirect:/";   //홈으로 이동.... 
		}else {  //로그인 실패
			// 실패 메시지를 가지고, login 페이지로 이동... 
			RA.addFlashAttribute("msg", "아이디 혹은 비밀번호를 확인해주세요!"); //1회성 데이터에 msg저장
			return "redirect:/member/login";
		}
	}
	
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	//ajax 테스트
	@RequestMapping("/ajax_test")
	public String test() {
		return "member/ajax_test";
	}
	

}
