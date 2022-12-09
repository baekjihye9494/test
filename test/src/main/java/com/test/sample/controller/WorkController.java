package com.test.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.service.WorkService;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.ConfirmVO;
import com.test.sample.vo.MemberVO;
import com.test.sample.vo.SiteVO;
import com.test.sample.vo.NoticeVO;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping(value="/work")
public class WorkController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
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
	//업체, 현장, 사이트 코드를 가져오는 컨트롤러?
    @RequestMapping(value = "/selectList.ajax" )
    @ResponseBody
    public Map<String, Object> selectList(HttpSession session){
        
        Map<String, Object> map = new HashMap<String, Object>();
        String loginId = (String) session.getAttribute("loginId");
        logger.info("세션에 담은 아이디 값>>>" + loginId);
        
        int result = 0;
        
        Map<String, Object> ahType = workSerive.ahType(loginId);
        logger.info("ahType>>>" + ahType);
      
        ahType.put("loginId",loginId);
       
        
        
        List<Map<String, Object>> company = workSerive.company(ahType);
        List<Map<String, Object>> confirm = workSerive.confirm();
        List<Map<String, Object>> stNameN = workSerive.stNameN(loginId);

        
        map.put("company", company);
        map.put("confirm", confirm);
        map.put("stNameN", stNameN);
        
        logger.info("업체명: " + company.toString());
        logger.info("승인상태 : " + confirm.toString());
        logger.info("현장명 : " + stNameN.toString());
       
        
        return map;
    }
    */
	
	
	
	 @RequestMapping(value = "/selectList.ajax" )
	 @ResponseBody
	 public  HashMap<String, Object> site(HttpSession session){
		 
		HashMap<String, Object> map = new HashMap<>();
        String loginId = (String) session.getAttribute("loginId");
        logger.info("세션에 담은 아이디 값>>>" + loginId);
        
        Map<String, Object> ahType = workSerive.ahType(loginId);
        logger.info("ahType>>>" + ahType);

        ahType.put("loginId",loginId);
        List<Map<String, Object>> stList = workSerive.stList();
        List<Map<String, Object>> mySt = workSerive.stName(loginId);
        List<Map<String, Object>> cpList = workSerive.cpList();
        List<Map<String, Object>> myCp = workSerive.cpName(loginId);
        List<Map<String, Object>> confirm = workSerive.confirm();

        map.put("ahType", ahType);
        map.put("stList",stList);
        map.put("mySt",mySt);
        map.put("cpList", cpList);
        map.put("myCp", myCp);
        map.put("confirm", confirm);

        logger.info("ahType>>>" +ahType);
        logger.info("stList>>>" + stList);
        logger.info("mySt>>>" + mySt);
        logger.info("cpList>>>" +cpList);
        logger.info("myCp>>>" + myCp);
        logger.info("confirm>>>" + confirm);
        
		 return map;
	 }
    
 
	
}
