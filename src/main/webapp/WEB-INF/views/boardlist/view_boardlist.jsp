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
<link href="resources/boardlist_write/css/boardlist_write.css"
	rel="stylesheet">
<link href="resources/view_boardlist/css/view_boardlist.css"
	rel="stylesheet">
<title>게시글보기</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<script type="text/javascript">
	function list_go(f) {
		f.action = "boardlist.do";
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
			<section id="section_view_boardlist">
				<div id="container_list_view_boardlist">
					<div id="wrapper_list_view_boardlist">
						<div id="wrapper_list_inner_view_boardlist">
							<a href="boardlist.do" style="text-decoration: none;"><h2
									id="headline">${boardlist_VO.post_title}</h2></a>
							<div id="top_border"></div>
							<table id="view_boardlist_category">
								<colgroup>
									<col width="98px;" />
									<col width="278px;" />
									<col width="98px;" />
									<col width="278px;" />
									<col width="98px;" />
									<col width="278px;" />
								</colgroup>
								<tbody>
									<tr>
										<td
											style="border-right: 2px solid rgb(233, 233, 233); user-select: none;">작성자</td>
										<td
											style="border-right: 2px solid rgb(233, 233, 233); user-select: none;">${boardlist_VO.u_idx}</td>
										<td
											style="border-right: 2px solid rgb(233, 233, 233); user-select: none;">작성일</td>
										<td
											style="border-right: 2px solid rgb(233, 233, 233); user-select: none;">${boardlist_VO.post_datetime}</td>
										<td
											style="border-right: 2px solid rgb(233, 233, 233); user-select: none;">조회수</td>
										<td style="user-select: none;">${boardlist_VO.post_hit}</td>
									</tr>
								</tbody>
							</table>
							<div id="view_boardlist_content">
								<p>${boardlist_VO.post_content}</p>
							</div>
							<!-- <input type="text" id="view_boardlist_content" value=""
								name="inputValue"> -->

							<div id="bottom_border"></div>
							<input type="text" id="view_boardlist_comment" placeholder="댓글창1">
							<!-- <input type="text" id="view_boardlist_comment" placeholder="댓글창2">
						<input type="text" id="view_boardlist_comment" placeholder="댓글창3">
						<input type="text" id="view_boardlist_comment" placeholder="댓글창4">
						<input type="text" id="view_boardlist_comment" placeholder="댓글창5">
						<input type="text" id="view_boardlist_comment" placeholder="댓글창6"> -->
							<div id="view_boardlist_buttonbox"
								style="width: 1200px; height: 150px; background-color: #F8F8F8; margin: 0 auto;">
								<button class="btn hover1" onclick="list_go(this.form)"
									style="margin-right: 33px; margin-left: 20px; margin-top: 15px;">뒤로</button>
								<button class="btn hover1" style="margin-top: 15px;">댓글작성</button>
							</div>
							<div
								style="width: 100vw; height: 370px; background-color: #F8F8F8;"></div>
							<div id="footer_view_boardlist"></div>
						</div>
					</div>
				</div>
			</section>
			<!-- footer 추가  -->

		</div>
	</form>
</body>
</html>