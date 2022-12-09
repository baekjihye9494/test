package com.test.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.ConfirmVO;
import com.test.sample.vo.MemberVO;
import com.test.sample.vo.SiteVO;
import com.test.sample.vo.NoticeVO;


public interface WorkService {
	
	
	

	//조출/야간작업근로자 신청 현황 (관리자 권한을 가진사람이 조회시 현장 전체 게시물 조회)
    List<NoticeVO> selectAllWorkList(NoticeVO vo);
    //조출/야간작업근로자 신청 현황 (현장코드를 가진사람이 조회시 본인이 근무하는 현장의 게시물 조회)
    List<NoticeVO> selectWorkList(NoticeVO vo);
    
    //현장담당자 리스트  (권한코드 40인 
    List<MemberVO> selectAuthorityY(MemberVO vo);
    //총 게시물 갯수 
    int selectAddworkTotal(NoticeVO vo);
    
    //작업신청 등록(전부 사용가능)
    void insertWork(NoticeVO vo);	
    
    //작업신청 수정(승인상태가 대기인 경우 관리자+작성자와 같은업체만 가능)
    void updateWork(NoticeVO vo);	
    
    //작업신청 삭제 (승인상태가 대기인 경우 관리자+작성자만 삭제가능)
    void deleteWork(NoticeVO vo);	

    //승인(관리자 권한만 사용가능) - 업데이트 상태변경 (대기 > 승인)
    void workConfirm(NoticeVO vo);
   
    //반려(관리자 권한만 사용가능) - 업데이트 상태변경  (대기 > 반려)
    void workCompanion(NoticeVO vo);
    
    //신청취소(관리자 + 작성자 50 권한만 사용가능) - 업데이트 상태변경 (대기 > 승인취소)
    void workCancel(NoticeVO vo);
    
    //승인완료후 취소(관리자 권한만 사용 가능 / 10,20) - 업데이트 상태변경 (승인 > 취소)
    void workAfterCancel(NoticeVO vo);    
    
    //로그인한 회원 현장명 조회
    void userSiteName(Map<String,Object> param);
    
    
    //권한을 가져오는 쿼리
    Map<String, Object> ahType(String loginId);

	//승인상태 가져오기
   	List< Map<String, Object>> confirm();
    
    //전체현장
    List<Map<String, Object>> stList();
    //개별현장
    List<Map<String, Object>> stName(String loginId);

   	//관리자일경우 전체업체명 보기
	List<Map<String, Object>> cpList();
	//업체명가져오기
   	List< Map<String, Object>> cpName(String loginId);

   	
}
