<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		console.log("ready");

		//requestData 이벤트 핸들러
		$("#requestData").on("click", function() {

			$.ajax({
				url : "/ajax/requestData",
				method : "POST",
				success : function(data) {
					//
					//console.log(data);
					$("#page").text(data.pageVo.page);
					$("#pageSize").text(data.pageVo.pageSize);
				}
			});

		});
		
		//user 클릭시 이벤트 핸들러
		$("#user").on("click",function(){
			$.ajax({
				url : "/ajax/user",
				method : "post",
				data : "userId=" + $("#userId").val(),
				success : function(data){
					/*	
						name : <input type="text" id="name" readonly /><br>
						alias : <input type="text" id="alias" readonly /><br>
						birth : <input type="text" id="birth" readonly /><br>
					
					*/
// 					$("#name").val(data.userVo.name);
// 					$("#alias").val(data.userVo.alias);
// 					$("#birth").val(data.userVo.birth);

					var html="";
					html += "name : <input type=\"text\" id=\"name\" readonly value=\"" +data.userVo.name+"\"/>";
					html += "alias : <input type=\"text\" id=\"alias\" readonly value=\"" +data.userVo.alias+"\"/>";
					html += "birth : <input type=\"text\" id=\"birth\" readonly value=\"" +data.userVo.birth+"\"/>";
					
					$("#userJsonInfo").html(html);
					
				}
			});
		});
		//userHtml 클래스 이벤트 핸들러
		$("userHtml").on("click",function(){
			$.ajax({
				url:"/ajax/userHtml",
				method : "post",
				data:$("#frm").serialize(),
				success : function(data){
					$("#userInfo").html(data);
				}
			});
		});
		
	});
</script>
<h2>ajax json 데이터 요청</h2>
<a id="requestData">데이타 가져오기</a><br><br>
page :
<span id="page"></span>
<br>
pageSie :
<span id="pageSize"></span>
<br>
<h2>ajax json데이터 요청(user)</h2>
userId : <input type="text" id="userId" value="brown" /><br>
<div id ="userJsonInfo"></div>


<a id="user">데이터 가져오기</a><br>
<div id="userHtml"></div>
<form id="frm">
	userId : <input type="text" id="userIdHtml" name="userId" value="brown" /><br>
</form>
