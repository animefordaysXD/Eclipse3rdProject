<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="firebase.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
async function sendPasswordResetEmail() {
	  const auth = firebase.auth();
	  const email = document.getElementById('email').value;

	  try {
	    await auth.sendPasswordResetEmail(email);
	    alert('Password reset email sent.');
	    window.location.href="login.do";
	  } catch (error) {
	    console.error('Error sending password reset email:', error);
	    alert('Error: ' + error.message);
	  }
	}
</script>
<style type="text/css">

body{
    background-image: url("resources/images/basketball.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    background-attachment: fixed;
}
.login-box {
    background-color: rgba(10, 10, 10, 0.3);
    border-radius: 10px;
    padding: 20px;
    width: 400px;
    margin: auto;
}

.input-field{
    display: flex;
    flex-direction: column;

}
.input{
    height: 45px;
    width: 87%;
    border: none;
    outline: none;
    border-radius: 30px;
    color: #fff;
    padding: 0 0 0 42px;
    background: rgba(255, 255, 255, 0.1);
}
button:hover{
cursor: pointer;
background-color: rgba(255,255,255,0.3);
}

</style>
</head>
<body>
<div class="space" style="padding-bottom: 500px">
</div>
<div class="login-box">
<p style=" color:#fff; font-size: 20px;display:  flex;justify-content: center;">이메일을 입력해주세요</p>
<div class="input-field">
<input type="text" class="input" id="email">
<div style="display:flex;justify-content: center;">
<button type="button" style="width:100px;background-color:rgba(255,255,255,0.7);color:black; border: none;" onclick="sendPasswordResetEmail()">확인</button>
</div>
</div>



</div>

</body>
</html>