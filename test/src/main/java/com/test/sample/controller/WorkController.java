package com.test.sample.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.service.WorkService;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping(value="/work")
public class WorkController {
	
	
	
	private static final String Exception = null;
	/*@Autowired
	private TestService testService;

	
	  @RequestMapping(value="/test.ajax")
	  @ResponseBody
	    public HashMap<String, Object> main() throws Exception{
	     
	        String test = testService.test();
	        HashMap<String, Object> map = new HashMap<String, Object>();
	      
	        map.put("test", test);
	        return map;
	    }
	    
	*/
	
	@Autowired WorkService workSerive;
	
	/*
	 * //리스트
	 * 
	 * @RequestMapping(value="/login.ajax")
	 * 
	 * @ResponseBody public List<Map<String, Object>> selectWorkList(Model model,
	 * Map<String, Object> map) {
	 * 
	 * List<Map<String,Object>> list = workSerive.selectWorkList(map);
	 * 
	 * model.addAttribute("list", list);
	 * 
	 * return list; }
	 */
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("멤버서블릿 호출");
	        String path = request.getContextPath();
	        String url = request.getRequestURI().toString();
	 
	        MemberDAO dao = new MemberDAO();
	 
	        // url 분석
	        // 로그인 이면
	        if (url.indexOf("login.do") != -1) {
	 
	            String userid = request.getParameter("userid");
	            String passwd = request.getParameter("passwd");
	            String name = dao.loginCheck(userid, passwd);
	            String message = "";
	 
	            if (name == null) { // 로그인 실패
	 
	                message = "아이디 또는 비밀번호가 일치하지 않습니다.";
	            } else { // 로그인 성공
	 
	                message = name + "님 환영합니다.";
	            }
	            // 데이터 저장
	            request.setAttribute("message", message);
	            // 포워딩
	 
	            String page = "/member/login_result.jsp";
	 
	            RequestDispatcher rd = request.getRequestDispatcher(page);
	            rd.forward(request, response);
	        }
	 
	    }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        doGet(request, response);
	    }
	 
	}
	    	
}
