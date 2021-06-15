<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel='stylesheet'  href='vendor/css/fullcalendar.min.css'  />  
<script src='vendor/js/jquery.min.js'></script>  <script src='vendor/js/moment.min.js'></script>  
<script src='vendor/js/fullcalendar.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div  id="calendar"> </div>


<script>
$(function () {
// page is now ready, initialize the calendar...
	$('#calendar').fullCalendar({
		// put your options and callbacks here
	})
});

</script>
</body>
</html>