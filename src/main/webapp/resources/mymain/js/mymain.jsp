<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<script type="text/javascript">

function slidesPlugin(activeSlide = 2) {
	  const slides = document.querySelectorAll(".slide");

	  slides[activeSlide].classList.add("active");

	  for (const slide of slides) {
	    slide.addEventListener("click", () => {
	      clearActiveClasses();

	      slide.classList.add("active");
	    });
	  }

	  function clearActiveClasses() {
	    slides.forEach((slide) => {
	      slide.classList.remove("active");
	    });
	  }
	}

	slidesPlugin();
</script>
</body>
</html>