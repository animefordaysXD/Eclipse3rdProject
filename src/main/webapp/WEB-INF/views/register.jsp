<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" crossorigin="anonymous">


<html lang="UTF-8">

<head>
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/register.css" rel="stylesheet">
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {
    //document.getElementById("showCity").textContent="구를 선택해주세요";
    const buttons = document.querySelectorAll(".location");

buttons.forEach((button) => {
  button.addEventListener("click", setLoc);
});
});
function comparePassword() {
		var password = document.getElementById("password").value;
		var passwordCheck = document.getElementById("passwordCheck").value;
		var pwdText = document.getElementById("pwdText");
		
		if (password == passwordCheck && password != "") {
			pwdText.textContent = "";
		} else {
			pwdText.textContent = "비밀번호가 맞지않습니다";		
		}
	}
	
function setVisibility() {
	  var x = document.getElementById("divOne");
	  if (x.style.display === "none") {
	    x.style.display = "flex";
	  } else {
	    x.style.display = "none";
	  }
	}
function getCategoryBasket(button){  
    var pressed= button.getAttribute("data-value2");
    if (pressed == "false"){
        pressed = "true";
    }else if(pressed == "true"){
        pressed = "false";
    }
    button.setAttribute("data-value2", pressed); 
}
function getCategoryBadmin(button){
    var pressed= button.getAttribute("data-value2");
    if (pressed == "false"){
        pressed = "true";
    }else if(pressed == "true"){
        pressed = "false";
    }
    button.setAttribute("data-value2", pressed); 
}
function getCategoryBowl(button){
    var pressed= button.getAttribute("data-value2");
    if (pressed == "false"){
        pressed = "true";
    }else if(pressed == "true"){
        pressed = "false";
    }
    button.setAttribute("data-value2", pressed); 
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
document.getElementById("showCity").style.border="1px solid blue";

}
</script>
</head>
<body>
    
    <div class="box">
        <div class="signup">
            <div class="signupEmail">
                <input type="text" class="input_field" id="email" placeholder="이메일/아이디">
                <button class="signUpbutton">중복체크</button>
                <div class="space"></div>
            </div>
            <div class="password">
                <input type="password" class="input_field" id="password" placeholder="비밀번호">
                <div class="space"></div>
                <input type="password" class="input_field" id="passwordCheck" placeholder="비밀번호확인">
                <div class="space"></div>

            </div>
            <div class="nameGender">
                <input type="text" class="input_field" id="name" placeholder="이름">
                <div class="space"></div>
                <select class="gender" id="gender">
                    <option value="">성별을 선택해주세요</option>
                    <option value="1">남성</option>
                    <option value="2">여성</option>
                </select>
                <div class="space"></div>
            </div>
            <div class="getConfirm">
                <input type="text" class="input_field" placeholder="인증번호"><button
                    class="signUpbutton">인증확인</button><button class="signUpbutton">재요청</button>

                <div class="space"></div>

            </div>
            <div class="birthDay">
                <input type="date" id="birthday" name="birthday">

                <label for="birthday">생일</label><br>
                <div class="space"></div>
            </div>
            <div class="space"></div>
            <textarea class="terms" readonly>
 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                  </textarea>
            <label for="termCheck">이용약관<input type="checkbox" class="termCheck"></input></label>

        </div>
    </div>
    <div class="regButtons">
        <button class="cancelReg" onclick="#">취소하기</button>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <button class="regCheck" onclick="setVisibility()">회원가입 완료</button>
      
    </div>
    <div class="overlay" id="divOne" style="display: none;">
        <div class="wrapper">
            <a href="javascript:setVisibility();" class="close">X</a>
            <h2 class="popUpHeader">선호하는 지역이랑 시간을 알려주세요!</h2>
            <div class="content">
                <div class="container">
                    <form>
                        <label>닉네임(별명)<input type="text" class="NickName" placeholder="사용하실 닉네임"></label>
                        <br>
                        <button class="getNick">닉네임 중복 확인</button>
                        <br>
                        <p> 자신의 지역을 알려주세요!</p>
                        <button type="button" class="seoul" onclick="showCity()">서울시<i class="fa-solid fa-city" id="seoulCity"></i></button>&emsp;&emsp;<div id="showCity" class="showCity"></div>
                        <br>
                        <br>
                        
                        <div class="locations" id="locations">
                            
                           <button type="button"  class="location" value="용산">용산</button>
                           <button type="button" class="location" value="강남">강남</button>
                           <button type="button" class="location" value="강동">강동</button>
                           <button type="button" class="location" value="강북">강북</button>
                           <button type="button" class="location" value="강서">강서</button>
                           <button type="button" class="location" value="관악">관악</button>
                           <button type="button" class="location" value="광진">광진</button>
                           <button type="button" class="location" value="구로">구로</button>
                           <button type="button" class="location" value="금천">금천</button>
                           <button type="button" class="location" value="노원">노원</button>
                           <button type="button" class="location" value="도봉">도봉</button>
                           <button type="button" class="location" value="동대문">동대문</button>
                           <button type="button" class="location" value="동작">동작</button>
                           <button type="button" class="location" value="마포">마포</button>
                           <button type="button" class="location" value="서대문">서대문</button>
                           <button type="button" class="location" value="서초">서초</button>
                           <button type="button" class="location" value="성동">성동</button>
                           <button type="button" class="location" value="성북">성북</button>
                           <button type="button" class="location" value="송파">송파</button>
                           <button type="button" class="location" value="양천">양천</button>
                           <button type="button" class="location" value="영등포">영등포</button>
                           <button type="button" class="location" value="은평">은평</button>
                           <button type="button" class="location" value="종로">종로</button>
                           <button type="button" class="location" value="중구">종구</button>
                           <button type="button" class="location" value="중랑">중랑</button>
                        </div>
                        <br>
                        <br>
                        <div class="categoryGet" id="categoryGet">
                            <!-- data-value2 is pressed for functions above -->
                           <button type="button" data-value1="basketball" data-value2="false" id="basketball" class="categoryButton" onclick="getCategoryBasket(this)">농구<i class="fa-solid fa-basketball" id="basketballIcon"></i></button> 
                           <button type="button" value="climbing" id="climbing" data-value2="false" class="categoryButton" onclick="getCategoryBasket(this)">클라이밍 <i class="fa-solid fa-mountain" id="climbingIcon"></i></button>
                           <button type="button" value="bowling" id="bowling" data-value2="false" class="categoryButton" onclick="getCategoryBasket(this)">볼링 <i class="fa-solid fa-bowling-ball" id="bowlingIcon"></i></button>
                           <button type="button" value="badminton" id="badminton" data-value2="false" class="categoryButton" onclick="getCategoryBasket(this)">배드민턴 <i class="fa-solid fa-table-tennis" id="badminIcon"></i></button>                        
                        </div>
                        <br>
                        <p> 선호하는 시간을 알려주세요!</p>
                         <input type="time" class="prefTime" id="prefTime"><label class="prefTimeLab">부터</label>
                         <input type="time" class="prefTime2" id="prefTime2"><label class="prefTimeLab">까지</label>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                       
                        <div class="confirmSignUp">
                            <button class="confirmSign" value="submit">확인 <i class="fa-solid fa-check" id="confirmRegFin"></i></button>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>