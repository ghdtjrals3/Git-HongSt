<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Favicon icon -->
<link rel="icon" href="/resource/assets/images/favicon.ico" type="image/x-icon">
<!-- Google font-->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
<!-- Required Fremwork -->
<link rel="stylesheet" type="text/css" href="/resource/assets/css/bootstrap/css/bootstrap.min.css">
<!-- themify-icons line icon -->
<link rel="stylesheet" type="text/css" href="/resource/assets/icon/themify-icons/themify-icons.css">
<!-- ico font -->
<link rel="stylesheet" type="text/css" href="/resource/assets/icon/icofont/css/icofont.css">
<!-- Style.css -->
<link rel="stylesheet" type="text/css" href="/resource/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="/resource/assets/css/jquery.mCustomScrollbar.css">
<!-- Required Jquery -->
<script type="text/javascript" src="/resource/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/resource/assets/js/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resource/assets/js/popper.js/popper.min.js"></script>
<script type="text/javascript" src="/resource/assets/js/bootstrap/js/bootstrap.min.js"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="/resource/assets/js/jquery-slimscroll/jquery.slimscroll.js"></script>
<!-- modernizr js -->
<script type="text/javascript" src="/resource/assets/js/modernizr/modernizr.js"></script>
<!-- am chart -->
<script src="/resource/assets/pages/widget/amchart/amcharts.min.js"></script>
<script src="/resource/assets/pages/widget/amchart/serial.min.js"></script>
<!-- Todo js -->
<script type="text/javascript " src="/resource/assets/pages/todo/todo.js "></script>
<!-- Custom js -->
<script type="text/javascript" src="/resource/assets/pages/dashboard/custom-dashboard.js"></script>
<script type="text/javascript" src="/resource/assets/js/script.js"></script>
<script type="text/javascript " src="/resource/assets/js/SmoothScroll.js"></script>
<script src="/resource/assets/js/pcoded.min.js"></script>
<script src="/resource/assets/js/demo-12.js"></script>
<script src="/resource/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Modal -->
<div id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="
    position: fixed;
    top: 0;
    left: 0;
    z-index: 9999999999999999;
    background: #33333390;
    width: 100%;
    height: 100%;
    overflow: hidden;
    display: none;
    justify-content: center;
    align-items: center;">
    
  <div class="modal-dialog" role="document" style="max-width: none;">
    <div class="modal-content" style="
    height: 650px;
    width: 1250px;">
    
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">출석하기</h5>
        <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button> -->
      </div>
      <div class="modal-body">
      	<div style="text-align : center";>
	        <img src="/resource/assets/images/LoadingImg.gif" alt="지문" />
	        <h4 id="msg">
		        <p>버튼을 눌러주세요  </p>
		        <p>지문센서에 불이 들어오면  손가락을 올려주세요</p>
	        </h4>
      	</div>
      </div>
      <div class="modal-footer" style="align-self: center;">
        <button type="button" class="btn btn-success" onclick="sensorStart('1')" style="height: 150px;width: 150px;">출석하기</button>
      <button type="button" class="btn btn-block" onclick="inputName()"style="height: 150px;width: 150px;" >지문등록</button>
      <button type="button" class="btn btn-block" style="height: 150px;width: 150px; margin-top:0px" onclick="login('1')" >로그인</button>
      </div>
    </div>
  </div>
</div>






<!-- Modal 등록부분-->
<div id="inputName" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="
    position: fixed;
    top: 0;
    left: 0;
    z-index: 9999999999999999;
    background: #33333390;
    width: 100%;
    height: 127%;
    overflow: hidden;
    display: none;
    justify-content: center;
    align-items: center;">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
      <!-- <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">출석하기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div> -->
      <div class="modal-body">
      	<div style="text-align : center;">
	        학번_이름<input type="text" class="form-control" style="margin-bottom : 10px;" id="name">
	        <button type="button" class="btn btn-success btn-mini" onclick='modalClose()'>확인</button>
      	</div>
      </div>
    </div>
  </div>
</div>
<script>
function modalOpen() {
	let mod = document.querySelector("#modal");
	$("#msg").html("<p>버튼을 눌러주세요  </p><p>지문센서에 불이 들어오면  손가락을 올려주세요</p>")
	mod.style.display = "flex";
}
/* document.querySelector(".close").addEventListener("click", function () {
	let mod = document.querySelector("#modal");
	mod.style.display = "none";
}) */

//enroll 등록
function inputName() {
	let mod = document.querySelector("#inputName");
	mod.style.display = "flex";
}
function modalClose() {
	let mod = document.querySelector("#inputName");
	mod.style.display = "none";
	
	sensorEnroll();
	
}

</script>
<script>
function sensorStart(num) {
    let result = '';
    $.ajax({
      url:'http://192.168.0.121:3000/serialport/'+num,
      method: 'GET',
      async: false,
      success:function(res) {
          result=res;
        /*   if(res==1){
        	  $("#msg").html("<div style='padding-bottom : 10px;'>센서 준비 완료</div><h5 style='color: #4680ff;'>지문센서에 손가락을 올려주세요.</h5>")
          } */
          console.log("result : " + result);  
       	  sensorData(2);
         
          
      }
    })
    return result;
 }
 
function sensorData(num) {
    let result = '';
    $.ajax({
      url:'http://192.168.0.121:3000/serialport/'+num,
      method: 'GET',
      async: false,
      success:function(res) {
    	  result=res;
    	  if(res == 3){
    		  $("#msg").html("<div style='padding-bottom : 10px;'>지문 인식이 실패되었습니다.</div>")
    	  }else{
    		    $("#msg").html("<div style='padding-bottom : 10px;'>지문 인식이 완료되었습니다.</div>")
    	          console.log("result : " + result); 
    		      attend(res);
    	  }
      }
    })
    return result;
 }
 function attend(num) {
	 $.ajax({
	      url:'http://localhost:8080/fingerPrint/attend.do?id=' + num,
	      method: 'GET',
	      async: false,
	      success:function(res) {
	    	  result=res;
	      }
	    })
 }
 
 function sensorEnroll()  {
	 console.log("sensorEnroll Start !!");
	 let name = $('#name').val();
	 if(name=='') { 
		 return false;
	 } else {
		 $.ajax({
			 url:'http://192.168.0.121:3000/sensorEnroll' ,
			 method: 'POST',
			 dataType: 'json',
			 data: {'name':name},
			 /* async: false, */
			 success: function(res) {
				 if(res == 1){
		    		  $("#msg").html("<div style='padding-bottom : 10px;'>지문 등록이 성공되었습니다.</div>")
		    	  }else{
		    		    $("#msg").html("<div style='padding-bottom : 10px;'>지문 등록이 실패되었습니다.</div>")
		    	          console.log("result : " + result);  
		    	  }
			 }
		 })
		 
	 }
	 
 }
 
 modalOpen();
</script>

<script>
function login(num) {
	let result = '';
    $.ajax({
      url:'http://192.168.0.121:3000/login/'+num,
      method: 'GET',
      async: false,
      success:function(res) {
          result=res;
          console.log("result : " + result);  
	      sqlStart(2);
      }
    })
    return result;
}

function sqlStart(num) {
	 let result = '';
	 $.ajax({
	 	url:'http://192.168.0.121:3000/login/'+num,
	 	method: 'GET',
	 	async: false,
	 	success:function(res) {
	    	result=res;
	    	console.log("성공이다.");
	    	console.log("result : " + result);
	    	fianlSql(result);
	      }
	   })
	   return result;
}

function fianlSql(num) {
	 let result = '';
	 $.ajax({
	 	url:'http://192.168.0.121:3000/sqlResult/'+num,
	 	method: 'GET',
	 	success:function(res) {
	    	result=res;
	    	console.log("fianlSql result : " + result);
	    	session(result);
	      },
	    error:function() {
	    	console.log("오류");
	    }
	   })
	   return result;
}


function session(nameId) {
	$.ajax({
		url:'http://localhost:8080/fingerPrint/getSession.do?nameId=' + nameId,
		method: 'GET',
		success:function() { 
			console.log("success");
			$("#msg").html("<div style='padding-bottom : 10px;'><h3>로그인되셨습니다 !!</h3></div>")
		}
	})
}
</script>