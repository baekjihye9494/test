package com.test.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.sample.service.MemberService;
import com.test.sample.vo.MemberVO;


@RestController
@RequestMapping("/member")
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberService memberService;
	
	
	
	//로그인하기
	  @RequestMapping(value = "/login.ajax")
	  @ResponseBody
	    public HashMap<String, Object> login(
	            @RequestParam String member_id, @RequestParam String member_pw
	            ,HttpSession session){
	        HashMap<String, Object> map = new HashMap<String, Object>();



	       boolean loginSuccess = memberService.loginChk(member_id,member_pw);
	        logger.info("확인 : " + loginSuccess );
	        
	        
	        //세션에 저장
	        if(loginSuccess == true) {
	            session.setAttribute("loginId", member_id);
	        }
	        
	        map.put("loginSuccess", loginSuccess);
	       
	        return map;
	    }
	  
	  
	
		//로그아웃 처리
//		@RequestMapping(value = "/logout.ajax")
//		@ResponseBody
//		public ModelAndView logout(HttpSession session) {
//			
//			memberService.logout(session);
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("login");
//			mav.addObject("msg", "logout");
//			
//			return mav;
//		}
}
