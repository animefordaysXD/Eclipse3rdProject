<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="resources/css/login.css" rel="stylesheet">
    </head>
    
    
    <body>
    <div class="box">
        <div class="login-box">
        <div class="container">
            <div class="top=header">
                <span>계정이 있습니까?</span>
                <header>로그인</header>
            </div>
           
            <div class="input-field" id="id">
                <input type="text" class="input" placeholder="유저네임" required>
            </div>
            <div class="space"></div>
            <div class="input-field" id="pwd">
                <input type="password" class="input" placeholder="비밀번호" required>
            </div>
            <div class="space"></div>
            <div class="input-field">
               <button class="submit">로그인</button>
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
            <button class="etcbutton1"></button>
            <button class="etcbutton2"></button>
            <button class="etcbutton3"></button>
            <button class="etcbutton4"></button>
        </div>

    </div>

    
    </body>
</html>