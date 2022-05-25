package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.InquiryDto;

@Repository
public class InquiryDaoImpl implements InquiryDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.InquiryMapper.";
	
	@Override
	public int insertInq(InquiryDto inquiryDto) throws Exception {
		return session.insert(namespace + "insertInq", inquiryDto);
	}

	@Override
	public List<InquiryDto> getInqList(String uId) throws Exception {
		return session.selectList(namespace + "getInqList" ,uId);
	}

	@Override
	public InquiryDto getInq(int no) throws Exception {
		return session.selectOne(namespace + "getInq", no);
	}
	
	@Override
	public int getInqCnt() throws Exception {
		return session.selectOne(namespace + "selectInqCnt");
	}

	@Override
	public int deleteInq(int no) throws Exception {
		return session.delete(namespace + "deleteInq", no);
	}

	@Override
	public List<InquiryDto> getAdminInqList() throws Exception {
		return session.selectList(namespace + "getAdminInqList");
	}

	@Override
	public int updateReply(int no, String text) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("no", no);
		map.put("text", text);
		return session.update(namespace + "updateReply", map);
	}

}