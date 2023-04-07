<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="firebase.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" 
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js">

/* Demo purposes only */
$(".hover").mouseleave(
  function () {
    $(this).removeClass("hover");
  }
);




</script>
<script type="text/javascript">

function storeHashInLocalStorage() {
	  const hashValue = document.getElementById("hashValue").value;
	  
	  localStorage.setItem("hash", hashValue);
	}
	
window.onload = function() {
	  storeHashInLocalStorage();
	};

firebase.auth().onAuthStateChanged((user) => {
    if (user) {
      console.log("User signed in:", user);

      if (user.emailVerified) {
    	  console.log("이메일 인증 돼 있음");
      } else {
        console.log("이메일 인증 안돼있음");
        document.getElementById("emailNotVerti").style.display = "flex";
      }
    } else {
      console.log("No user is currently signed in.");
    }
  });
  
  
  
  function sendEmail(){
	  const user = firebase.auth().currentUser;
	  const divElement = document.getElementById("emailPara");
	  const buttonElement = document.getElementById("getEmailButton");
	  if (user) {
		    user.sendEmailVerification()
		      .then(() => {
		    	  alert("이메일이 전송 됐습니다. 이메일 확인 하시고 다시 로그인해주세요.");
		        console.log("Verification email sent.");
		        divElement.innerText = "이메일을 못찾으시겠으면  스팸 폴더도 확인해주세요.";
		        buttonElement.innerText = "재전송";
		        
		      })
		      .catch((error) => {
		        console.error("Error sending verification email: ", error);
		      });
		  } else {
		    console.log("No user is currently signed in.");
		  }
  }
  var slideIndex = 1;
  function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("mySlides");
    if (n > x.length) {slideIndex = 1}
    if (n < 1) {slideIndex = x.length}
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";  
    }
    x[slideIndex-1].style.display = "block";  
  }
  function plusDivs(n) {
    showDivs(slideIndex += n);
  }
  document.addEventListener("DOMContentLoaded", function() {
    const element = document.getElementById("imageSlider");
    const height= window.innerHeight + "px";
   
    showDivs(slideIndex);
    element.style.height = height;

    // set interval for automatic slide change
    setInterval(function() {
      plusDivs(1);
    }, 5000);
    
   
  
  });
  document.addEventListener("DOMContentLoaded", function() {
	  document.getElementById("getLogOutLink").addEventListener("click", function(event) {
	    event.preventDefault(); // Prevent the default behavior (navigation)
	    globalSignOut(); // Call the globalSignOut function
	  });
	});
  function showChat() {
	  const messageArea = document.getElementById("messageArea");
	  var chatBot = document.getElementById("chatBot");
	  messageArea.classList.toggle("show");
	  if(chatBot.style.display==="none"){
		  chatBot.style.display = "flex";
	  }else{
		  chatBot.style.display = "none";
	  }
	}
  
  function typeMessage(element, message, index, interval) {
	  if (index < message.length) {
	    if (message[index] === '<') {
	      const tagEndIndex = message.indexOf('>', index);
	      element.insertAdjacentHTML('beforeend', message.slice(index, tagEndIndex + 1));
	      index = tagEndIndex + 1;
	    } else {
	      element.insertAdjacentHTML('beforeend', message[index]);
	      index++;
	    }
	    setTimeout(() => typeMessage(element, message, index, interval), interval);
	  }
	}
  
  function kakaoHelp() {
	    const chatMessageElement = document.getElementById("chatMessage");
	    chatMessageElement.innerHTML = '';
	    const kakaoHelpMessage = "카카오톡 관련 업무는 이쪽으로 연략 주시길 바랍니다!<a onclick='#'><i class='fa-solid fa-comment' style='font-size:30px;color:#000000;background-color:yellow;'></i></a>";
	    typeMessage(chatMessageElement, kakaoHelpMessage, 0, 50);
	  }

  function staffHelp() {
	    const chatMessageElement = document.getElementById("chatMessage");
	    chatMessageElement.innerHTML = '';
	    const staffHelpMessage = "스태프한테 연략을 하기 위해서는 이쪽으로 연략해주세요. <a onclick='#'><i class='fa-solid fa-clipboard-user' style='font-size:30px;background-color:black;color: #ebebeb;'></i></a>";
	    typeMessage(chatMessageElement, staffHelpMessage, 0, 50);
	  }
  function reportHelp() {
	    const chatMessageElement = document.getElementById("chatMessage");
	    chatMessageElement.innerHTML = '';
	    const staffHelpMessage = "리폿은 이 링크를 통해서 이용해 주세요. <a onclick='#'><i class='fa-solid fa-flag' style='font-size:30px;background-color:aliceblue;color: #2e2929; '></i></a>";
	    typeMessage(chatMessageElement, staffHelpMessage, 0, 50);
	  }
  function FAQHelp() {
	    const chatMessageElement = document.getElementById("chatMessage");
	    chatMessageElement.innerHTML = '';
	    const staffHelpMessage = "자주 묻는 질문은 여기에 정리 돼 있습니다.<a onclick='#'><i class='fa-solid fa-question' style='font-size:30px;background-color:aliceblue'></i></a>";
	    typeMessage(chatMessageElement, staffHelpMessage, 0, 50);
	  }
  function announceHelp() {
	    const chatMessageElement = document.getElementById("chatMessage");
	    chatMessageElement.innerHTML = '';
	    const staffHelpMessage = "공지사항은 이쪽을 확인해주세요. <a onclick='#'><i class='fa-solid fa-bullhorn' style='font-size:30px;background-color:skyblue;color: #f5f5f5; color: #e11414;'></i></a>";
	    typeMessage(chatMessageElement, staffHelpMessage, 0, 50);
	  }

  
</script>





<style>
.getEmailButton{
    background-color: gray;
    border-color: aliceblue;
    border-radius: 15px;
    color: yellow;
    font-size: 15px;
}
.getEmailButton:hover{
cursor: pointer;
background-color: darkgray;
}
.emailNotVerti{
display: none;
    width: auto;
    height: 50pxpx;
    background-color: rgb(19 22 1);
    color: revert;
    
}
.imageSlider{
width:auto;
background-color: blue;
padding-top: 135px;
}
.mySlides {
display:none;
}
.messageArea{
  position: fixed;
  bottom: 20px;
  right: 20px;
   background-color: rgb(220 219 201);
  border: 5px solid #c9b117ad;
 border-radius: 30px;
  padding: 10px;
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.5s ease-out, transform 0.5s ease-out;
}

.messageArea.show {
  opacity: 1;
  transform: translateY(0);
  height: 500px;
  display:flex;
  flex-direction: column;
    align-items: center;
  
}
.chatBot {
  position: fixed;
  bottom: 100px;
  right: 100px;
  background-color:rgba(36, 105, 236, 0.5);
  width: 100px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  border-radius: 5px;
  cursor: pointer;
}
.chatBot:hover{
background-color: rgba(36, 105, 236, 0.2);
}
.chatBot:hover #chatBotIcon{
 animation: hopAndColor 1s forwards;
}
@keyframes hopAndColor {
       0%   { transform: scale(1,1)    translateY(0); }
        10%  { transform: scale(1.1,.9) translateY(0); }
        30%  { transform: scale(.9,1.1) translateY(-10px); }
        50%  { transform: scale(1,1)    translateY(0); }
        100% { transform: scale(1,1)    translateY(0); color:gray;}
        }
.messageButtons{
background-color: rgba(255,255,255,0.5);
color: black;
border:2px solid black;
height:50px;
width:100px;
border-radius: 30px;
}
.messageButtons:hover{
cursor:pointer;
color:rgb((83 87 198);
}
.chatMessage{
    display: flex;
    background-color:rgba(66,177,76,0.4);
    color: #2443d1;
    font-size: 25px;
    height: 200px;
    width: 300px;
    justify-content: space-around;
    flex-direction: column;
    border: 2px solid green;
    border-radius: 30px;
}
.buttonGroupMessage{
display:flex;
}

</style>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,300&display=swap" rel="stylesheet">
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-solid-rounded/css/uicons-solid-rounded.css'>
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-straight/css/uicons-regular-straight.css'>
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-straight/css/uicons-regular-straight.css'>
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-thin-straight/css/uicons-thin-straight.css'>

<link href="resources/mymain/css/mymain.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">


</head>
<body>
<input type="hidden" id="hashValue" value="${hash}">
<header>	
  <input type="checkbox" class="openSidebarMenu" id="openSidebarMenu">
  <label for="openSidebarMenu" class="sidebarIconToggle">
    <div class="spinner diagonal part-1"></div>
    <div class="spinner horizontal"></div>
    <div class="spinner diagonal part-2"></div>
  </label>
  <div id="sidebarMenu">
    <ul class="sidebarMenuInner">
      <li><a href="#"><i class="fi fi-sr-home">&emsp;&emsp;홈</i></a></li>
        <li><a id="getLogOutLink" href="#"><i class="fi fi-rr-user">&emsp;로그아웃</i></a></li>
        <li><a href="#"><i class="fi fi-rr-basketball">&emsp;농구</i></a></li>
        <li><a href="#"><i class="fi fi-rr-baby">&ensp;클라이밍</i></a></li>
        <li><a href="#"><i class="fi fi-rs-bowling">&emsp;볼링</i></a></li>
        <li><a href="#"><i class="fi fi-ts-racquet">&ensp;배드민턴</i></a></li>
        <li><a href="homepage.do"><i class="fi fi-rs-house-flood">&ensp;방만들기</i></a></li>
        <li><a href="#"><i class="fi fi-rr-thumbtack">&ensp;신고하기</i></a></li>
        <li><a href="#"><i class="fi fi-rr-comment-sms">&ensp;게시판</i></a></li>
    </ul>
  </div>
  
  
 
		<h3 style="text-align: center;">today Time's </h3>
		
		<nav>
		<div class="option">
		<div class="dropdown1">
        <button onclick="dp_menu1()" class="button1"> <i class="material-icons dp48">notifications</i></button>
      	
    <spacer></spacer>
      <span class="num-count">2</span>
        <div style="display: none;" id="drop-content1" >
    <div class="notification-icon right">     

    </div>
  
    <div class="profile1">
    </div>
    <div class="notification-container1">
      <input class="checkbox" type="checkbox" id="size_1" value="small" checked />
      <label class="notification new" for="size_1"><em>1</em> new <a href="">guest account(s)</a> have been created.<i class="material-icons dp48 right">clear</i></label>
  
      <input class="checkbox" type="checkbox" id="size_2" value="small" checked />
      <label class="notification new" for="size_2"><em>2</em> new <a href="">lead(s)</a> are available in the system.<i class="material-icons dp48 right">clear</i></label>
       
      <input class="checkbox" type="checkbox" id="size_4" value="small" checked />
      <label class="notification" for="size_4"><em>3</em> new <a href="">calendar event(s)</a> are scheduled for today.<i class="material-icons dp48 right">clear</i></label>
  
      <input class="checkbox" type="checkbox" id="size_5" value="small" checked />
      <label class="notification" for="size_5"><em>4</em> blog post <a href="">comment(s)</a> need approval.<i class="material-icons dp48 right">clear</i></label>
      
    </div>
        </div>
        </div>
        
		<div class="dropdown">
        <button onclick="dp_menu()" class="button"><i class="fi fi-rr-user" style="font-size: 20px;"></i></button>
      <spacer></spacer>
       <div style="display: none;" id="drop-content">
     
     
     <div class="profile">
    </div>
    <div class="notification-container">
    	<input class="checkbox1" type="checkbox" id="size_1" value="small" checked />
      <label class="notification new1" for="size_1"><a href="" style="color: white;">마이페이지</a></label>
    	<input class="checkbox1" type="checkbox" id="size_1" value="small" checked />
      <label class="notification new1" for="size_1"><a href="" style="color: white;">신청내역</a></label>
    	<input class="checkbox1" type="checkbox" id="size_1" value="small" checked />
      <label class="notification new1" for="size_1"><a href="roomList.do"style="color: white;">개설방내역</a></label>
    	<input class="checkbox1" type="checkbox" id="size_1" value="small" checked />
      <label class="notification new1" for="size_1"><a id="getLogOutLink" onclick="globalSignOut()" style="color: white;">로그아웃</a></label>
  
     
      </div>
      </div>
        </div>
  	  </div>
		<div class="container">
			<ul class="breadcrumb">
				<li class="br"><a href="#">홈</a></li>
				<li class="br"><a id="getLogOutLink" onclick="globalSignOut()">로그아웃</a></li>
				<li class="br"><a href="#">메뉴</a></li>
				<li class="br active" aria-current="page">현재페이지</li>
			</ul>
		</div>
   
   </nav>
   
   <div class="emailNotVerti" id="emailNotVerti" >
   <p id="emailPara" style="margin: 0;">이메일 인증이 안돼있습니다. 인증하기를 눌러서 인증을 진행해주세요.</p>
   <button type="button" id="getEmailButton" class="getEmailButton" onclick="sendEmail()" 
   style="
    margin-left: 44px;
    margin-top: 0px;
    height:33px;
  ">인증하기</button>
   </div>

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
		
		
	</header>
	
<div class="imageSlider" id="imageSlider">
 <img class="mySlides" src="resources/images/이미지배너 광고1.png" style="width:100%;height:100%;">
  <img class="mySlides" src="resources/images/이미지배너 농구.png" style="width:100%;height:100%;">
  <img class="mySlides" src="resources/images/이미지배너 광고2.png" style="width:100%;height:100%;">
  <img class="mySlides" src="resources/images/이미지배너 볼링.png" style="width:100%;height:100%;"> 
</div>
		
		
	
<section>
<figure class="snip1425">
  <img src="resources/image/bascketball1.jpg" alt="sq-sample19"
  style="height: 450px;"/>
  <figcaption><i class="ion-podium"></i>
    <h4>Category</h4>
    <h2>Basketball</h2>
  </figcaption>
  <a href="#"></a>
</figure>
		<figure class="snip1425">
  <img src="resources/image/climbing6.jpg" alt="sq-sample19" 
  style="width: 5000px; height: 450px;"/>
  <figcaption><i class="ion-podium1"></i>
    <h4>Category</h4>
    <h2>Climbing</h2>
  </figcaption>
  <a href="#"></a>
</figure>
		<figure class="snip1425">
  <img src="resources/image/badminton1.png" alt="sq-sample19"
  style="height: 450px;" />
  <figcaption><i class="ion-podium1"></i>
    <h4>Category</h4>
    <h2>badminton</h2>
  </figcaption>
  <a href="#"></a>
</figure>
<figure class="snip1425">
<img src="resources/image/4.jpg" alt="sq-sample21"
 style="height: 450px;"/>
  <figcaption><i class="ion-university"></i>
    <h4>Category</h4>
    <h2>Bowling</h2>
  </figcaption>
  <a href="#"></a>
</figure>


	</section>
	<div id="messageArea" class="messageArea" >
	<div style="
    width: 540px;
    display: flex;
    flex-direction: row-reverse;
	">
	<button onclick="showChat()" style="
	    color: black;
    background-color: #ff000075;
    height: 30px;
    border-radius: 30px;
    border: 1px solid red;
    font-size: 20px;
    font-weight: bold;	
	">닫기</button>
	</div>
	
	<div id="buttonGroupMessage">
	<button class="messageButtons" type="button" onclick="kakaoHelp()" >카카오톡</button>
	<button class="messageButtons" type="button" onclick="staffHelp()" >직원요청</button>
	<button class="messageButtons" type="button" onclick="reportHelp()" >신고기능</button>
	<button class="messageButtons" type="button" onclick="announceHelp()" >공지사항</button>
	<button class="messageButtons" type="button" onclick="FAQHelp()" >FAQ</button>
	</div>
	
	<div style="height:200px"></div>
	<div id="chatMessage" class="chatMessage"style="
	 display: flex;
    background-color:rgba(66,177,76,0.4);
    color: #2443d1;
    font-size: 25px;
    height: 200px;
    width: 300px;
    justify-content: space-around;
    flex-direction: column;
    border: 2px solid green;
    border-radius: 30px;	
	">안녕하세요!</div>
	</div>
	<div class="chatBot" id="chatBot" onclick="showChat()">
	 
	<p><i id="chatBotIcon" class="fa-solid fa-comment"></i></p>
	
	</div>
	
		<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="footer-col">
					<div class="social-links"style="text-indent:95px;">
						<p>친절한 고객센터 
						   1688-4757
						<p>월요일-금요일10:00-17:00</p>
						<p>[주말/공휴일휴무]고객상담을 위한 연락처로 마케팅
						제안은 정중히 사양합니다</p>
		
					
				</div>
				</div>
				
				<div class="footer-col1">
					<h2 style="margin-top: 22px;">&emsp;Social Media</h2>
								
	<ul class="social-icons"  style="margin-top: -29px;">
      <li><a href="https://www.facebook.com/profile.php?id=100091363184815" class="social-square"><i class="fab  fa-facebook-f fa-1x"></i></a></li>
      <li><a href="https://www.youtube.com/channel/UCd_IGM4iCm0IUjsozb_xO8w" class="social-square"><i class="fab  fa-youtube fa"></i></a></li>
      <li><a href="https://www.instagram.com/neulddyaeng.o/" class="social-square"><i class="fab  fa-instagram fa"></i></a></li>
      <li><a href="https://blog.naver.com/tjdwosk3" class="social-square"><i class="fa-brands fa-line fa"></i></a></li>
    </ul>
					</div>
				</div>

			</div>
		

	</footer>

</body>
</html>