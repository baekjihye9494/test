package com.test.sample.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.work.service.WorkService;

@RequestMapping("/work")
@RestController
public class WorkController {
	
	@Autowired WorkService workService;
	
	//작업신청리스트
	@RequestMapping(value = "/workAddList")
	public String WorkAddList() {
		
		return "";
	}
	
	
	
	

}
