package com.test.sample.vo;

import lombok.Data;

@Data
public class MemberVO {
	
	private String memberId;
	private String memberPw;
	private int memberCode;
	private String memberName;
	private int companyCode;
	private int authorityCode;
	
	/**
	 * memberCode = 2022부터 01씩 증가
	 * 
	 */
	
	

}
