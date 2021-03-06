package com.playground.pg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.service.AdArtService;
import com.playground.pg.service.ListService;

@Controller
@RequestMapping("/exhibit")
public class ListController {
	@Autowired
	AdArtService adArtService;
	@Autowired
	ListService listService;

	// 전시 상세페이지
	@GetMapping("/listView")
	public String showEx(int exNo, Model m) throws Exception {
		// 작품제목(exName) 매개변수로 받음
		// 전시제목, 전시 기간, 관람 시간, 가격, 할인 정보, 전시 문의 번호(임시)
		// 가져올 정보
		// 1. artDTO - 전시회 정보 가져옴
		// 2. artTimeDTO - 전시회 시간 정보 가져옴
		// 3. reviewDto - 리뷰 관련 정보 가져옴 -> list로 변경해야함
		// 4. 총 평균 평점 가져옴

		Map<String, Object> map = listService.showPage(exNo);

		m.addAttribute("artDto", map.get("ArtDto"));
		m.addAttribute("artTimeDto", map.get("ArtTimeDto"));
		m.addAttribute("reviewDto", map.get("ReviewList"));
		m.addAttribute("aveScore", map.get("aveScore"));

		return "exPage";
	}

	// 전시 리스트페이지
	@GetMapping("/list")
	public String showExList(String exState, Model m) throws Exception {
		// 작품제목(exName) 매개변수로 받음
		// 전시상태(exState) 에서 B(before 지난), N(now 현재), A(after 예정)로
		// 전시상태별로 분류할 수 있는 값을 받아옴
		// 전시상태별로 분류 하기 위한 값을 받음
		String view_N = "";
		String view_B = "";
		String view_A = "";
		if (exState.equals("N")) {
			view_N = "view";
		} else if (exState.equals("B")) {
			view_B = "view";
		} else if (exState.equals("A")) {
			view_A = "view";
		}
		m.addAttribute("view_N", view_N);
		m.addAttribute("view_B", view_B);
		m.addAttribute("view_A", view_A);

		Map<String, Object> beforeMap = adArtService.selectArtList("B");
		List<ArtDto> artList_B = (List<ArtDto>) beforeMap.get("artList");
		List<ArtDto> artTimeList_B = (List<ArtDto>) beforeMap.get("artTimeList");

		Map<String, Object> nowMap = adArtService.selectArtList("N");
		List<ArtDto> artList_N = (List<ArtDto>) nowMap.get("artList");
		List<ArtDto> artTimeList_N = (List<ArtDto>) nowMap.get("artTimeList");

		Map<String, Object> afterMap = adArtService.selectArtList("A");
		List<ArtDto> artList_A = (List<ArtDto>) afterMap.get("artList");
		List<ArtDto> artTimeList_A = (List<ArtDto>) afterMap.get("artTimeList");

		m.addAttribute("artList_B", artList_B);
		m.addAttribute("artTimeList_B", artTimeList_B);
		m.addAttribute("artList_N", artList_N);
		m.addAttribute("artTimeList_N", artTimeList_N);
		m.addAttribute("artList_A", artList_A);
		m.addAttribute("artTimeList_A", artTimeList_A);
		return "exList";
	}

	// 찜하기 클릭 - ajax
	@PostMapping("/wishList")
	@ResponseBody
	public ResponseEntity<String> idCheck(@RequestBody ArtDto aDto, HttpSession session) {
		try {
			String id = (String)session.getAttribute("uId_Session");
			int res = listService.isWishList(id, aDto.getExNo());
			
			// RES = 0이라면 찜하기에 추가 , 1이라면 삭제
			String result = (res == 0) ? "I" : "D";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("E", HttpStatus.BAD_REQUEST);
		}
	}

}
