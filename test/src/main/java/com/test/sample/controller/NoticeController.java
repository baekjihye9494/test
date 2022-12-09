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
@RequestMapping(value="/notice")
public class NoticeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired NoticeService noticeService;
	
	/*로그아웃*/
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
		logger.debug("세션 loginId 확인---->" + loginId );
		
		HashMap<String, Object> ahType = noticeService.ahType(loginId);
		//현장 데이터,업체 데이터 가지고 오기
		map.put("ahType", ahType);
		logger.info("ahType>>>" +ahType);
		
		
		//전체현장 리스트 담기
		ArrayList<Map<String, Object>> stList = noticeService.stList();
		//나의현장 리스트 담기
		ArrayList<Map<String, Object>> mySt = noticeService.mySt(loginId);
		//전체업체 리스트 담기
		ArrayList<Map<String, Object>> cpList = noticeService.cpList();
		//나의업체 리스트 담기	    
		ArrayList<Map<String, Object>> myCp = noticeService.myCp(loginId);
		
		map.put("stList",stList);
		map.put("mySt",mySt);
		map.put("cpList", cpList);
		map.put("myCp", myCp);
		
		logger.info("stList>>>" + stList);
		logger.info("mySt>>>" + mySt);
		logger.info("cpList>>>" +cpList);
		logger.info("myCp>>>" + myCp);
       
		return map;
	 
	}
   
	
	

	
	/*권한과 업체에 맞게 리스트 불러오기*/
	@RequestMapping(value = "/list.ajax")
	@ResponseBody
	public HashMap<String, Object> noticeList(HttpSession session,
		@RequestParam HashMap<String, Object> params){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String loginId = (String) session.getAttribute("loginId");
		logger.info(loginId);
		
		
		//회원의 권한(관리자 여부)과 업체코드 갖고오기 
		HashMap<String, Object> ahType = noticeService.ahType(loginId);
		ahType.put("loginId", loginId);
		//권한 가져오기
		logger.info("loginId :"+ loginId);

		//에이작스에서 선언한 변수를 파라메타 값(params.get("파라미터변수명")으로 불러온다.
		// 셀렉트박스에 넣은 id
		logger.info("sorting :"+ params.get("sorting")); 
		logger.info("stName : " + params.get("stName"));
		logger.info("cpName : " + params.get("cpName"));
		logger.info("searchType : " + params.get("searchType"));
		logger.info("keyword : " + params.get("keyword"));
		ahType.put("sorting", params.get("sorting"));
		ahType.put("stName", params.get("stName"));
		ahType.put("cpName", params.get("cpName"));
		ahType.put("searchType", params.get("searchType"));
		ahType.put("keyword", params.get("keyword"));
		
		
		//페이징
		int currentPage = Integer.parseInt((String) params.get("currentPage"));
		logger.info("보여줄 페이지================================= : " + currentPage);
		
		int num_page_size = 10; //한페이지 출력 개수 
		int num_start_row =((currentPage-1)*num_page_size)+1;
		int num_end_row = (currentPage * num_page_size);
		ahType.put("num_start_row", num_start_row);
		ahType.put("num_end_row", num_end_row);
		int countBoard = noticeService.countBoard(ahType);
		logger.info("총 게시물 수 : " + countBoard);

		//생성가능한 페이지 page 2 allcnt4 /
		int currentPages = countBoard%num_page_size>0? (countBoard/num_page_size+1) : (countBoard/num_page_size);
		if(currentPages<currentPage) {
			currentPage = currentPages;
		}
		map.put("currentPages", currentPages);
		map.put("currentPage", currentPage);
				
		logger.info("==================================================" + ahType);
		//권한과 업체에 따른 리스트 가져오기
		ArrayList<NoticeVO> noticeList = noticeService.selectNoticeList(ahType);
		logger.info(" 개수 : " + noticeList.toString());
		map.put("noticeList", noticeList);
				
	    return map;
	}
	
	
   
	

}
