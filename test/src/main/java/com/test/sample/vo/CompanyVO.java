package com.test.sample.vo;

import lombok.Data;

@Data
public class CompanyVO { //업체테이블
	
	private int companyCode;		//업체코드
	private String companyName;		//업체명
	
	
	/**
	랜덤한 4자리 숫자를 생성하여 업체코드로 사용
	1부터 1씩 증가하게 생성
	1 = 전체
	2 = 대림이엔씨
	3 = 철강산업
	4 = 대림산업
	....
	
	 */
	
	
	
}
