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
        <link href="resources/css/login.css" rel="stylesheet">
      
        
    </head>

    <script>
      // Your web app's Firebase configuration
     

      const auth = firebase.auth();

      // Email verification
   

      // Google login
      function signInWithGoogle() {
        const provider = new firebase.auth.GoogleAuthProvider();

        auth
          .signInWithPopup(provider)
          .then((result) => {
        	  if (result.additionalUserInfo.isNewUser) {
      	        // New user, redirect to the registration page
      	        window.location.href = "register.do";
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
        	        // New user, redirect to the registration page
        	        window.location.href = "register.do";
        	      } else {
        	        // Existing user, redirect to the complete page
        	        window.location.href = "complete.do";
        	      }
          })
          .catch((error) => {
            // Handle errors
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
               <button class="submit" onclick="getLogin()">로그인</button>
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
                <p>계정이 없습니까?<a href="register.do"><u>회원가입하기</u></a></p>
            </div>
            <div style="display:flex;justify-content:space-around;">
            <a href="#">홈으로 돌아가기</a>
        </div>
            
           

         </div>
        </div>

        <div class="thirdParty">
            <button class="google" onclick="signInWithGoogle()"></button>
            <button class="naver"></button>
            <button class="kakao"></button>
            <button class="facebook" onclick="signInWithFacebook()"></button>
        </div>

    </div>

    
    </body>
</html>