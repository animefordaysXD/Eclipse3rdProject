<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
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
    function getAdmin(){
    	
    	    	var username = document.getElementById('username').value;
    	    	var password = document.getElementById('password').value;
    	    	$(function() {
    				$.ajax({
    			        type: 'POST',
    			        url: 'getAdminLogin.do',
    			        data: {
    			          email: username,
    			          password: password
    			          
    			        },
    			        dataType: 'text',
    			        success: function(response) {	 
    			        	
    			        	if(response==="1"){
    			        		window.location.href = "adminComplete.do";
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
    
    <body>
    <div class="box">
        <div class="login-box">
        <div class="container">
            <div class="top=header">
                <span>계정이 있습니까?</span>
                <header> 관리자 로그인</header>
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
               <button type="button" class="submit" id="admin" onclick="getAdmin()">로그인</button>
            </div>

            <div class="bottom">
               
            </div>          
            <div style="display:flex;justify-content:space-around;">
            <a href="#">홈으로 돌아가기</a>
        </div>
            
           

         </div>
        </div>

       

    </div>

    
    </body>
</html>