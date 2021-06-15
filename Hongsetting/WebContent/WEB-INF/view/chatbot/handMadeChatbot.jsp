<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	type="text/css" rel="stylesheet">
<style type="text/css">
.container_bot {
	max-width: 1170px;
	margin: auto;
}

.img_bot {
	max-width: 100%;
}

.inbox_people_bot {
	background: #f8f8f8 none repeat scroll 0 0;
	float: left;
	overflow: hidden;
	width: 40%;
	border-right: 1px solid #c4c4c4;
}

.inbox_msg_bot {
	clear: both;
	overflow: hidden;
}

.top_spac_bot {
	margin: 20px 0 0;
}

.recent_heading_bot {
	float: left;
	width: 40%;
}

.srch_bar_bot {
	display: inline-block;
	text-align: right;
	width: 60%;
}

.headind_srch_bot {
	padding: 10px 29px 10px 20px;
	overflow: hidden;
	border-bottom: 1px solid #c4c4c4;
}

.recent_heading_bot h4 {
	color: #05728f;
	font-size: 21px;
	margin: auto;
}

.srch_bar_bot input {
	border: 1px solid #cdcdcd;
	border-width: 0 0 1px 0;
	width: 80%;
	padding: 2px 0 4px 6px;
	background: none;
}

.srch_bar_bot .input-group-addon button {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	padding: 0;
	color: #707070;
	font-size: 18px;
}

.srch_bar_bot .input-group-addon {
	margin: 0 0 0 -27px;
}

.chat_ib_bot h5 {
	font-size: 15px;
	color: #464646;
	margin: 0 0 8px 0;
}

.chat_ib_bot h5 span {
	font-size: 13px;
	float: right;
}

.chat_ib_bot p {
	font-size: 14px;
	color: #989898;
	margin: auto
}

.chat_img_bot {
	float: left;
	width: 11%;
}

.chat_ib_bot {
	float: left;
	padding: 0 0 0 15px;
	width: 88%;
}

.chat_people_bot {
	overflow: hidden;
	clear: both;
}

.chat_list_bot {
	border-bottom: 1px solid #c4c4c4;
	margin: 0;
	padding: 18px 16px 10px;
}

.inbox_chat_bot {
	height: 550px;
	overflow-y: scroll;
}

.active_chat_bot {
	background: #ebebeb;
}

.incoming_msg_img_bot {
	display: inline-block;
	width: 6%;
}

.received_msg_bot {
	display: inline-block;
	padding: 0 0 0 10px;
	vertical-align: top;
	width: 92%;
}

.received_withd_msg_bot p {
	background: #ebebeb none repeat scroll 0 0;
	border-radius: 3px;
	color: #646464;
	font-size: 14px;
	margin: 0;
	padding: 5px 10px 5px 12px;
	width: 100%;
}

.time_date_bot {
	color: #747474;
	display: block;
	font-size: 12px;
	margin: 8px 0 0;
}

.received_withd_msg_bot {
	width: 57%;
}

.mesgs_bot {
	float: left;
	padding: 30px 15px 0 25px;
}

.sent_msg_bot p {
	background: #05728f none repeat scroll 0 0;
	border-radius: 3px;
	font-size: 14px;
	margin: 0;
	color: #fff;
	padding: 5px 10px 5px 12px;
	width: 100%;
}

.outgoing_msg_bot {
	overflow: hidden;
	margin: 26px 0 26px;
}

.sent_msg_bot {
	float: right;
	width: 46%;
}

.input_msg_write_bot input {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	color: #4c4c4c;
	font-size: 15px;
	min-height: 48px;
	width: 100%;
}

.type_msg_bot {
	border-top: 1px solid #c4c4c4;
	position: relative;
}

.msg_send_btn_bot {
	background: #05728f none repeat scroll 0 0;
	border: medium none;
	border-radius: 50%;
	color: #fff;
	cursor: pointer;
	font-size: 17px;
	height: 33px;
	position: absolute;
	right: 0;
	top: 11px;
	width: 33px;
}

.messaging_bot {
	padding: 50px 0;
}

.msg_history_bot {
	height: 516px;
	overflow-y: auto;
}
</style>
</head>
<body>
	<div class="container_bot">
		<div class="messaging_bot">
			<div class="inbox_msg_bot">
				<div class="mesgs_bot">
					<div class="msg_history_bot">
						<div class="incoming_msg_bot">
							<div class="incoming_msg_img_bot">
								<img class="img_bot" src="https://ptetutorials.com/images/user-profile.png" alt="sunil">
							</div>
							<div class="received_msg_bot">
								<div class="received_withd_msg_bot">
									<p style="margin-bottom: 5px; width: 491px;">안녕하세요. 무엇을 도와드릴까요??</p>
									<button class="btn btn-info btn-round btn-sm waves-effect" onclick="haksik();" >학식</button>
									<button class="btn btn-info btn-round btn-sm waves-effect" onclick="siganpyo();">시간표</button>
									<button class="btn btn-info btn-round btn-sm waves-effect" onclick="haksa();">학사일정</button>
								</div>
							</div>
						</div>
						<div id="chatmsg1">
							</div>
							<div id="chatmsg2">
							</div>
							<div id="chatmsg3">
							</div>
							<div id="chatmsg4">
							</div>
							<div id="chatmsg5">
							</div>
							<div id="chatmsg6">
							</div>
							<div id="chatmsg7">
							</div>
							<div id="chatmsg8">
							</div>
							<div id="chatmsg9">
							
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script>
/* $("#chatmsg1").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p>We work directly with our designers and suppliers, and sell direct to you, which means quality, exclusive products,at a price anyone can afford.</p><span class='time_date_bot'> 11:01 AM | Today</span></div></div></div>")
$("#chatmsg2").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p>Test which is a new approach to have all solutions</p><span class='time_date_bot'> 11:01 AM | June 9</span></div></div>")
 */
</script>

<script>
function haksik() {
	setTimeout(function() {
		$("#chatmsg1").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>학식</p></div></div>");
			setTimeout(function() {
				$("#chatmsg2").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>원하는 요일을 선택해주세요</p><button class='btn btn-info btn-round btn-sm' onclick='haksikFood1();' >월</button><button class='btn btn-info btn-round btn-sm' onclick='haksikFood2();' >화</button><button class='btn btn-info btn-round btn-sm' onclick='haksikFood3();' >수</button><button class='btn btn-info btn-round btn-sm' onclick='haksikFood4();' >목</button><button class='btn btn-info btn-round btn-sm' onclick='haksikFood5();' >금</button></div></div></div>");
			},1000);
	},1000);
}
function haksikFood1(){
	$.ajax({
		url:'http://localhost:8080/chatbot/haksikFood.do?day=월요일',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res);
			setTimeout(function() {
				$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>월요일</p></div></div>");
					setTimeout(function() {
						$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>"+ res + "</p></div></div></div>");	
						$("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
}
function haksikFood2(){
	$.ajax({
		url:'http://localhost:8080/chatbot/haksikFood.do?day=화요일',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res);
			setTimeout(function() {
				$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>화요일</p></div></div>");
					setTimeout(function() {
						$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>"+ res + "</p></div></div></div>");	
						$("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
	
}
function haksikFood3(){
	$.ajax({
		url:'http://localhost:8080/chatbot/haksikFood.do?day=수요일',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res);
			setTimeout(function() {
				$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>수요일</p></div></div>");
					setTimeout(function() {
						$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>"+ res + "</p></div></div></div>");	
						$("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
	
}
function haksikFood4(){
	$.ajax({
		url:'http://localhost:8080/chatbot/haksikFood.do?day=목요일',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res);
			setTimeout(function() {
				$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>목요일</p></div></div>");
					setTimeout(function() {
						$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>"+ res + "</p></div></div></div>");	
						$("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
	
}
function haksikFood5(){
	$.ajax({
		url:'http://localhost:8080/chatbot/haksikFood.do?day=금요일',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res);
			setTimeout(function() {
				$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>금요일</p></div></div>");
					setTimeout(function() {
						$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>"+ res + "</p></div></div></div>");	
						$("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
	
}
function siganpyo() {
	setTimeout(function() {
		$("#chatmsg1").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>시간표</p></div></div>");
			setTimeout(function() {
				$("#chatmsg2").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><p style='width: 491px;'>원하는 학년을 선택해주세요.</p><button class='btn btn-info btn-round btn-sm' onclick='siganpyoImg1();' >1학년</button><button class='btn btn-info btn-round btn-sm' onclick='siganpyoImg2();' >2학년</button></div></div></div>");	
			},1000);
	},1000);
	
}
function siganpyoImg1() { 
	setTimeout(function() {
		$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>1학년</p></div></div>");
			},1000);
	return  setTimeout(function() {$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><img src='/resource/assets/images/siganpyo1.JPG'></div></div></div>"); $("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")},2000);

}
function siganpyoImg2() { 
	setTimeout(function() {
		$("#chatmsg3").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>2학년</p></div></div>");
			},1000);
	return  setTimeout(function() {$("#chatmsg4").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot'><img src='/resource/assets/images/siganpyo2.JPG'></div></div></div>"); $("#chatmsg5").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")},2000);

}


function haksa() { 
	$.ajax({
		url:'http://localhost:8080/chatbot/haksa.do',
		method: 'GET',
		contentType:'application/json; charset=UTF-8',
		success:function(res) { 
			console.log("res : " + res[0]["day"]);
			setTimeout(function() {
				$("#chatmsg1").html("<div class='outgoing_msg_bot'><div class='sent_msg_bot'><p style='width: 491px;'>학사일정</p></div></div>");
					setTimeout(function() {
						$("#chatmsg2").html("<div class='incoming_msg_bot'><div class='incoming_msg_img_bot'><img class='img_bot' src='https://ptetutorials.com/images/user-profile.png' alt='sunil'></div><div class='received_msg_bot'><div class='received_withd_msg_bot' style='width : auto;'><p style='width: 491px;'>"+ res[0]["day"] + " : " + res[0]["iljeong"] + "<br/>" + res[1]["day"] + " : " + res[1]["iljeong"] + "<br/>" + res[2]["day"] + " : " + res[2]["iljeong"] + "<br/>" + res[3]["day"] + " : " + res[3]["iljeong"] + "<br/>" +"</p></div></div></div>");	
						$("#chatmsg3").html("<div style='text-align: center;'><button onclick='window.location.reload()'>돌아가기</button></div>")
					},1000);
			},1000);
		}
	})
}

</script>