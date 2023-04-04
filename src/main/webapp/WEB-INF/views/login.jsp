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
        <script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
        <link href="resources/LoginRegisterCss/login.css" rel="stylesheet">
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
    		  // Initialize the Facebook provider
    		  const provider = new firebase.auth.FacebookAuthProvider();

    		  // Sign in to Firebase using the Facebook provider
    		 
    		  auth.signInWithPopup(provider)
    		    .then((result) => {
    		      // Redirect the user to the appropriate page based on their authentication status
    		      if (result.additionalUserInfo.isNewUser) {
    		    	  console.log("new");
    		        window.location.href = "register.do?sns=facebook";
    		      } else {
    		    	  console.log("old");
    		        window.location.href = "complete.do";
    		      }
    		    })
    		    .catch((error) => {
    		      console.log(error);
    		    });
    		  
    		  alert("hi mum");
    		}
       
     
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
    function signInWithKakao() {
    	  Kakao.Auth.login({
    		  scope: 'account_email',
    	    success: function (authObj) {
    	      console.log('Authentication successful:', authObj);

    	      Kakao.API.request({
    	        url: '/v2/user/me',
    	        success: function (res) {
    	          console.log('User profile:', res);
    	      const userEmail = res.kakao_account.email;
					
    	          // Send the Kakao user ID to your server
    	          $.ajax({
    	            type: 'POST',
    	            url: 'kakaoLogin.do', // Replace with your server URL
    	            data: {
    	            	email: userEmail,
    	            	
    	            },
    	            dataType: 'text',
    	            success: function (response) {
    	            	console.log("repsonse: " + response);
    	              if (response === "register.do?sns=kakao") {
    	                window.location.href = "register.do?sns=kakao";
    	              } else {
    	                window.location.href = "complete.do";
    	              }
    	            },
    	            error: function (xhr, status, error) {
    	              console.log('Error:', error);
    	            }
    	          });
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
    
    <script>
    document.addEventListener("DOMContentLoaded", function () {
    	  var naverLogin = new naver.LoginWithNaverId({
    	    clientId: "BqvY6jqAibll3bzxdKln",
    	    callbackUrl: "http://localhost:8090/login.do",
    	    isPopup: false,
    	  });

    	  naverLogin.init();

    	  var customNaverLoginBtn = document.getElementById("naver");
    	  customNaverLoginBtn.addEventListener("click", function () {
    	    naverLogin.getLoginStatus(function (status) {
    	      if (status) {
    	        // Get the user's Naver ID or email
    	         var userEmail = naverLogin.user.getEmail(); // or naverLogin.user.getEmail();
				console.log('userEmail ' + userEmail);
    	        // Send an AJAX request to your server to check if the user exists
    	        $.ajax({
    	          type: 'POST',
    	          url: 'getNaver.do',
    	          data: {
    	            email: userEmail,
    	           
    	          },
    	          dataType: 'text',
    	          success: function (response) {
    	            if (response === "1") {
    	              // If the user exists in your database, log them in
    	              window.location.href = "complete.do";
    	            } else {
    	              // If the user does not exist, redirect them to the registration page
    	              window.location.href = "register.do?sns=naver";
    	            }
    	          },
    	          error: function (xhr, status, error) {
    	            alert('Error: ' + error);
    	          }
    	        });
    	      } else {
    	        // If the user is not logged in, show the Naver Login popup
    	        naverLogin.authorize();
    	      }
    	    });
    	  });
    	});
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
                    <label class=""><a href="findPassword.do"><u>비밀번호를 잃었습니다</u></a></label>
                </div>
               
            </div>
            <div class="register">
                <p>계정이 없습니까?<a href="register.do?sns=email"><u>회원가입하기</u></a></p>
            </div>
            <div style="display:flex;justify-content:space-around;">
            <a href="login.mymain.do">홈으로 돌아가기</a>
        </div>
            
           

         </div>
        </div>

        <div class="thirdParty">
            <button class="thirdPartyButton" id="google" onclick="signInWithGoogle()"></button>
            <button class="thirdPartyButton" id="naver"></button>
            <button class="thirdPartyButton" id="kakao" onclick="signInWithKakao()"></button>
            <button class="thirdPartyButton" id="facebook" onclick="signInWithFacebook()"></button>
        </div>

    </div>

    
    </body>
</html>