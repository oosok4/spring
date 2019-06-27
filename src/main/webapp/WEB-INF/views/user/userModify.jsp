<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">



<title>사용자 등록</title>


<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
	$("#userId").text();
	$("#name").text();
	$("#alias").text();
	$("#addr1").text();
	$("#addr2").text();
		
		var msg = '${msg}';
		if(msg != '')
				alert(msg);
		
		$("#btnaddr").on("click",function(){
			
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
				//주소 input에다가 value 설정 console.log(data.roadAddress);
				//우편번호에 input value에 설정 data.zonecode
	
				console.log(data.roadAddress);
				console.log(data.zonecode);
				$("#addr1").val(data.roadAddress);
				$("#zipcd").val(data.zonecode);
			}
		}).open();
		});
		
		
		$("#userRegBtn").on("click",function(){
			//유효성 체크
			if($("#userId").val().trim().length == 0){
	    		alert("아이디를 입력해주세요.");
	    		$("#userId").val('');
	    		$("#userId").focus();
	    		return;
	    	}
	    	if($("#pass").val().trim().length == 0){
	    		alert("비밀번호를 입력해주세요.");
	    		$("#pass").val('');
	    		$("#pass").focus();
	    		return;
	    	}
	    	if($("#name").val().trim().length == 0){
	    		alert("이름을 입력해주세요.");
	    		$("#name").val('');
	    		$("#name").focus();
	    		return;
	    	}
	    	if($("#alias").val().trim().length == 0){
	    		alert("별명을 입력해주세요.");
	    		$("#alias").val('');
	    		$("#alias").focus();
	    		return;
	    	}
	    	if($("#birth").val().trim().length == 0){
	    		alert("생일을 입력해주세요.");
	    		$("#birth").val('');
	    		$("#birth").focus();
	    		return;
	    	}
	    	if($("#zipcd").val().trim().length == 0){
	    		alert("주소를 입력해주세요.");
	    		return;
	    	}
	    	if($("#addr2").val().trim().length == 0){
	    		alert("상세주소를 입력해주세요.");
	    		$("#addr2").val('');
	    		$("#addr2").focus();
	    		return;
	    	}
			//여기까지 도달하면 유효성 검사 완료(submit)
			$("#frm").submit();
		});
		
		
		
		
		
		//개발용 데이타 초기화 함수 - 추후 지울것
		//dataInit();
		
	});
	
	function dataInit(){
		
		$("#name").val("대덕인");
		$("#alias").val("마이노");
		$("#addr1").val("용계동 73-22");
		$("#addr2").val("영민빌딩 720호");
		$("#zipcd").val("34940");
		$("#birth").val("2019-05-31");
		$("#pass").val("userTest1234");
	}
	
	
		
		

</script>
</head>

<body>


	<!--  header -->
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<!-- 				left -->
			<%@include file="/WEB-INF/views/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="row">
							<div class="col-sm-8 blog-main">
								<h2 class="sub-header">회원정보 수정</h2>

								<form id="frm" class="form-horizontal" role="form" action="${cp }/user/modify"
								 method="post" enctype="multipart/form-data">

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">사용자
											아이디</label>
										<div class="col-sm-8">
											<input type="file" id="filename" name="profile" />
										</div>
									</div>

									<div class="form-group">
										<label for="userId" class="col-sm-3 control-label">사용자아이디</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="userId"
												name="userId" placeholder="사용자 아이디" value="${userVo.userId }" readonly/>
										</div>
									</div>

<!-- 									<div class="form-group"> -->
<!-- 										<label for="userNm" class="col-sm-3 control-label">비밀번호</label> -->
<!-- 										<div class="col-sm-9"> -->
<!-- 											<input type="password" class="form-control" id="pass" name="pass" -->
<%-- 												placeholder="사용자 비밀번호" value="${userVo.pass }"> --%>
<!-- 										</div> -->
<!-- 									</div> -->

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">사용자
											이름</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name"
												placeholder="사용자 이름" value="${userVo.name }">
										</div>
									</div>

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">별명</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="alias"
												name="alias" placeholder="사용자 별명" value="${userVo.alias }">
										</div>
									</div>

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">주소</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="addr1"
												name="addr1" placeholder="사용자 주소" readonly value="${userVo.addr1 }">
										</div>
										<div class="col-sm-3">
											<button id="btnaddr" type="button" class="btn btn-default">주소 검색</button>
										</div>
									</div>

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">상세주소</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="addr2"
												name="addr2" placeholder="사용자 상세주소" value="${userVo.addr2 }">
										</div>
									</div>

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">우편번호</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="zipcd"
												name="zipcd" placeholder="사용자 우편번호" readonly value="${userVo.zipcd }">
										</div>
									</div>

									<div class="form-group">
										<label for="userNm" class="col-sm-3 control-label">생일</label>
										<div class="col-sm-9">
											<input type="date" class="form-control" id="birth" value="<fmt:formatDate value="${user.birth}" pattern="yyyy-MM-dd"/>"
												name="birth" placeholder="사용자 생일">
										</div>
									</div>


									<br><br><br><br>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button id="userRegBtn" type="submit" class="btn btn-default">수정 완료</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
