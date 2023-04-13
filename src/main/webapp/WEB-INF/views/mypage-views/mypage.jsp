<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.5/gsap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link href="resources/view_origin/css/view_origin.css" rel="stylesheet">
<link href="resources/attribute_list/css/attribute_table.css"
	rel="stylesheet">
<link href="resources/attribute_list/css/table_buttons.css"
	rel="stylesheet">
<link href="resources/mypage/css/mypage.css" rel="stylesheet" />
<link href="resources/mypage/css/font.css" rel="stylesheet">
<link href="resources/mypage/css/photo.css" rel="stylesheet" />
<link href="resources/mypage/css/progressbar.css" rel="stylesheet">
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
	<link href="resources/homepage/css/homepage.css" rel="stylesheet">
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-solid-rounded/css/uicons-solid-rounded.css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	crossorigin="anonymous">
<title>내프로필</title>
</head>
<style type="text/css">
#wateringButton:hover {
	cursor: pointer;
}

#wateringButton:hover i {
	cursor: pointer;
	animation: moveArrow 0.5s linear !important;
}

@
keyframes moveArrow { 0% {
	transform: translateX(0);
	opacity: 1;
}

100
%
{
transform
:
translateX(
100%
);
opacity
:
0;
}
}
.badges {
	width: 100px;
	height: 98px;
}

.badges:hover {
	cursor: pointer;
}

.starIcon1 {
	position: absolute !important;
	top: 612px;
	left: 239px;
	width: 20px;
	height: 20px;
	color: yellow;
}

.starIcon2 {
	position: absolute !important;
	top: 630px;
	left: 127px;
	width: 20px;
	height: 20px;
	color: yellow;
}

.starIcon3 {
	position: absolute !important;
	top: 695px;
	left: 200px;
	width: 20px;
	height: 20px;
	color: yellow;
}

.faucet-shake {
	animation: shake 0.5s cubic-bezier(.36, .07, .19, .97) both;
}

@
keyframes shake { 10%, 90% {
	transform: translate3d(-1px, 0, 0);
}

20
%
,
80
%
{
transform
:
translate3d(
2px
,
0
,
0
);
}
30
%
,
50
%
,
70
%
{
transform
:
translate3d(
-4px
,
0
,
0
);
}
40
%
,
60
%
{
transform
:
translate3d(
4px
,
0
,
0
);
}
}

/* Droplet animations */
.droplet {
	display: none;
	opacity: 0;
	position: absolute;
}

.droplet-animate {
	position: absolute;
	display: inline-block;
	top: 550px;
	left: 220px;
	animation: fall 1s linear forwards;
}

@
keyframes fall { 0% {
	opacity: 1;
	transform: translateY(0);
}

100
%
{
opacity
:
0;
transform
:
translateY(
100px
);
}
}
.hiddenBadges {
	display: inline-block;
	width: 150px;
	height: 150px;
	margin-right: 10px;
	border: 1px solid black;
	cursor: pointer;
}

.imageGrid {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 10px;
}

#close-popup {
	width: 300px;
	height: 40px;
	background-color: rgba(20, 217, 190, 0.5);
	color: rgba(252, 23, 27, 1);
	margin-left: 245px;
	margin-top: 244px;
}

#close-popup:hover {
	cursor: pointer;
	background-color: rgba(15, 138, 121, 0.3);
}

div[data-badge="1"] {
	background: url(resources/mypage/images/1.png) no-repeat;
	background-size: cover;
}

div[data-badge="2"] {
	background: url(resources/mypage/images/2.png) no-repeat;
	background-size: cover;
}

div[data-badge="3"] {
	background: url(resources/mypage/images/3.png) no-repeat;
	background-size: cover;
}

div[data-badge="4"] {
	background: url(resources/mypage/images/4.png) no-repeat;
	background-size: cover;
}

div[data-badge="5"] {
	background: url(resources/mypage/images/5.png) no-repeat;
	background-size: cover;
}

div[data-badge="6"] {
	background: url(resources/mypage/images/6.png) no-repeat;
	background-size: cover;
}

div[data-badge="7"] {
	background: url(resources/mypage/images/7.png) no-repeat;
	background-size: cover;
}

div[data-badge="8"] {
	background: url(resources/mypage/images/8.png) no-repeat;
	background-size: cover;
}

div[data-badge="9"] {
	background: url(resources/mypage/images/9.png) no-repeat;
	background-size: cover;
}

.mypage_information_text.editable {
	/* styles when editable */
	background-color: #F8F8F8;
	border: 1px solid black;
	color: black;
}

#wateringButton {
	width: 300px;
	height: 30px;
	margin: 0 auto;
	background-color: rgba(0, 62, 255, 0.7);
	color: #fff;
	border-radius: 8px;
	border: 1px solid white;
}

#wateringButton:disabled {
	background-color: gray !important;
	color: black !important;
	cursor: default;
}
.location-popup {
  display: none;
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1000;
}

.location-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: black;
  padding: 20px;
  border-radius: 5px;
  text-align: center;
    display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(5, 1fr);
  grid-gap: 10px;
}

.location {
  margin: 5px;
  background-color: rgba(33, 196, 161,0.5);
  color:white;
  height:50px;
  width:75px;
  font-size: 20px;
  border-radius: 10px;
  border: 1px solid blue;
}
.location:hover{
background-color: rgba(33, 196, 161,0.3);
cursor: pointer;
}
</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
	  $(".location").on("click", updateRegion);
	});

function getCities(){
	  document.getElementById("locationPopup").style.display = "grid";


document.getElementById("locationPopup").addEventListener("click", function(e) {
  /* if (e.target.classList.contains("location")) {
    document.querySelector(".mypage_information_text").innerText = e.target.value;
  } */
  this.style.display = "none";
});
}

function updateDatabase(region) {
	  $.ajax({
	    url: 'getCity.do',
	    type: 'POST',
	    data: {
	      hash: localStorage.getItem("hash"),
	      region: region,
	    },
	    success: function (response) {
	      console.log(response);
	      // Handle successful database update response.
	    },
	    error: function (xhr, status, error) {
	      console.log("error: " + error);
	      console.log("xhr: " + JSON.stringify(xhr));
	      console.log("status: " + status);
	    },
	  });
	}
function updateRegion(event) {
	  var selectedRegion = event.target.value;
	 /*  var regionElement = document.querySelector(".mypage_information_text");
	  regionElement.textContent = selectedRegion; */

	  // Call a function to update the database with the new region value.
	  updateDatabase(selectedRegion);
	  location.reload();
	}
</script>
<script>
function changeNick(){
	var nick = document.getElementById("nickNameNew").innerText;
	  $.ajax({
		    url: 'setNick.do',
		    type: 'POST',
		    data: {
		      hash: localStorage.getItem("hash"),
		      nickName: nick,
		    },
		    success: function (response) {
		      console.log(response);
		      // Handle successful database update response.
		    },
		    error: function (xhr, status, error) {
		      console.log("error: " + error);
		      console.log("xhr: " + JSON.stringify(xhr));
		      console.log("status: " + status);
		    },
		  });
}

</script>
<script>

var selected = "";
  
  
  document.addEventListener('DOMContentLoaded', () => {
	  const badgeNumbers = [4, 2, 3]; // Array of badge numbers
	  
	  // Get all badge elements and the popup elements after they have been created
	  const popup = document.getElementById('popup');
	  const popupContent = document.getElementById('popup-content');
	  const closePopupButton = document.getElementById('close-popup');
	  const badges = document.querySelectorAll('.badges');
	  const hiddenBadges = document.querySelectorAll('.hiddenBadges');
	  
	  
	 
	 
	 


		  // Add click event listeners to the hidden badge elements
		  hiddenBadges.forEach(hiddenBadge => {
		    hiddenBadge.addEventListener('click', () => {
		     
		       
		        hidePopup();
		      
		    });
		  });

		  // Add a click event listener to the close button
		  closePopupButton.addEventListener('click', hidePopup);
		  
		  
		  var response = '${vo.profPicString}';
		  var obj = JSON.parse(response);
		  var url = obj.url;
		  document.getElementById("mypicture").src = url;
	});
  function showPopup() {
		 
	    popup.style.display = 'flex';
	    
	  }
  function hidePopup() {
	    popup.style.display = 'none';
	    selected = "";
	  }
  function setLoc1(){
		selected="1";
		showPopup();
	  }
	  function setLoc2(){
			selected="2";
			showPopup();
		  }
	  function setLoc3(){
			selected="3";
			showPopup();
		  }
  
  
  function setBadge(button){
	  var getBadge = button.getAttribute('data-badge');
	 
	  if (selected=="1") {
		  const element = document.querySelector('.badges#badges1');
		  element.dataset.badge = getBadge;
		}
	  if (selected=="2") {
		  const element = document.querySelector('.badges#badges2');
		  element.dataset.badge = getBadge;
		}
	  if (selected=="3") {
		  const element = document.querySelector('.badges#badges3');
		  element.dataset.badge = getBadge;
		}
		  
	  
	  
	  
  }

  function changePicture() {
	  // Create an input element of type "file"
	  var fileInput = document.createElement("input");
	  fileInput.type = "file";
	  
	  // Add an event listener to the file input to detect when a file is selected
	  fileInput.addEventListener("change", function() {
	    // Get the selected file
	    var file = fileInput.files[0];
	    
	    // Create a new FileReader
	    var reader = new FileReader();
	    
	    // Add an event listener to the FileReader to detect when the file is loaded
	    reader.addEventListener("load", function() {
	      // Update the "src" attribute of the image with the data URL of the selected file
	      document.getElementById("mypicture").src = reader.result;
	    });
	    
	    // Read the selected file as a data URL
	    reader.readAsDataURL(file);
	  });
	  
	  // Trigger a click event on the file input to open the file selection dialog
	  fileInput.click();
  
 


	    
	    $(document).ready(function() {
	        $('#mypicture').on('click', function() {
	            $('#image-input').trigger('click');
	        });

	        $('#image-input').on('change', function() {
	        	var oldFile = document.getElementById("mypicture").src;
	            var file = this.files[0]; // Get the selected file
	            var formData = new FormData();
	            var hash = localStorage.getItem("hash");
	            formData.append('profPic', file);
				formData.append('oldFile',oldFile);
	            $.ajax({
	                url: 'uploadFile.do',
	                type: 'POST',
	                enctype: 'multipart/form-data',
	                data: formData,
	                processData: false,
	                contentType: false,
	                dataType: 'json',
	                beforeSend: function(xhr) {
	                    xhr.setRequestHeader('hash', localStorage.getItem("hash"));
	                    formData.append('hash', localStorage.getItem("hash")); // Add the hash parameter to formData
	                },
	                success: function(response) {
	                    console.log('Image uploaded successfully');
	                    if (response.url) {
	                        // Update the image src with the new uploaded image URL
	                        $('#mypicture').attr('src', response.url);
	                    }
	                },
	                error: function(xhr, status, error) {
	                	  console.error('Image upload failed:', error);
	                	    console.log('Status:', status);
	                	    console.log('XHR:', xhr);
	                	    console.log('Response:', xhr.responseText);
	                	    if(xhr.responseText==="PNG only"){
	                	    	alert('지원되지않는 파일 형식입니다.');
	                	    }
	                }
	            });
	        });
	    });

  </script>
<script type="text/javascript">
  function updateProfilePictureUrl(vo) {
	    var response = vo.profPicString;
	    var obj = JSON.parse(response);
	    var url = obj.url;
	    document.getElementById("mypicture").src = url;
	}
  function setCookie(name, value, days) {
	  var expires = "";
	  if (days) {
	    var date = new Date();
	    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	    expires = "; expires=" + date.toUTCString();
	  }
	  document.cookie = name + "=" + (value || "") + expires + "; path=/";
	}
  function getAttendance() {
	  $.ajax({
	    url: 'getAttend.do',
	    type: "POST",  	    
	    data: {
	      hash: localStorage.getItem("hash"),
	    },
	    success: function(response) {
	    	 
	    	console.log(response);
	      if(response.status==="1"){
	        alert('출석 완료!');
	        var attendanceCookieValue = localStorage.getItem("hash") + "|1";
	        setCookie("attendance", attendanceCookieValue, 1);
	        updateProfilePictureUrl(response.vo); 
	        location.reload();
	      }else{
	        alert('출석 실패');
	      }      
	    },
	    error: function(xhr, status, error) {
	      console.log("error: " + error);
	      console.log("xhr: " + JSON.stringify(xhr));
	      console.log("status: " + status);
	    }	    
	  });
	}

	function animateFaucetAndDroplets() {
	  var hash = localStorage.getItem("hash");
	  const faucet = document.getElementById('wateringCan');
	  const droplets = document.querySelectorAll('.droplet');
	  
	  faucet.classList.add('faucet-shake');
	  console.log(hash);
	  droplets.forEach((droplet, index) => {
	    setTimeout(() => {
	      droplet.classList.add('droplet-animate');
	    }, index * 200);
	  });

	  setTimeout(() => {
	    faucet.classList.remove('faucet-shake');
	    droplets.forEach(droplet => droplet.classList.remove('droplet-animate'));
	    getAttendance();
	   
	  }, 1000);   
	}
  
  </script>
<script type="text/javascript">
  function getCookie(name) {
	  var nameEquals = name + "=";
	  var cookies = document.cookie.split(';');
	  for (var i = 0; i < cookies.length; i++) {
	    var cookie = cookies[i];
	    while (cookie.charAt(0) === ' ') {
	      cookie = cookie.substring(1, cookie.length);
	    }
	    if (cookie.indexOf(nameEquals) === 0) {
	      return cookie.substring(nameEquals.length, cookie.length);
	    }
	  }
	  return null;
	}

	function checkAttendanceCookie() {
		
	  var attendanceCookie = getCookie("attendance");
	  if (attendanceCookie !== null) {
	    var [hash, status] = attendanceCookie.split("|");
	    if (hash === localStorage.getItem("hash") && status === "1") {
	      var wateringButton = document.getElementById("wateringButton");
	      wateringButton.disabled = true;	      	 
	    	  wateringButton.innerHTML = "오늘 출석 하셨습니다.";	    		      
	    }
	  }
	}

	// Call the checkAttendanceCookie function when the page loads
	document.addEventListener("DOMContentLoaded", checkAttendanceCookie);
  
  
  </script>
<body>
	<div id="wrap"style="background: black;">
		<header>
			<h3 style="text-align: center;">today Time's</h3>
		</header>
		<!-- navigator 추가  -->
		<nav>
		<input type="checkbox" class="openSidebarMenu" id="openSidebarMenu">
				<label for="openSidebarMenu" class="sidebarIconToggle">
					<div class="spinner diagonal part-1"></div>
					<div class="spinner horizontal"></div>
					<div class="spinner diagonal part-2"></div>
				</label>
				<div id="sidebarMenu">
					<ul class="sidebarMenuInner">
						<li><a href="complete.do?email=dGpkd29zazJAbmF2ZXIuY29t"><i class="fi fi-sr-home">&emsp;&emsp;홈</i></a></li>
						<li><a href="complete.do"><i class="fi fi-rr-user">&ensp;로그아웃</i></a></li>
						<li><a href="#"><i class="fi fi-rr-basketball">&emsp;농구</i></a></li>
						<li><a href="#"><i class="fi fi-rr-baby">&ensp;클라이밍</i></a></li>
						<li><a href="#"><i class="fi fi-rs-bowling">&emsp;볼링</i></a></li>
						<li><a href="#"><i class="fi fi-ts-racquet">&ensp;배드민턴</i></a></li>
						<li><a href="homepage.do"><i class="fi fi-rs-house-flood">&ensp;방만들기</i></a></li>
						<li><a href="view_report.do"><i class="fi fi-rr-thumbtack">&ensp;신고하기</i></a></li>
						<li><a href="boardlist.do"><i class="fi fi-rr-comment-sms">&ensp;게시판</i></a></li>
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
							<div class="notification-icon  right"></div>

							<div class="profile1"></div>

							<div style="float: right;">
							    <div class="notification-container1">
							        <input class="checkbox" type="checkbox" id="size_1" value="small" checked />
							        <label class="notification new" for="size_1"><em>1</em> new <a href=""></a> <i class="material-icons dp48 right">clear</i></label>
							        <input class="checkbox" type="checkbox" id="size_2" value="small" checked />
							        <label class="notification new" for="size_2"><em>2</em> new <a href=""></a> <i class="material-icons dp48 right">clear</i></label>
							        <input class="checkbox" type="checkbox" id="size_4" value="small" checked />
							        <label class="notification" for="size_4"><em>3</em> new <a href=""></a><i class="material-icons dp48 right">clear</i></label>
							        <input class="checkbox" type="checkbox" id="size_5" value="small" checked />
							        <label class="notification" for="size_5"><em>4</em><a href=""></a><i class="material-icons dp48 right">clear</i></label>
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
									for="size_1"><a href="mypage.do" style="color: white;">마이페이지</a></label>
								<input class="checkbox1" type="checkbox" id="size_1"
									value="small" checked /> <label class="notification new1"
									for="size_1"><a href="" style="color: white;">신청내역</a></label>
								<input class="checkbox1" type="checkbox" id="size_1"
									value="small" checked /> <label class="notification new1"
									for="size_1"><a href="roomlist.do" style="color: white;">개설방내역</a></label>
								<input class="checkbox1" type="checkbox" id="size_1"
									value="small" checked /> <label class="notification new1"
									for="size_1"><a href="complete.do" style="color: white;">로그아웃</a></label>


							</div>
						</div>
					</div>
				</div>
							
			<div class="container">
			<ul class="breadcrumb" style="padding: revert;">
				<li class="br"><a href="#">홈</a></li>
				<li class="br"><a href="complete.do">로그아웃</a></li>
				<li class="br">메인</li>
				<li class="br active" aria-current="page" style="color: white;">모임방 개설방</li>
			</ul>
			
		</div>
		
		
		</nav>
		<script type="text/javascript">
		
		// 현재 페이지의 URL 가져오기
		

    function dp_menu(){
        let click = document.getElementById("drop-content");
        if(click.style.display === "none"){
            click.style.display = "block";
            return false

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
		<section style="height: 920px; background-color: black;">
			<div id="container_list">
				<div id="wrapper_list">
					<div id="wrapper_list_inner" style="background-color: black;">
						<h2 id="headline"
							style="margin-bottom: 50px; background-color: black; color: #F8F8F8">내프로필</h2>
						<div id="wrapper_inner">
							<div id="pictureandbadgeandflower"
								style="background-color: black; display: flex; flex-direction: column; align-items: center;">
								<div class="wrapper_picture"
									style="background-color: black; height: 306.91px; width: 400px;">
									<div class="item_picture">
										<div class="polaroid" style="height: 283px;">
											<img id="mypicture" src="${url}"> <input type="file"
												id="image-input" name="file" style="display: none;"
												enctype="multipart/form-data">
											<div class="caption">눌러서 사진을 바꿔보세요!</div>
										</div>
									</div>
								</div>
								<div id="badge" style="display: flex;">
									<div id="innerbadges" class="innerbadges"
										style="display: flex;">
										<div class="badges" id="badges1" data-badge="1"
											onclick="setLoc1()"></div>
										<div class="badges" id="badges2" data-badge="2"
											onclick="setLoc2()"></div>
										<div class="badges" id="badges3" data-badge="3"
											onclick="setLoc3()"></div>
										<div id="popup"
											style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 20px; border: 1px solid black; width: 1000px; height: 800px; background-color: rgba(255, 255, 255, 0.3); z-index: 999; flex-direction: column;">
											<div class="imageGrid">
												<div class="hiddenBadges" data-badge="1"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="2"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="3"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="4"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="5"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="6"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="7"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="8"
													onclick="setBadge(this)"></div>
												<div class="hiddenBadges" data-badge="9"
													onclick="setBadge(this)"></div>
											</div>
											<button id="close-popup">닫기</button>
										</div>
									</div>
								</div>
								<div id="wateringCan"
									style="height: 100px; width: 100px; color: gray; font-size: 90px;">
									<i class="fa-solid fa-faucet"></i>
								</div>
								<div class="droplet1 droplet" style="color: blue;">
									<i class="fa-solid fa-droplet"></i>
								</div>
								<div class="droplet2 droplet" style="color: blue;">
									<i class="fa-solid fa-droplet"></i>
								</div>
								<div class="droplet3 droplet" style="color: blue;">
									<i class="fa-solid fa-droplet"></i>
								</div>
								<div id="flowerandflowerbutton" style="background-color: black;">
									<div id="flower"
										style="background: url(resources/mypage/images/plant.png) no-repeat; color: white;">
										<div class="starIcon1"
											style="width: 20px; height: 20px; color: yellow;">
											<i class="fa-solid fa-star fa-beat-fade"></i>
										</div>
										<div class="starIcon2"
											style="width: 20px; height: 20px; color: yellow;">
											<i class="fa-solid fa-star fa-beat-fade"></i>
										</div>
										<div class="starIcon3"
											style="width: 20px; height: 20px; color: yellow;">
											<i class="fa-solid fa-star fa-beat-fade"></i>
										</div>
									</div>
									<button type="button" id="wateringButton"
										onclick="animateFaucetAndDroplets()">
										출석체크! <i class="fa-solid fa-right-long"
											class="attendanceArrow "></i>
									</button>
									<!-- <div id="flowerbutton">
								<input type="button" value="물주기" id="watering" />
							</div> -->
								</div>
							</div>
							<div>
								<div id="memberinformation_header"
									style="background-color: black;"></div>
								<div>
									<table id="membertable">
										<tr>
											<td class="mypage_information">이름</td>
											<td class="mypage_information_text" contenteditable="false">
												${vo.name}</td>
										</tr>
										<tr>
											<td class="mypage_information">닉네임</td>
											<td class="mypage_information_text" contenteditable="true" id="nickNameNew">${vo.nickName}</td>
										</tr>
										<tr>
											<td class="mypage_information">아이디(이메일)</td>
											<td class="mypage_information_text" contenteditable="false">${vo.email}</td>
										</tr>
										<tr>
											<td class="mypage_information">성별</td>
											<td class="mypage_information_text" contenteditable="false">${vo.gender}</td>
										</tr>
										<tr>
											<td class="mypage_information">생년월일</td>
											<td class="mypage_information_text" contenteditable="false">${vo.birthday}</td>
										</tr>
										<tr>
											<td class="mypage_information">가입일</td>
											<td class="mypage_information_text" contenteditable="false">${vo.regDate}</td>
										</tr>
										<tr>
											<td class="mypage_information">지역</td>
											<td class="mypage_information_text" contenteditable="false"
												style="cursor: pointer;" onclick="getCities()">${vo.region}</td>
										</tr>
										<tr>
											<td class="mypage_information">매너점수</td>
											<td>
												<div class="container_progressbar">
													<div class="progress-bar__container">
														<div class="progress-bar">
															<span class="progress-bar__text">100점!</span>
														</div>
													</div>
												</div>
											</td>											
											<script>
											const progressBarContainer = document.querySelector('.progress-bar__container');
											const progressBar = document.querySelector('.progress-bar');
											const progressBarText = document.querySelector('.progress-bar__text');

											const progressBarStates = [0, 50, 100];

											let time = 0;
											let endState = 100;

											progressBarStates.forEach(state => {
											  let randomTime = Math.floor(Math.random() * 3000);
											  setTimeout(() => {
											    if(state == endState){
											      gsap.to(progressBar, {
											        x: `${state}%`,
											        duration: 2,
											        backgroundColor: '#4895ef',
											        onComplete: () => {
											          progressBarText.style.display = "initial";
											          progressBarContainer.style.boxShadow = '0 0 5px #4895ef';
											        }
											      });
											    }else{
											      gsap.to(progressBar, {
											        x: `${state}%`,
											        duration: 2,
											      });
											    }
											  }, randomTime + time);
											  time += randomTime;
											})
											
											</script>
										</tr>
									</table>
									<div id="locationPopup" class="location-popup">
												<div class="location-popup-content">
													<button type="button" class="location" value="용산구">용산</button>
									<button type="button" class="location" value="강남구">강남</button>
									<button type="button" class="location" value="강동구">강동</button>
									<button type="button" class="location" value="강북구">강북</button>
									<button type="button" class="location" value="강서구">강서</button>
									<button type="button" class="location" value="관악구">관악</button>
									<button type="button" class="location" value="광진구">광진</button>
									<button type="button" class="location" value="구로구">구로</button>
									<button type="button" class="location" value="금천구">금천</button>
									<button type="button" class="location" value="노원구">노원</button>
									<button type="button" class="location" value="도봉구">도봉</button>
									<button type="button" class="location" value="동대문구">동대문</button>
									<button type="button" class="location" value="동작구">동작</button>
									<button type="button" class="location" value="마포구">마포</button>
									<button type="button" class="location" value="서대문구">서대문</button>
									<button type="button" class="location" value="서초구">서초</button>
									<button type="button" class="location" value="성동구">성동</button>
									<button type="button" class="location" value="성북구">성북</button>
									<button type="button" class="location" value="송파구">송파</button>
									<button type="button" class="location" value="양천구">양천</button>
									<button type="button" class="location" value="영등포구">영등포</button>
									<button type="button" class="location" value="은평구">은평</button>
									<button type="button" class="location" value="종로구">종로</button>
									<button type="button" class="location" value="중구구">종구</button>
									<button type="button" class="location" value="중랑구">중랑</button>
												</div>
											</div>
								</div>
								<div id="memberbutton">
									<div class="portfolio-experiment" style="background: black;">
										<a onclick="changeNick()"> <span class="text" id="editBtn" >닉네임 변경 확인</span> <span
											class="line -right"></span> <span class="line -top"></span> <span
											class="line -left"></span> <span class="line -bottom"></span>
										</a>
									</div>
									<div class="portfolio-experiment"
										style="margin-left: 10px; margin-right: 20px; background: black;">
										<a> <span class="text">비밀번호변경</span> <span
											class="line -right"></span> <span class="line -top"></span> <span
											class="line -left"></span> <span class="line -bottom"></span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- footer 추가  -->
		<footer style="border-top: 1px solid gray"  class="footer">
		
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
