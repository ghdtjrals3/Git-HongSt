<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String topname = CmmUtil.nvl((String) session.getAttribute("name")); 
%>   


<%
if(!topname.equals("")) {	
%>
<li class="user-profile header-notification profile-custom">
	<a href="#!">
		<span><%=topname.substring(1,3)%></span>
		<i class="ti-angle-down"></i>
	</a>
	<ul class="show-notification profile-notification">
	    <li>
	        <a href="http://localhost:8080/fingerPrint/logout.do">
	            <i class="ti-layout-sidebar-left"></i> Logout
	        </a>
	    </li>
	</ul>
<%
} else {
%>
	<a href="#!">
		<span>로그인이 되어 있지 않습니다.</span>
	</a>
<%
}
%>
</li>
<style>
.profile-custom::before {
    content: '';
    background-color: #e62121;
    width: 50px;
    height: 50px;
    position: absolute;
    z-index: -1;
    top: 15px;
    border-radius: 50%;
}
.profile-custom a span {
	color : #FFF;
 }
</style>
