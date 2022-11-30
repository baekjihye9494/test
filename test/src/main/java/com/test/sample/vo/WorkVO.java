package com.test.sample.vo;

import lombok.Data;

@Data
public class WorkVO {
	
	
	private int workNo;				//작업게시물번
	private String workLocation;	//작업위치
    private int workPeople;			//작업인원
    private String workKind;		//작업종류
    private int memberCode;			//회원코드
    private int siteCode;			//현장코드
    private int confirmCode;		//승인코드
    private String workStartDate;	//작업시작일자
    private String workEndDate;		//작업종료일자
    
    
    private String siteName;		//현장명
    private String authorityName;	//권한명
    private int companyCode;		//업체코드
    
    
    
    

}
