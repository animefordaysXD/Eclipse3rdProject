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
<link href="resources/boardlist_write/css/boardlist_write.css"
	rel="stylesheet">
<link href="resources/attribute_list/css/table_buttons.css"
	rel="stylesheet">
<link href="resources/attribute_list/css/attribute_table.css"
	rel="stylesheet">
<title>게시글작성</title>
<script type="text/javascript">
	function list_go(f) {
		f.action = "boardlist.do";
		f.submit();
	}

	function list_write(f) {
		alert("등록버튼");

		f.action = "boardlist_write_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<div id="wrap">
			<header>
				<h3 style="text-align: center;">today Time's</h3>
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
						<li style="font-size: 15px;"><a href="boardlist_member.do"><i>&emsp;회원관리리스트</i></a></li>
						<li style="font-size: 15px;"><a href="boardlist_room.do"><i>&emsp;방관리리스트</i></a></li>
						<li style="font-size: 15px;"><a href="boardlist_report.do"><i>&emsp;신고내역<br>&emsp;관리리스트
							</i></a></li>
						<li style="font-size: 15px;"><a href="boardlist_outmember.do"><i>&emsp;탈퇴회원<br>&emsp;관리리스트
							</i></a></li>
						<li style="font-size: 15px;"><a href="boardlist.do"><i>&emsp;공지사항</i></a></li>
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
							<a href="boardlist.do" style="text-decoration: none;"><h2
									id="headline">게시글작성</h2></a>
							<div id="top_border"></div>
							<input type="text" id="boardlist_write_title" name="post_title"
								placeholder="제목을 입력해 주세요.">
							<textarea id="boardlist_write_content" name="post_content"
								placeholder="내용을 입력해 주세요."></textarea>
							<button class="btn hover1" onclick="list_go(this.form)"
								style="margin-right: 33px; margin-left: 20px; margin-top: 15px;">취소</button>
							<button class="btn hover1" style="margin-top: 15px;"
								onclick="list_write(this.form)">등록</button>
							<%-- <input type="hidden" name="u_idx" value="${u_idx}"> --%>

						</div>
					</div>
				</div>
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
	</form>
</body>
</html>