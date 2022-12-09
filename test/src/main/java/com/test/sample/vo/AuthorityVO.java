package com.test.sample.vo;

import lombok.Data;

@Data
public class AuthorityVO { //권한 테이블
	
	private int authorityCode;		//권한코드
	private String authorityName;	//권한명
	private String authorityType;	//권한타입
	/**
	10	개발자
	20	전체관리자
	30	유관부서
	40	현장관리자
	50	사용자
	**/
	
}
