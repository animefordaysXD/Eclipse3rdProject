<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- link  -->
<link href="resources/css/homepage.css" rel="stylesheet">
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-solid-rounded/css/uicons-solid-rounded.css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	crossorigin="anonymous">
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-straight/css/uicons-regular-straight.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-straight/css/uicons-regular-straight.css'>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-thin-straight/css/uicons-thin-straight.css'>

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="resources/homepage/css/homepage.css" rel="stylesheet">
<!--  -->
<link href="resources/view_origin/css/view_origin.css" rel="stylesheet">
<link href="resources/attribute_list/css/attribute_table.css"
	rel="stylesheet">
<link href="resources/attribute_list/css/radio_buttons.css"
	rel="stylesheet">
<link href="resources/attribute_list/css/searchbox.css" rel="stylesheet">
<link href="resources/attribute_list/css/table_buttons.css"
	rel="stylesheet">
<title>관리자 관리 리스트</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<script type="text/javascript">
	function adminlist_super_delete(admin_idx) {
		if (confirm("해당 관리자 정보를 정말 삭제하시겠습니까?")) {
			location.href = "adminlist_super_delete.do?admin_idx="+admin_idx;
			alert("관리자가 삭제되었습니다.");
		} else {
			return;
		}
	}
	
	function enterKey(e){
		if(e.keyCode == 13){
			var radio = $("input[type=radio][name=radio]:checked").val();
		   	const search = document.getElementById('search').value;
		    location.href = "adminlist_super_search.do?search="+search+"&radio="+radio;
		}
	}
</script>
</head>
<body>
	<div id="wrap">
		<!-- 헤더 네비 -->
		<header>
			<h3 style="text-align: center;">room making</h3>
		</header>
		<nav>
			<input type="checkbox" class="openSidebarMenu" id="openSidebarMenu">
			<label for="openSidebarMenu" class="sidebarIconToggle">
				<div class="spinner diagonal part-1"></div>
				<div class="spinner horizontal"></div>
				<div class="spinner diagonal part-2"></div>
			</label>
			<div id="sidebarMenu">
				<ul class="sidebarMenuInner">
					<li style="font-size: 15px;"><a href="userlist_super.do"><i>&emsp;사용자관리<br>&emsp;리스트
						</i></a></li>
					<li style="font-size: 15px;"><a href="usercreate_super.do"><i>&emsp;사용자생성</i></a></li>
					<li style="font-size: 15px;"><a href="adminlist_super.do"><i>&emsp;관리자관리<br>&emsp;리스트
						</i></a></li>
					<li style="font-size: 15px;"><a href="admincreate_super.do"><i>&emsp;관리자생성</i></a></li>
					<li style="font-size: 15px;"><a href="admin_login.do"><i>&emsp;로그아웃</i></a></li>
				</ul>
			</div>
			<div class="option">
				<div class="dropdown">
					<button onclick="dp_menu()" class="button">
						<i class="fi fi-rr-user" style="font-size: 20px;"></i>
					</button>
					<spacer></spacer>
					<div style="display: none;" id="drop-content">
						<div class="profile"></div>
						<div class="notification-container">
							<input class="checkbox1" type="checkbox" id="size_1"
								value="small" checked /> <label class="notification new1"
								for="size_1"><a href="admin_login.do"
								style="color: white;">로그아웃</a></label>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<ul class="breadcrumb">
					<li class="br"><a href="#">&emsp;&emsp;홈</a></li>
					<li class="br"><a href="#">로그인</a></li>
					<li class="br"><a href="#">메뉴</a></li>
					<li class="br active">현재페이지</li>
				</ul>
			</div>
		</nav>
		<script>
			function dp_menu() {
				let click = document.getElementById("drop-content");
				if (click.style.display === "none") {
					click.style.display = "block";
					return false
				} else {
					click.style.display = "none";
				}
			}
		</script>
		<section>
			<div id="container_list">
				<div id="wrapper_list">
					<div id="wrapper_list_inner">
						<a href="adminlist_super.do" style="text-decoration: none;"><h2
								id="headline">관리자 관리 리스트</h2></a>
						<div id="container_radio">
							<form id="container_radio_form">
								<label class="radio_label"> <input type="radio"
									name="radio" value="select_all" onclick="radio_select(event)"
									checked /> <span>전체검색</span>
								</label><label class="radio_label"> <input type="radio"
									name="radio" value="select_admin_idx"
									onclick="radio_select(event)" /> <span>관리자번호</span>
								</label> <label class="radio_label"> <input type="radio"
									name="radio" value="select_admin_id"
									onclick="radio_select(event)" /> <span>ID</span>
								</label> <label class="radio_label"> <input type="radio"
									name="radio" value="select_admin_nickname"
									onclick="radio_select(event)" /> <span>닉네임</span>
								</label>
							</form>
						</div>
						<div id="container_searchbox">
							<div class="searchbox">
								<input type="text" class="searchtxt" id="search"
									placeholder="검색시 엔터키를 눌러주세요" style="font-size: 12px;"
									onkeypress="return enterKey(event);"> <a
									class="searchbtn" href="#"> <i class="fas fa-search"></i>
								</a>
							</div>
						</div>
						<table class="list_table">
							<colgroup>
								<col width="100px" />
								<col width="346px" />
								<col width="346px" />
								<col width="348px" />
							</colgroup>

							<tbody>
								<tr>
									<th>관리자번호</th>
									<th>ID</th>
									<th>닉네임</th>
									<th>관리자탈퇴&정보삭제</th>
								</tr>
								<c:choose>
									<c:when test="${empty adminlist_super}">
										<tr>
											<td colspan="4"><h2>자료가 존재하지 않습니다.</h2></td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="k" items="${adminlist_super}" varStatus="vs">
											<tr class="KOTRA-fontsize-80">
												<td>${k.admin_idx}</td>
												<td>${k.admin_id}</td>
												<td>${k.admin_nickname}</td>
												<td><a class="gradient-btn"
													onclick="adminlist_super_delete(${k.admin_idx})">탈퇴&정보삭제</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>

							<!-- 페이징기법 -->
							<tfoot>
								<tr>
									<td colspan="4">
										<ol class="paging">
											<!-- 이전 -->
											<c:choose>
												<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
													<li class="disable">이전으로</li>
												</c:when>
												<c:otherwise>
													<li><a
														href="adminlist_super.do?cPage=${paging.beginBlock - paging.pagePerBlock}">이전으로</a></li>
												</c:otherwise>
											</c:choose>
											<!-- 블록안에 들어간 페이지번호들 -->
											<c:forEach begin="${paging.beginBlock}"
												end="${paging.endBlock}" step="1" var="k">
												<!-- 현재 페이지와 아닌 페이지 구분 -->
												<c:choose>
													<c:when test="${k == paging.nowPage}">
														<!-- 현재페이지는 색깔만  -->
														<li class="now">${k}</li>
													</c:when>
													<c:otherwise>
														<!-- 다른 페이지는 링크까지 -->
														<li><a href="adminlist_super.do?cPage=${k}">${k}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<!-- 다음 -->
											<c:choose>
												<c:when test="${paging.endBlock >= paging.totalPage}">
													<li class="disable">다음으로</li>
												</c:when>
												<c:otherwise>
													<li><a
														href="adminlist_super.do?cPage=${paging.beginBlock + paging.pagePerBlock}">다음으로</a></li>
												</c:otherwise>
											</c:choose>
										</ol>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
			<!-- </form> -->
		</section>
		<!-- footer 추가  -->
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="footer-col">
						<div class="social-links" style="text-indent: 95px;">
							<p>친절한 고객센터 1688-4757
							<p>월요일-금요일10:00-17:00</p>
							<p>[주말/공휴일휴무]고객상담을 위한 연락처로 마케팅 제안은 정중히 사양합니다</p>
						</div>
					</div>
					<div class="footer-col1">
						<h2 style="margin-top: 22px">Social Media</h2>
						<ul class="social-icons" style="margin-top: -3px;">
							<li><a
								href="https://www.facebook.com/profile.php?id=100091363184815"
								class="social-square"><i class="fab  fa-facebook-f fa-1x"></i></a></li>
							<li><a
								href="https://www.youtube.com/channel/UCd_IGM4iCm0IUjsozb_xO8w"
								class="social-square"><i class="fab  fa-youtube fa"></i></a></li>
							<li><a href="https://www.instagram.com/neulddyaeng.o/"
								class="social-square"><i class="fab  fa-instagram fa"></i></a></li>
							<li><a href="https://blog.naver.com/tjdwosk3"
								class="social-square"><i class="fa-brands fa-line fa"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>