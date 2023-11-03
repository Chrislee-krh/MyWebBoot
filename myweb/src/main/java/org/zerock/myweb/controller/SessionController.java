package org.zerock.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	
	// 세션 연습을 위한 컨트롤러!!!
	
	//1.main화면 처리... 
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	}
	
	//2.로그인 페이지 화면처리
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "session/loginPage";
	}
	
	//3.마이페이지 화면 처리... 
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(HttpSession session) {
		//8. 마이페이지 접근 차단
		//9. Interceptor를 통한 설정
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage";
//		}
		return "session/myPage";
	}
	
	//3.정보수정 페이지
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String updatePage() {
		
		//8. 마이페이지(정보수정 페이지) 접근 차단
		//9. Interceptor를 통한 설정
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage";
//		}
		
		return "session/updatePage";
	}
	
	//4.로그인 폼 처리
	@RequestMapping(value = "/sessionLogin", method = RequestMethod.POST)
	public String sessionLogin(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session,
			RedirectAttributes RA
			) {
		
//		System.out.println(id);
//		System.out.println(pw);
		
		//5. 아이디가 abc, 비밀번호가 1234 라면 로그인 성공이라고 가정
		if(id.equals("abc") && pw.equals("1234")) {
			session.setAttribute("user_id", id);		//세션 user_id에 id값을
			session.setAttribute("user_name", "홍길동");  //세션 user_name에 "홍길동" 저장
			return "redirect:/session/myPage";
		}
		else {  //아이디와 비밀번호가 틀렸을 때, 다시 로그인 화면으로 이동... 
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인해주세요!");
			return "redirect:/session/loginPage";  		//다시 로그인 페이지로 이동
		}
	}
	
	//7. 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		session.invalidate();
		
		return "redirect:/session/mainPage";
	}
	
	
	
	
	
	


}
