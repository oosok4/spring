<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
			<a class="navbar-brand" href="#">JSP/SPRING.
			<!--사용자가 정상적으로 로그인 했을 경우 : USER_INFO에 있는 name 속성 출력
				사용자가 로그인하지 않고 메인화면으로 직접 접속 했을 경우
				(localhost/jsp/main.jsp) [접속하지 않은 사용자입니다 표현]  -->
				<c:set var="userName" value="${USER_INFO.name }"/>
					<c:if test="${USER_INFO.name == null }">
						<c:set var="userName" value="[접속하지 않은 사용자입니다]"/>
					</c:if>
					${userName }
			</a>
			
			<% UserVo SESSION_USER = (UserVo)session.getAttribute("USER_INFO"); 
				String userName = "";
				if(SESSION_USER == null)
					userName = "접속 전입니다";
				else
					userName = SESSION_USER.getName();
			%>
			
			<%=userName %> <sbr>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="${cp}/login">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>