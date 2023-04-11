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
<link href="resources/attribute_list/css/table_buttons.css"
	rel="stylesheet">
<title>관리자 생성</title>
<script type="text/javascript">
	function get_IdCheck() {
		var admin_id = $('#admin_id').val();
		$.ajax({
			url : "admin_IdCheck.do",
			type : "post",
			data : {
				admin_id : admin_id
			},
			dataType : 'text',
			success : function(result) {
				if (result === "1") {
					$("#id_feedback").html('이미 사용중인 아이디입니다.');
					$("#id_feedback").attr('color', '#dc3545');
				} else {
					$("#id_feedback").html('사용할 수 있는 아이디입니다.');
					$("#id_feedback").attr('color', '#2fd380');
				}
			},
			error : function() {
				alert("서버요청실패");
			}
		});
	};

	function get_NicknameCheck() {
		var admin_nickname = $('#admin_nickname').val();
		$.ajax({
			url : "admin_NicknameCheck.do",
			type : "post",
			data : {
				admin_nickname : admin_nickname
			},
			dataType : 'text',
			success : function(result) {
				if (result === "1") {
					$("#nickname_feedback").html('이미 사용중인 닉네임입니다.');
					$("#nickname_feedback").attr('color', '#dc3545');
				} else {
					$("#nickname_feedback").html('사용할 수 있는 닉네임입니다.');
					$("#nickname_feedback").attr('color', '#2fd380');
				}
			},
			error : function() {
				alert("서버요청실패");
			}
		});
	};

	function admincreate_super_exit(f) {
		f.action = "adminlist_super.do"
	}

	function admincreate_super_ok(f) {
		if (f.admin_id.value.trim().length <= 0) {
			alert("관리자 아이디를 입력하세요.");
			f.admin_id.focus();
			return;
		}

		if (f.admin_nickname.value.trim().length <= 0) {
			alert("관리자 닉네임을 입력하세요.")
			f.admin_nickname.focus();
			return;
		}

		if (confirm("관리자를 생성하시겠습니까?")) {
			f.action = "admincreate_super_ok.do"
			alert("관리자가 생성되었습니다.");
		} else {
			return;
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
			<form method="post" style="margin: 0 auto;">
				<div id="container_list">
					<div id="wrapper_list">
						<div id="wrapper_list_inner">
							<h2 id="headline">관리자 생성</h2>
							<table class="list_table" style="margin-top: 50px;">
								<colgroup>
									<col width="240px" />
									<col width="450px" />
									<col width="450px" />
								</colgroup>
								<tbody>
									<tr>
										<th>관리자번호</th>
										<th>ID</th>
										<th>닉네임</th>
									</tr>
									<tr class="KOTRA-fontsize-80">
										<td>자동부여</td>
										<td><input type="text" name="admin_id" id="admin_id"
											onblur="get_IdCheck();" style="width: 300px; height: 20px">
											<div>
												<font id="id_feedback" size="2"></font>
											</div></td>
										<td><input type="text" name="admin_nickname"
											id="admin_nickname" onblur="get_NicknameCheck();"
											style="width: 300px; height: 20px">
											<div>
												<font id="nickname_feedback" size="2"></font>
											</div></td>
									</tr>
								</tbody>
							</table>
							<button class="btn hover1"
								onclick="admincreate_super_exit(this.form)"
								style="margin-right: 33px; margin-left: 20px; margin-top: 15px;">취소</button>
							<button class="btn hover1"
								onclick="admincreate_super_ok(this.form)"
								style="margin-top: 15px;">관리자생성</button>
						</div>
					</div>
				</div>
			</form>
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