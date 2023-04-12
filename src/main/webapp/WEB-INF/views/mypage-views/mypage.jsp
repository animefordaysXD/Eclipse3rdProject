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
@keyframes moveArrow {
      0% {
        transform: translateX(0);
        opacity: 1;
      }
      100% {
        transform: translateX(100%);
        opacity: 0;
      }
    }
.badges {
	width: 100px;
	height: 98px;		
}
.badges:hover{
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
      animation: shake 0.5s cubic-bezier(.36,.07,.19,.97) both;
    }

    @keyframes shake {
      10%, 90% {
        transform: translate3d(-1px, 0, 0);
      }
      
      20%, 80% {
        transform: translate3d(2px, 0, 0);
      }

      30%, 50%, 70% {
        transform: translate3d(-4px, 0, 0);
      }

      40%, 60% {
        transform: translate3d(4px, 0, 0);
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
      top:550px;
      left:220px;
      animation: fall 1s linear forwards;
    }

    @keyframes fall {
      0% {
        opacity: 1;
        transform: translateY(0);
      }
      100% {
        opacity: 0;
        transform: translateY(100px);
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

#close-popup{
width:300px;
height:40px;
background-color: rgba(20, 217, 190, 0.5);
color: rgba(252, 23, 27, 1);
margin-left:245px;
margin-top:244px;
}
#close-popup:hover{
cursor:pointer;
background-color: rgba(15, 138, 121, 0.3);
}
div[data-badge="1"] {
  background: url(resources/mypage/images/1.png) no-repeat;background-size: cover;
}
div[data-badge="2"] {
  background: url(resources/mypage/images/2.png) no-repeat;background-size: cover;
}

div[data-badge="3"] {
  background: url(resources/mypage/images/3.png) no-repeat;background-size: cover;
}

div[data-badge="4"] {
  background: url(resources/mypage/images/4.png) no-repeat;background-size: cover;
}

div[data-badge="5"] {
  background: url(resources/mypage/images/5.png) no-repeat;background-size: cover;
}

div[data-badge="6"] {
  background: url(resources/mypage/images/6.png) no-repeat;background-size: cover;
}

div[data-badge="7"] {
  background: url(resources/mypage/images/7.png) no-repeat;background-size: cover;
}

div[data-badge="8"] {
  background: url(resources/mypage/images/8.png) no-repeat;background-size: cover;
}

div[data-badge="9"] {
  background: url(resources/mypage/images/9.png) no-repeat;background-size: cover;
}

.mypage_information_text.editable {
  /* styles when editable */
  background-color: #F8F8F8;
  border: 1px solid black;
  color: black;
}

</style>
<script>

var selected = "";
  function animateFaucetAndDroplets() {
	  const faucet = document.getElementById('wateringCan');
      const droplets = document.querySelectorAll('.droplet');
      faucet.classList.add('faucet-shake');
      
      droplets.forEach((droplet, index) => {
        setTimeout(() => {
          droplet.classList.add('droplet-animate');
        }, index * 200);
      });

      setTimeout(() => {
        faucet.classList.remove('faucet-shake');
        droplets.forEach(droplet => droplet.classList.remove('droplet-animate'));
      }, 1000);
    }
  
  document.addEventListener('DOMContentLoaded', () => {
	  const badgeNumbers = [4, 2, 3]; // Array of badge numbers
	  
	  // Get all badge elements and the popup elements after they have been created
	  const popup = document.getElementById('popup');
	  const popupContent = document.getElementById('popup-content');
	  const closePopupButton = document.getElementById('close-popup');
	  const badges = document.querySelectorAll('.badges');
	  const hiddenBadges = document.querySelectorAll('.hiddenBadges');
	  
	  
	  const editBtn = document.getElementById("editBtn");
	  const infoTexts = document.querySelectorAll(".mypage_information_text");

	  editBtn.addEventListener("click", function() {
	    infoTexts.forEach(text => {
	      text.contentEditable = "true";
	      text.classList.add("editable"); // add a class for styling
	    });
	  });
	 
	 


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
	                }
	            });
	        });
	    });
	    
	   
  
 

  
  
  </script>
<body>
	<div id="wrap">
		<header>
			<h3 style="text-align: center;">today Time's</h3>
		</header>
		<!-- navigator 추가  -->
		<nav style="border-bottom: 1px solid gray"></nav>
		<section style="height: 920px; background-color: black;">
			<div id="container_list">
				<div id="wrapper_list">
					<div id="wrapper_list_inner" style="background-color: black;">
						<h2 id="headline"
							style="margin-bottom: 50px; background-color: black; color: #F8F8F8">내프로필</h2>
						<div id="wrapper_inner">
							<div id="pictureandbadgeandflower"
								style="background-color: black; display: flex; flex-direction: column; align-items: center;">
								<div class="wrapper_picture" style="background-color: black;height:306.91px; width:400px;">
									<div class="item_picture">
										<div class="polaroid" style="height:283px;">
											<img id="mypicture"
												src="${url}">
												<input type="file" id="image-input" name="file" style="display: none;" enctype="multipart/form-data" >
											<div class="caption">안녕하세요!</div>
										</div>
									</div>
								</div>
								<div id="badge" style="display: flex;">
									
									<div id="innerbadges" class="innerbadges" style="display: flex;">
										 <div class="badges" id="badges1" data-badge="1" onclick="setLoc1()"></div>
  										<div class="badges"  id="badges2" data-badge="2" onclick="setLoc2()"></div>
  										<div class="badges"  id="badges3" data-badge="3" onclick="setLoc3()"></div>
										 
										
										<div id="popup" style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 20px; border: 1px solid black;
										width:1000px;height:800px;background-color: rgba(255,255,255,0.3);z-index: 999;flex-direction: column;
										
										">
										<div class="imageGrid">
  											    <div class="hiddenBadges" data-badge="1" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="2" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="3" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="4" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="5" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="6" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="7" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="8" onclick="setBadge(this)"></div>
  												<div class="hiddenBadges" data-badge="9" onclick="setBadge(this)"></div>
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
										FLOWER
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
									<button type="button"
										style="width: 300px; height: 30px; margin: 0 auto; background-color: rgba(0, 62, 255, 0.7); color: #fff; border-radius: 8px; border: 1px solid white;"
										id="wateringButton" onclick="animateFaucetAndDroplets()">
										출석체크! <i class="fa-solid fa-right-long" class="attendanceArrow "></i>
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
											<td class="mypage_information_text" contenteditable="false"> '${vo.name}'</td>
										</tr>
										<tr>
											<td class="mypage_information">닉네임</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.nickName}'</td>
										</tr>
										<tr>
											<td class="mypage_information">아이디(이메일)</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.email}'</td>
										</tr>
										<tr>
											<td class="mypage_information">성별</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.gender}'</td>
										</tr>
										<tr>
											<td class="mypage_information">생년월일</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.birthday}'</td>
										</tr>
										<tr>
											<td class="mypage_information">가입일</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.regDate}'</td>
										</tr>
										<tr>
											<td class="mypage_information">지역</td>
											<td class="mypage_information_text" contenteditable="false">'${vo.region}'</td>
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
											<script src="resources/mypage/js/progressbar.js"></script>
										</tr>
									</table>
								</div>
								<div id="memberbutton">
									<div class="portfolio-experiment" style="background: black;">
										<a> <span class="text" id="editBtn">회원정보 수정</span> <span
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
		<footer style="border-top: 1px solid gray"></footer>
	</div>
</body>
</html>

