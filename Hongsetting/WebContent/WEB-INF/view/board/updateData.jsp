<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = CmmUtil.nvl((String) session.getAttribute("name")); 
String qst_seq = CmmUtil.nvl((String)request.getParameter("qst_seq"));
String id = CmmUtil.nvl((String) session.getAttribute("id")); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- HTML5 Shim and Respond.js IE9 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="CodedThemes">
<meta name="keywords" content=" Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
<meta name="author" content="CodedThemes">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--데이터 테이블 -->
    <script src="/resource/assets/js/jquery/jquery-3.6.0.min.js"></script>
    <script src="/resource/assets/js/datatables/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" href="/resource/assets/css/datatables/jquery.dataTables.min.css">
    <title>Document</title>
<title>Insert title here</title>
</head>
<body>
	<!-- Pre-loader start -->
	<div class="theme-loader">
		<div class="ball-scale">
			<div class='contain'>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">

					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
				<div class="ring">
					<div class="frame"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<nav class="navbar header-navbar pcoded-header">
			<div class="navbar-wrapper">

				<div class="navbar-logo" style="background-color:white;">
					<a class="mobile-search morphsearch-search" href="#"> <i
						class="ti-search"></i>
					</a> <a href="/calendar/mainPage.do"> <img class="img-fluid"
						src="/resource/assets/images/poly.png" alt="Theme-Logo" />
					</a> <a class="mobile-options"> <i class="ti-more"></i>
					</a>
				</div>

				<div class="navbar-container container-fluid">
					<ul class="nav-left">
						<li>
							<div class="sidebar_toggle">
								<a href="javascript:void(0)"><i class="ti-menu"></i></a>
							</div>
						</li>

						<li><a href="#!" onclick="javascript:toggleFullScreen()">
								<i class="ti-fullscreen"></i>
						</a></li>
					</ul>
					<ul class="nav-right">
						<li class="user-profile header-notification">
						<%@ include file="/WEB-INF/view/common/top.jsp"%>
						</li>
					</ul>
				</div>
			</div>
			</nav>
			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<nav class="pcoded-navbar">
					<div class="sidebar_toggle">
						<a href="#"><i class="icon-close icons"></i></a>
					</div>
					<div class="pcoded-inner-navbar main-menu">
						<div>
							<div class="main-menu-content">
								<ul>
									<li class="more-details">
                                    	<a href="auth-normal-sign-in.html"><i class="ti-layout-sidebar-left"></i>Logout</a>
                                    </li>
								</ul>
							</div>
						</div>
						<div class="pcoded-navigatio-lavel"
							data-i18n="nav.category.navigation" style="width: 270px;">메뉴</div>
						<ul class="pcoded-item pcoded-left-item" style="width:270px;">
                                <li class="pcoded-hasmenu">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="ti-calendar"></i></span>
                                        <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">캘린더</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                        <li class=" ">
                                            <a href="/calendar/insertSchedulePage.do">
                                                <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                                <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">일정넣기</span>
                                                <span class="pcoded-mcaret"></span>
                                            </a>
                                        </li>
                                        <li class=" ">
                                            <a href="/calendar/insertInterviewPage.do">
                                                <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                                <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">면담신청</span>
                                                <span class="pcoded-mcaret"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="pcoded-hasmenu">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="ti-hand-point-up"></i></span>
                                        <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">지문</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                        <li class=" ">
                                            <a href="/fingerprint/getFingerPrintPage.do?id=<%=id%>">
                                                <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                                <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">지문관리</span>
                                                <span class="pcoded-mcaret"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="active">
                                    <a href="/chatbot/getChatbotPage.do">
                                        <span class="pcoded-micon"><i class="ti-tablet"></i></span>
                                        <span class="pcoded-mtext" data-i18n="nav.dash.main" >챗봇시작하기</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="/board/getBoardPage.do">
                                        <span class="pcoded-micon"><i class="ti-comment"></i></span>
                                        <span class="pcoded-mtext" data-i18n="nav.dash.main" >코딩게시판</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                </li>
                            </ul>
					</nav>
					<div class="pcoded-content">
						<div class="pcoded-inner-content">
							<div class="main-body">
								<div class="page-wrapper">

									<!--페이지 헤더 시작 -->
									<div class="page-header card">
										<div class="row align-items-end">
											<div class="col-lg-8">
												<div class="page-header-title">
													<i class="icofont icofont-comment bg-c-yellow"></i>
													<div style="align-self: center;">
														<h4>코딩게시판 > 글쓰기 > 수정하기</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--페이지 헤더 끝 -->

									<div class="page-body">
										<div class="card">
											<div class="card-block">
												<h4 class="sub-title">수정</h4>

												<form action="/board/updateBoard.do">
													<div class="form-group row">
														<label class="col-sm-2 col-form-label"> 작성자 </label>
														<div class="col-sm-10">
															<input type="text" placeholder="작성자" class="form-control" name="reg_name" value="" id="reg_name" style="width: 200px;">
														</div>
													</div>


													<div class="form-group row">
														<label class="col-sm-2 col-form-label"> 제목 </label>
														<div class="col-sm-10">
															<input type="text" placeholder="수정할 제목" class="form-control" name="title">
														</div>
													</div>

													<div class="form-group row">
														<label class="col-sm-2 col-form-label">내용</label>
														<div class="col-sm-10">
															<textarea rows="5" cols="5" class="form-control"
																placeholder="수정할 질문 내용" name="content"></textarea>
														</div>
													</div>
													<div>
														<input type="text" name="qst_seq" value="<%=qst_seq%>" style="display: none;">
													</div>
													<input type="submit" class="btn btn-primary waves-effect waves-light" value="등록" style="float:right;">
												</form>

											</div>
										</div>
									</div>
								</div>
							</div>
							<!--게시판 시작 -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<!-- Warning Section Starts -->
	<!-- Older IE warning message -->
	<!--[if lt IE 9]>
<div class="ie-warning">
    <h1>Warning!!</h1>
    <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
    <div class="iew-container">
        <ul class="iew-download">
            <li>
                <a href="http://www.google.com/chrome/">
                    <img src="assets/images/browser/chrome.png" alt="Chrome">
                    <div>Chrome</div>
                </a>
            </li>
            <li>
                <a href="https://www.mozilla.org/en-US/firefox/new/">
                    <img src="assets/images/browser/firefox.png" alt="Firefox">
                    <div>Firefox</div>
                </a>
            </li>
            <li>
                <a href="http://www.opera.com">
                    <img src="assets/images/browser/opera.png" alt="Opera">
                    <div>Opera</div>
                </a>
            </li>
            <li>
                <a href="https://www.apple.com/safari/">
                    <img src="assets/images/browser/safari.png" alt="Safari">
                    <div>Safari</div>
                </a>
            </li>
            <li>
                <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                    <img src="assets/images/browser/ie.png" alt="">
                    <div>IE (9 & above)</div>
                </a>
            </li>
        </ul>
    </div>
    <p>Sorry for the inconvenience!</p>
</div>
<![endif]-->
	<!-- Warning Section Ends -->
	<!-- Required Jquery -->
	<!-- <script type="text/javascript" src="/resource/assets/js/jquery/jquery.min.js"></script> -->
	<script type="text/javascript"
		src="/resource/assets/js/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="/resource/assets/js/popper.js/popper.min.js"></script>
	<script type="text/javascript"
		src="/resource/assets/js/bootstrap/js/bootstrap.min.js"></script>
	<!-- jquery slimscroll js -->
	<script type="text/javascript"
		src="/resource/assets/js/jquery-slimscroll/jquery.slimscroll.js"></script>
	<!-- modernizr js -->
	<script type="text/javascript"
		src="/resource/assets/js/modernizr/modernizr.js"></script>
	<!-- am chart -->
	<script src="/resource/assets/pages/widget/amchart/amcharts.min.js"></script>
	<script src="/resource/assets/pages/widget/amchart/serial.min.js"></script>
	<!-- Todo js -->
	<script type="text/javascript "
		src="/resource/assets/pages/todo/todo.js "></script>
	<!-- Custom js -->
	<script type="text/javascript"
		src="/resource/assets/pages/dashboard/custom-dashboard.js"></script>
	<script type="text/javascript" src="/resource/assets/js/script.js"></script>
	<script type="text/javascript "
		src="/resource/assets/js/SmoothScroll.js"></script>
	<script src="/resource/assets/js/pcoded.min.js"></script>
	<script src="/resource/assets/js/demo-12.js"></script>
	<script src="/resource/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script>
var $window = $(window);
var nav = $('.fixed-button');
    $window.scroll(function(){
        if ($window.scrollTop() >= 200) {
         nav.addClass('active');
     }
     else {
         nav.removeClass('active');
     }
 });
</script>

<script>
	 $(document).ready( function () {
	     $('#myTable').DataTable();
	 } );
</script>
<script type="text/javascript">
<%
if(!name.equals("")) { 
%>	

	document.getElementById('reg_name').value = '<%=name%>';
	console.log("name : " + '<%=name%>');
	console.log("reg_name : " + document.getElementById('reg_name').value);
	$("#reg_name").attr("readonly",true);
	
<%	
} else { 
%>
	console.log("im else");
	console.log("name : " + '<%=name%>');
	console.log("reg_name : " + document.getElementById('reg_name').value);
<%
}
%>
</script>
</body>
</html>