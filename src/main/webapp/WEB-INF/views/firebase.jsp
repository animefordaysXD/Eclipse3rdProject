<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>

 <script src="https://www.gstatic.com/firebasejs/9.6.1/firebase-app-compat.js"></script>
<script src="https://www.gstatic.com/firebasejs/9.6.1/firebase-auth-compat.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
const firebaseConfig = {
        apiKey: "AIzaSyB0jeVJQlz7j94f_f0AllsmP_zTHOGsJ3g",
        authDomain: "project-3-430a2.firebaseapp.com",
        projectId: "project-3-430a2",
        storageBucket: "project-3-430a2.appspot.com",
        messagingSenderId: "12523153686",
        appId: "1:12523153686:web:3f434bc11436491c2d0837"
      };
      // Initialize Firebase
      firebase.initializeApp(firebaseConfig);
      const auth = firebase.auth();
      
      firebase.auth().onAuthStateChanged((user) => {
    	  if (user) {
    	    // User is signed in
    	    console.log("User signed in:", user);
    	  } else {
    	    // User is signed out
    	    console.log("No user is signed in.");
    	  }
    	});
      
</script>
<body>

</body>
</html>