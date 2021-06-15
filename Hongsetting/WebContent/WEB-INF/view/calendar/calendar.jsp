<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='/resource/lib/main.css' rel='stylesheet' />
<script src='/resource/lib/main.js'></script>
<script src="https://apis.google.com/js/api.js"></script>
<script type='text/javascript'>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			googleCalendarApiKey : 'AIzaSyAWhMhr6l-Whjq1VW9hi5yzHOASFZCGWDI',
			eventSources : [ {
				googleCalendarId : 'ghdtjrals3@gmail.com',
				className : '홍석민',
				color : '#edd609' //rgb,#ffffff 등의 형식으로 할 수 있어요.
			//textColor: 'black' 
			} ],
			eventClick: function(info) {
				info.jsEvent.stopPropagation();
				info.jsEvent.preventDefault();
			}
		});
		calendar.render();
	});
</script>
<script>
var calendarEl = document.getElementById('calendar');
var calendar = new FullCalendar.Calendar(calendarEl, {
	  events: [
	    {
	      title: 'BCH237',
	      start: '2021-06-01T10:30:00',
	      end: '2021-06-01T11:30:00',
	      extendedProps: {
	        department: 'BioChemistry'
	      },
	      description: 'Lecture'
	    }
	    // more events ...
	  ],
	  eventDidMount: function(info) {
	    console.log(info.event.extendedProps);
	    // {description: "Lecture", department: "BioChemistry"}
	  }

	});
</script>

<style>
#calendar {
	width: 60%;
	margin: 20px auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div style="max-width:2000px; max-height: 1800px">
	<div id='calendar'></div>
</div>

</body>
</html>