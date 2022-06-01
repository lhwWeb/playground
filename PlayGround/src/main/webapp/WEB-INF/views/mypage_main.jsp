<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="loginId" value="${sessionScope.id}" />
<c:set var="urlInfo" value="/resources/" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mypage</title>

<!-- font awesome -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="${urlInfo}css/default.css">
<link rel="stylesheet" href="${urlInfo}css/mypage.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/script.js"></script>

</head>

<body>
	<div id="wrap">
		<header>
			<div class="center">
				<!-- <div class="header_fix"> -->
				<!-- <div class="logo"> -->
				<a href="#" class="logo"> <span>PLAY</span> <span>GROUND</span>
				</a>
				<!-- <a href="#"><img src="image/logo.png" alt="logo"></a> -->
				<!-- </div> -->
				<nav class="gnb">
					<ul class="main_menu">
						<li class="main_list"><a href="#">PLAY GROUND</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">현재 전시</a></li>
								<li class="sub_list"><a href="#">지난 전시</a></li>
								<li class="sub_list"><a href="#">예정 전시</a></li>
							</ul></li>
						<li class="main_list"><a href="#">STORE</a> <!-- <ul class="sub_menu">
                <li class="sub_list"><a href="#"></a></li>
              </ul> --></li>
						<li class="main_list"><a href="#">BOARD</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">공지사항</a></li>
								<li class="sub_list"><a href="#">FAQ</a></li>
								<li class="sub_list"><a href="#">1:1문의</a></li>
							</ul></li>
					</ul>
				</nav>
				<div class="top_header">
						<ul>
							<c:choose>
								<c:when test="${loginId eq null}">
									<a href="#" style="margin-right:20px;"><li>회원가입</li></a>
									<a href="#"><li>LOGIN</li></a>
								</c:when>
								<c:otherwise>
									<a href="#" style="margin-right:20px;"><li>LOGOUT</li></a>
							<a href="/myPage/myPageHome"><li>MY PAGE</li></a>
								</c:otherwise>
							</c:choose>
						</ul>
				</div>
			</div>
			<!-- </div> -->
		</header>
		<!-- 탑버튼 시작 -->
		<div class="center">
			<div id="top_button">
				<a href="#"> <i class="material-icons" style="font-size: 30px">vertical_align_top</i>
				</a>
			</div>
		</div>
		<!-- 탑버튼 끝 -->
		<div class="containts">
			<div class="center myp">
				<div class="menu_bar">
					<ul class="main_meun">
						<a href="MY PAGE">MY PAGE</a>
					</ul>
					<ul class="main_list myt">
						<a class="main_title" href="mypage2.html">MY TICKETS</a>
						<li class="sub_list"><a href="mypage2.html">티켓예매목록</a></li>
					</ul>
					<ul class="main_list">
						<a class="main_title" href="">MY INFO</a>
						<li class="sub_list"><a href="mypage4.html">나의 쿠폰</a></li>
						<li class="sub_list"><a href="mypage8.html">적립금</a></li>
						<li class="sub_list"><a href="my_review.html">나의 리뷰</a></li>
						<li class="sub_list"><a href="mypage5.html">개인정보변경/탈퇴</a></li>
					</ul>
				</div>
				<div class="contents">
					<section class="myp_info">
						<article class="left_menu">
							<h2>
								${name}님의<br>마이페이지 입니다.
							</h2>
							<a class="button" href="mypage5.html">개인정보수정</a>
						</article>
						<article class="right_menu">
							<div class="r_cop">
								<a href="mypage4.html">쿠폰</a>
								<p>${couponCnt}장</p>
							</div>
							<div class="r_coin">
								<a href="mypage8.html">적립금</a>
								<p>${myPoint}원</p>
							</div>
						</article>
					</section>
					<section class="myp_view">
						<article class="article1">
							<a class="article1_next" href="#"> <strong>최근 예매 내역</strong>
							</a>
							<p class="line">${name}님의지난3개월간의티켓예매내역입니다.</p>
							<c:choose>
								<c:when test="${reserveList.size() eq 0}">
									<div class="view review">
										<p>조회내역이 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<!-- 반복 구역 시작 -->
									<c:forEach var="ReserveDto" items="${reserveList}" varStatus="status">
										<h2 class="t_sub">
											예매완료<span>${ReserveDto.reDate}***</span>
										</h2>
										<div class="view tic">
											<a href="mypage2.html"><img
												src="${urlInfo}image/${artList[status.index].thumbImg}" alt="view"></a>
											<div class="view_in">
												<a class="view_in_title" href="mypage2.html">${artList[status.index].exName}</a>
												<p>PlayGround - ${artList[status.index].location}</p>
												<p>
													${ReserveDto.reDate}<span>${ReserveDto.adCnt + ReserveDto.chCnt}매</span>
												</p>
											</div>
										</div>
									</c:forEach>
									<!-- 반복 구역 끝 -->
								</c:otherwise>
							</c:choose>


						</article>
						<article class="article1 review">
							<a class="article1_next" href="my_review.html"> <strong>최근
									작성 리뷰 </strong>
							</a>
							<p class="line">${name}님의 지난 3개월간의 작성 리뷰 입니다</p>
							<c:choose>
								<c:when test="${reviewList.size() eq 0}">
									<div class="view review">
										<p>조회내역이 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach var="ReviewDto" items="${reviewList}">
										<div>
											<p>${ReviewDto.writeDate}</p>
											<p>${ReviewDto.title}</p>
											<hr>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</article>
					</section>
				</div>
			</div>
		</div>
		<footer class="footer">
			<div class="center">
				<span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span> <span
					class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights
					reserved.</span>
			</div>
		</footer>
	</div>
</body>

</html>