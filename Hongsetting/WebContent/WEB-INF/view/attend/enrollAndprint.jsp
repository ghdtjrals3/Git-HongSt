<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
    
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="
    height: 500px;
    width: 360px;">
    
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">출석하기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
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
        <button type="button" class="btn btn-success" onclick="sensorStart('1')">출석하기</button>
      <button type="button" class="btn btn-block" onclick="inputName()"style="width: auto;" >지문등록</button>
        <!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button> -->
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
document.querySelector(".close").addEventListener("click", function () {
	let mod = document.querySelector("#modal");
	mod.style.display = "none";
})

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
    	  }
      }
    })
    return result;
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
</script>