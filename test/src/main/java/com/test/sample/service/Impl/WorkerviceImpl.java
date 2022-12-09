package com.test.sample.service.Impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.test.sample.mapper.WorkMapper;
import com.test.sample.service.WorkService;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.ConfirmVO;
import com.test.sample.vo.MemberVO;
import com.test.sample.vo.SiteVO;
import com.test.sample.vo.NoticeVO;

@Service("workService")
public class WorkerviceImpl implements WorkService {
	/*
	 * @Autowired private TestDAO testDao;
	 * 
	 * @Override
	 * 
	 * @Transactional public String test() throws Exception { return
	 * testDao.selectTest(); }
	 */
	
	
	@Autowired private WorkMapper workMapper;
	
	
	
	
	
	
	 //조출/야간작업근로자 신청 현황 (관리자 권한을 가진사람이 조회시 현장 전체 게시물 조회)

	
	
	
	@Override    //작업신청 등록(전부 사용가능)
	public void insertWork(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override  //작업신청 수정(승인상태가 대기인 경우 관리자+작성자와 같은업체만 가능)
	public void updateWork(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override//작업신청 삭제 (승인상태가 대기인 경우 관리자+작성자만 삭제가능)
	public void deleteWork(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}


	@Override//승인(관리자 권한만 사용가능) - 업데이트 상태변경 (대기 > 승인)
	public void workConfirm(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override //반려(관리자 권한만 사용가능) - 업데이트 상태변경  (대기 > 반려)
    public void workCompanion(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override    //신청취소(관리자 + 작성자 50 권한만 사용가능) - 업데이트 상태변경 (대기 > 승인취소)
	public void workCancel(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override //승인완료후 취소(관리자 권한만 사용 가능 / 10,20) - 업데이트 상태변경 (승인 > 취소)
	public void workAfterCancel(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override  //로그인한 회원 현장명 조회
	public void userSiteName(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeVO> selectAllWorkList(NoticeVO vo) {
		// TODO Auto-generated method stub
		return workMapper.selectWorkList(vo);
	}

	@Override
	public List<NoticeVO> selectWorkList(NoticeVO vo) {
		// TODO Auto-generated method stub
		return workMapper.selectWorkList(vo);
	}

	@Override
	public List<MemberVO> selectAuthorityY(MemberVO vo) {
		// TODO Auto-generated method stub
		return workMapper.selectAuthorityY(vo);
	}

	@Override
	public int selectAddworkTotal(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Map<String, Object> ahType(String loginId) {
		// TODO Auto-generated method stub
		return workMapper.ahType(loginId);
	}

	
	//승인리스트
	@Override
	public List<Map<String, Object>> confirm() {
		// TODO Auto-generated method stub
		return workMapper.confirm();
	}

	//전체현장
	@Override
	public List<Map<String, Object>> stList(){
		// TODO Auto-generated method stub
		return workMapper.stList();
	}

	//개별현장
	@Override
	public  List<Map<String, Object>> stName(String loginId) {
		
		return workMapper.stName(loginId);
	}
	//전체업체
	@Override
	public List<Map<String, Object>>  cpList() {
		// TODO Auto-generated method stub
		return workMapper.cpList();
	}
	//개별업체
	@Override
	public List<Map<String, Object>> cpName(String loginId) {
		
		return workMapper.cpName(loginId);
	}

	 
}
