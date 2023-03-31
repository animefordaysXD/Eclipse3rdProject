<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="firebase.jsp" %>
<!DOCTYPE html>
<html lang="utf-8">
   
     <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.google.com/specimen/Black+Han+Sans?subset=korean&noto.script=Kore">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>      
        <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>  
        <link href="resources/css/login.css" rel="stylesheet">
    </head>

    <script>
      // Your web app's Firebase configuration
     

      const auth = firebase.auth();

      // Email verification
   

      // Google login
      function signInWithGoogle() {
        const provider = new firebase.auth.GoogleAuthProvider();
        provider.setCustomParameters({ prompt: 'select_account' });

        auth
          .signInWithPopup(provider)
          .then((result) => {
        	  if (result.additionalUserInfo.isNewUser) {
      	        // New user, redirect to the registration page
      	        window.location.href = "register.do?sns=google";
      	      } else {
      	        // Existing user, redirect to the complete page
      	        window.location.href = "complete.do";
      	      }
          })
          .catch((error) => {
            // Handle errors
          });
      }

      // Facebook login
      function signInWithFacebook() {
        const provider = new firebase.auth.FacebookAuthProvider();

        auth
          .signInWithPopup(provider)
          .then((result) => {
        	  if (result.additionalUserInfo.isNewUser) {
        	        
        	        window.location.href = "register.do?sns=facebook";
        	      } else {
        	       
        	        window.location.href = "complete.do";
        	      }
          })
          .catch((error) => {
           console.log("error: " + error);
          });
      }

      // Sign out
      function signOut() {
        auth.signOut().then(() => {
          // User signed out
        });
      }

      // Listen for authentication state changes
      auth.onAuthStateChanged((user) => {
        if (user) {
          // User is signed in
          if (!user.emailVerified) {
            sendVerificationEmail();
          }
        } else {
          // User is signed out
        }
      });
    </script>
    <script>
    document.addEventListener("DOMContentLoaded", function() {
    	 var loginStatus = "${loginStatus}";
    	 if(loginStatus==="fail"){
    		 alert('로그인 실패');
    	 }
    });
   
    
    function getLogin(){
    	var username = document.getElementById('username').value;
    	var password = document.getElementById('password').value;
    	$(function() {
			$.ajax({
		        type: 'POST',
		        url: 'getLogin.do',
		        data: {
		          email: username,
		          password: password
		        },
		        dataType: 'text',
		        success: function(response) {	 
		        	
		        	if(response==="1"){
		        		window.location.href = "complete.do";
		        	}else{
		        		alert('로그인 실패');
		        	}
		        			
		        },
		        error: function(xhr, status, error) {
		        	alert('error : ' + error);
		        }
		      });
		});
    }
    
    </script>
    
    <script>
    Kakao.init('9d66e104aa5d785eda1c654d772e0693');
   function signInWithKakao(){
	   Kakao.Auth.login({
	        success: function (authObj) {
	          console.log('Authentication successful:', authObj);

	          // Get user profile data
	          Kakao.API.request({
	            url: '/v2/user/me',
	            success: function (res) {
	              console.log('User profile:', res);
	              if (res.kakao_account.is_email_verified) {
	                  window.location.href = "register.do?sns=Kakao";
	                } else {
	                  window.location.href = "complete.do";
	                }
	              
	            },
	            fail: function (error) {
	              console.log('Failed to get user profile:', error);
	            },
	          });
	        },
	        fail: function (error) {
	          console.log('Authentication failed:', error);
	        },
	      });
    }
   
    
    </script>
    
    
    
    <body>
    <div class="box">
        <div class="login-box">
        <div class="container">
            <div class="top=header">
                <span>계정이 있습니까?</span>
                <header>로그인</header>
            </div>
           
            <div class="input-field" id="id">
                <input type="text" class="input" id="username" placeholder="유저네임" required>
            </div>
            <div class="space"></div>
            <div class="input-field" id="pwd">
                <input type="password" class="input" id="password" placeholder="비밀번호" required>
            </div>
            <div class="space"></div>
            <div class="input-field">
               <button type="button" class="submit" onclick="getLogin()">로그인</button>
            </div>

            <div class="bottom">
                <div class="left">
                    <input type="checkbox" id="check">
                    <label for="check">로그인 유지하기</label>
                </div>
                <div class="right">
                    <label class=""><a href="#"><u>비밀번호를 잃었습니다</u></a></label>
                </div>
               
            </div>
            <div class="register">
                <p>계정이 없습니까?<a href="register.do?sns=email"><u>회원가입하기</u></a></p>
            </div>
            <div style="display:flex;justify-content:space-around;">
            <a href="#">홈으로 돌아가기</a>
        </div>
            
           

         </div>
        </div>

        <div class="thirdParty">
            <button id="thirdPartyButton" class="google" onclick="signInWithGoogle()"></button>
            <button id="thirdPartyButton" class="naver"></button>
            <button id="thirdPartyButton" class="kakao" onclick="signInWithKakao()"></button>
            <button id="thirdPartyButton" class="facebook" onclick="signInWithFacebook()"></button>
        </div>

    </div>

    
    </body>
</html>