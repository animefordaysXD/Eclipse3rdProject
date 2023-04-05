<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/room/css/room.css" rel="stylesheet">
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
<script>
function kakaopost() {
    new daum.Postcode({
        oncomplete: function(data) {
           document.querySelector("#zipcode").value = data.zonecode;
           document.querySelector("#address").value =  data.address
        }
    }).open();
}

</script>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {
    //document.getElementById("showCity").textContent="구를 선택해주세요";
    const buttons = document.querySelectorAll(".location");
	
buttons.forEach((button) => {
  button.addEventListener("click", setLoc);
});
});


	
function setVisibility() {
	  var x = document.getElementById("divOne");
	  if (x.style.display === "none") {
	    x.style.display = "flex";
	  } else {
	    x.style.display = "none";
	  }
	}

function getCategoryClimb(button){
    var pressed= button.getAttribute("data-value2");
    if (pressed == "false"){
        pressed = "true";
    }else if(pressed == "true"){
        pressed = "false";
    }
    button.setAttribute("data-value2", pressed); 
}
function showCity(){
    var y = document.getElementById("locations");
    if (y.style.display === "grid") {
    y.style.display = "none";
  } else {
    y.style.display = "grid";  
  }
}


function setLoc(event) {
var city = event.target.value +"구";
document.getElementById("showCity").textContent=city;
document.getElementById("showCity");

}

$(function() {
	$("#terms").scroll(function() {
		document.getElementById('regCheck').removeAttribute("disabled");
	});
});

function checkNick(){
	
}
</script>
<script type="text/javascript"
	src="http://localhost:8090/7bce3e0f77d704cc7d39e3517a61db1f%libraries=services,clusterer">

</script>

</head>
<body style="overflow-x: hidden">
	<div id="wrap">
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
					<li><a href="#"><i class="fi fi-sr-home">&emsp;&emsp;홈</i></a></li>
					<li><a href="#"><i class="fi fi-rr-user">&emsp;로그인</i></a></li>
					<li><a href="#"><i class="fi fi-rr-basketball">&emsp;농구</i></a></li>
					<li><a href="#"><i class="fi fi-rr-baby">&ensp;클라이밍</i></a></li>
					<li><a href="#"><i class="fi fi-rs-bowling">&emsp;볼링</i></a></li>
					<li><a href="#"><i class="fi fi-ts-racquet">&ensp;배드민턴</i></a></li>
					<li><a href="#"><i class="fi fi-rs-house-flood">&ensp;방만들기</i></a></li>
					<li><a href="#"><i class="fi fi-rr-thumbtack">&ensp;신고하기</i></a></li>
					<li><a href="#"><i class="fi fi-rr-comment-sms">&ensp;게시판</i></a></li>
				</ul>
			</div>


			<div class="option">
				<div class="dropdown1">
					<button onclick="dp_menu1()" class="button1">
						<i class="material-icons dp48">notifications</i>
					</button>

					<spacer></spacer>
					<span class="num-count">2</span>
					<div style="display: none;" id="drop-content1">
						<div class="notification-icon right"></div>

						<div class="profile1"></div>

						<div style="float: right;">
							<div class="notification-container1">
								<input class="checkbox" type="checkbox" id="size_1"
									value="small" checked /> <label class="notification new"
									for="size_1"><em>1</em> new <a href="">guest
										account(s)</a> have been created.<i
									class="material-icons dp48 right">clear</i></label> <input
									class="checkbox" type="checkbox" id="size_2" value="small"
									checked /> <label class="notification new" for="size_2"><em>2</em>
									new <a href="">lead(s)</a> are available in the system.<i
									class="material-icons dp48 right">clear</i></label> <input
									class="checkbox" type="checkbox" id="size_4" value="small"
									checked /> <label class="notification" for="size_4"><em>3</em>
									new <a href="">calendar event(s)</a> are scheduled for today.<i
									class="material-icons dp48 right">clear</i></label> <input
									class="checkbox" type="checkbox" id="size_5" value="small"
									checked /> <label class="notification" for="size_5"><em>4</em>
									blog post <a href="">comment(s)</a> need approval.<i
									class="material-icons dp48 right">clear</i></label>

							</div>
						</div>

					</div>
				</div>

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
								for="size_1"><a href="" style="color: white;">마이페이지</a></label>
							<input class="checkbox1" type="checkbox" id="size_1"
								value="small" checked /> <label class="notification new1"
								for="size_1"><a href="" style="color: white;">신청내역</a></label> <input
								class="checkbox1" type="checkbox" id="size_1" value="small"
								checked /> <label class="notification new1" for="size_1"><a
								href="" style="color: white;">개설방내역</a></label> <input class="checkbox1"
								type="checkbox" id="size_1" value="small" checked /> <label
								class="notification new1" for="size_1"><a href=""
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
    

        function dp_menu(){
            let click = document.getElementById("drop-content");
            if(click.style.display === "none"){
                click.style.display = "block";
 
            }else{
                click.style.display = "none";
 
            }
        }
        function dp_menu1(){
            let click = document.getElementById("drop-content1");
            if(click.style.display === "none"){
                click.style.display = "block";
 
            }else{
                click.style.display = "none";
 
            }
        }
    </script>

		<section>
			<div id="container_list">
				<div id="wrapper_list">
					<div id="wrapper_list_inner">
						<h2 id="headline">개설방 내역</h2>
						<br> <br>
						<table class="list_table">
							<colgroup>
								<col width="200px" />
								<col width="200px" />
								<col width="350px" />
								<col width="400px" />
							</colgroup>
							<thead>
								<tr>
									<th>개설일시</th>
									<th>카테고리</th>
									<th>참여방</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty list }">
										<tr>
											<td colspan="5"><h2>원하는 정보가 존재하지 않습니다.</h2></td>
									</c:when>
									<c:otherwise>
										<c:forEach items="${list}" var="k" varStatus="vs">
											<tr>
												<!-- 일자  -->
												<td>${k.write_datetime}</td>
												<!-- 카테고리 타입  -->
												<td>${k.category_type}</td>
												<!-- 방 제목   -->
												<td>${k.room_title }</td>
												<!-- 마감 여부  -->
												<td>{% if k.close_ok == 1 %}
													<button type="button" class="seoul">활동종료</button> {% else
													if k.close_ok == 2 %}
													<button type="button" class="seoul2">모집종료</button> {% else
													if k.close_ok == 3 %}
													<button type="button" class="seoul1">모집중</button>
												</td> 

											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		


		</section>
	</div>

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
					<h2 style="margin-top: 22px;">&emsp;Social Media</h2>
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


</body>
</html>