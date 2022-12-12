package com.test.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.service.NoticeService;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.NoticeVO;
import com.test.sample.vo.PagingVO;
import com.test.sample.vo.SiteVO;

@RestController
@RequestMapping(value="notice")
public class NoticeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired private NoticeService noticeService;
	

	//로그인하기
    @RequestMapping(value = "/login.ajax")
    @ResponseBody
    public HashMap<String, Object> login(
            @RequestParam String member_id, @RequestParam String member_pw
            ,HttpSession session){
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        boolean loginSuccess = noticeService.loginChk(member_id,member_pw);
        logger.debug("확인 : " + loginSuccess );
        //세션에 저장
        if(loginSuccess == true) {
            session.setAttribute("loginId", member_id);
        }
        map.put("loginSuccess", loginSuccess);
        return map;
        
    }
  

	//로그아웃
	@RequestMapping(value="/logout")
	public HashMap<String, Object> logout(HttpSession session) {
		session.removeAttribute("loginId");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("logout", "success");
		logger.debug("세션 로그아웃 확인---->" + map );
		return map;

	}
	
	
    
	//업체, 현장, 사이트 코드를 가져오는 컨트롤러?
	@RequestMapping(value = "/selectList.ajax")
	@ResponseBody
	public HashMap<String, Object> selectList(HttpSession session){
	    
		HashMap<String, Object> map = new HashMap<String, Object>();
		String loginId = (String) session.getAttribute("loginId");
		logger.debug(loginId);
		
		HashMap<String, Object> ahType = noticeService.ahType(loginId);
		
		//현장 데이터,업체 데이터 가지고 오기
		ahType.put("loginId", loginId);
		ArrayList<SiteVO> site = noticeService.site();
		ArrayList<CompanyVO> company = noticeService.company(ahType);
		logger.debug("현장명 : " + site.toString());
		logger.debug("업체명 : " + company.toString());
		map.put("site", site);
		map.put("company", company);
	   
	    return map;
	}
   

	
	/*권한과 업체에 맞게 리스트 불러오기*/
	@RequestMapping(value = "/list.ajax")
	@ResponseBody
	public HashMap<String, Object> noticeList(HttpSession session,
		@RequestParam HashMap<String, String> params){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String loginId = (String) session.getAttribute("loginId");
		logger.debug(loginId);
		
		
		//회원의 권한(관리자 여부)과 업체코드 갖고오기 
		HashMap<String, Object> Info = noticeService.ahType(loginId);
		logger.debug("info 확인 :  "  + Info);
		Info.put("loginId", loginId);
		

		//params 확인(selectbox,검색값) 
		logger.debug("sorting :"+ params.get("sorting"));
		logger.debug("site_code : " + params.get("site_code"));
		logger.debug("company_code : " + params.get("company_code"));
		logger.debug("search_option : " + params.get("search_option"));
		logger.debug("search_keyword : " + params.get("search_keyword"));
		Info.put("sorting", params.get("sorting"));
		Info.put("site_code", params.get("site_code"));
		Info.put("conpany_code", params.get("conpany_code"));
		Info.put("search_option", params.get("search_option"));
		Info.put("search_keyword", params.get("search_keyword"));
		
		
		//페이징
		int page = Integer.parseInt(params.get("page"));
		logger.info("보여줄 페이지================================= : " + page);
		
		int num_page_size = 10; //한페이지 출력 개수 
		int num_start_row =((page-1)*num_page_size)+1;
		int num_end_row = (page * num_page_size);
		Info.put("num_start_row", num_start_row);
		Info.put("num_end_row", num_end_row);

		logger.debug("num_start_row : " + num_start_row);
		logger.debug("num_end_row : " + num_end_row);
		
		int allCnt = noticeService.allCount(Info);
		logger.debug("총 게시물 수 : " + allCnt);

		//생성가능한 페이지 page 2 allcnt4 /
		int pages = allCnt%num_page_size>0? (allCnt/num_page_size+1) : (allCnt/num_page_size);
		if(pages<page) {
			page = pages;
		}
		map.put("pages", pages);
		map.put("currPage", page);
				
		logger.info("==================================================" + Info);
		//권한과 업체에 따른 리스트 가져오기
		ArrayList<NoticeVO> noticeList = noticeService.list(Info);
		logger.info(" 개수 : " + noticeList.size() );
		map.put("noticeList", noticeList);
				
	    return map;
	}
	
	
   
	

}
