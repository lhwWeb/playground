package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.CouponDto;

public interface MyPageCouponService {
	// 해당 아이디가 가지고 있는 총 쿠폰 보여주기
	public int getAllCouponById(String id) throws Exception;
	
	// 전체 쿠폰 리스트
	public List<CouponDto> getCouponList(String id) throws Exception;

	//state U : 사용 가능, state : N 이미 사용된
	// 사용가능한 쿠폰 리스트
	public List<CouponDto> getPoCouponList(String id) throws Exception;
	
	// 사용완료한 쿠폰 리스트
	public List<CouponDto> getImpoCouponList(String id) throws Exception;
	
	// 테스트용 쿠폰 상태 변경
	public int updStateTest(String id) throws Exception;
}
