package com.test.sample.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	
	private int noticeNo;			//게시물번
    private String noticeTitle;		//제목
    private String noticeContent;	//내용
    private String memberId;		//회원아이디
    private int siteCode;			//현장코드
    private String siteName;			//현장명
    private int companyCode;		//현장코드
    private String companyName;		//현장명
    private String noticeDate;		//작업시작일자
    private String updateDate;		//작업종료일자
    private int views;				//조회수
    private String memberName;		//작업종료일자
    
    private Date createDate;
    
    
    

}
