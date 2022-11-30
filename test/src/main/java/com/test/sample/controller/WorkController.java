package com.test.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	//리스트
	@RequestMapping(value="/workList.ajax")
	@ResponseBody
	public List<Map<String, Object>> selectWorkList(Model model, Map<String, Object> map) {

		List<Map<String,Object>> list = workSerive.selectWorkList(map);
		
		model.addAttribute("list", list);

		return list;
	}
	
	//내가 근무하는 현장 명 조회
	@RequestMapping(value="/userSiteName.ajax")
	@ResponseBody
		public String userSiteName(@RequestParam String memberId, @RequestParam int siteCode) {

			String list = "";
			
			
			return list;
		}
		
	    	
}
