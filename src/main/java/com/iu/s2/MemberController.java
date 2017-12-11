package com.iu.s2;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void insert(){}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String insert(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd){
		
		int result = 0;
		try {
			result = memberService.insert(memberDTO, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = "fail";
		if(result>0){
			message = "success";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:../";
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void login(){}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, HttpServletRequest request, RedirectAttributes rd){
		
		int result = 0;
		try {
			result = memberService.login(memberDTO, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "login fail";
		if(result>0){
			message = "login success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:../";
	}
	
	@RequestMapping(value="memberLogout")
	public String logout(HttpSession session){
		try {
			memberService.logout(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../";
	}
	
	@RequestMapping(value="memberMypage")
	public void selectOne(){}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public void update(){}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd){
		int result = 0;
		try {
			result = memberService.update(memberDTO, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "update fail";
		if(result>0){
			message = "update success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./memberMypage";
	}
	
	@RequestMapping(value="memberDelete")
	public String delete(String id, HttpSession session){
		
		return "redirect:../";
	}
}
