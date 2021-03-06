package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.CouponDto;

@Repository
public class MyPageCouponDaoImpl implements MyPageCouponDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.MyCouponMapper.";
	
	
	@Override
	public int getAllCouponById(String id) throws Exception {
		Integer result = session.selectOne(namespace+"selectAllCoupon", id);
		return result == null ? 0 : result;
	}

	@Override
	public List<CouponDto> getCouponList(String id) throws Exception {
		return session.selectList(namespace+"selectCouponList", id);
	}

	@Override
	public List<CouponDto> getPoCouponList(String id) throws Exception {		
		return session.selectList(namespace + "selectPoCouponList", id);
	}
	
	@Override
	public List<CouponDto> getimpoCouponList(String id) throws Exception {
		return session.selectList(namespace + "selectImpoCouponList", id);
	}

	@Override
	public int updStateTest(String id) throws Exception {
		return session.update(namespace + "updStateTest", id);
	}		

	
	
}