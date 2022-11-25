package com.test.sample.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.service.TestService;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping(value="/notice")
public class TestController {
	
	@Autowired
	private TestService testService;

	/*
	  @RequestMapping(value="/test.ajax")
	  @ResponseBody
	    public HashMap<String, Object> main() throws Exception{
	     
	        String test = testService.test();
	        HashMap<String, Object> map = new HashMap<String, Object>();
	      
	        map.put("test", test);
	        return map;
	    }
	    
	*/
	    	
}
