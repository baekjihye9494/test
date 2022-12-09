package com.test.sample.vo;

import lombok.Data;

@Data
public class NoticeVO {
	
	
	private int noticeNo;			//게시물번
    private int noticeTitle;		//제목
    private String noticeContent;	//내용
    private String writer;			//작성자
    private int memberId;			//회원아이디
    private int siteCode;			//현장코드
    private String cratedDate;		//작업시작일자
    private String updateDate;		//작업종료일자
    private int views;				//조회수
    
    
    
    
    

}
