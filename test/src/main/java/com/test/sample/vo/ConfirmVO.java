package com.test.sample.vo;

import lombok.Data;

@Data
public class ConfirmVO { //승인테이블
	
	private int confirmCode;		//승인코드
	private String confirmName;		//승인상태명
	
/**
1 = 대기
2 = 승인
3 = 반려
4 = 취소
 * **/

}
