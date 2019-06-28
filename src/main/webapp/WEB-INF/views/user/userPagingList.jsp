<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.userTr:hover {
	cursor: pointer;
}
</style>


<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script>
	$(document).ready(function() {
		$(".userTr").on("click", function() {
			console.log("userTr click");

			var userId = $(this).find(".userId").text();
			$("#userId").val(userId);

			//#frm을 이용하여 submit();
			$("#frm").submit();

		});

	})
</script>

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="row">
			<div class="col-sm-8 blog-main">


				<h2 class="sub-header">사용자(tiles)</h2>

				<form id="frm" action="${cp }/user/user" method="get">
					<input type="hidden" id="userId" name="userId" />

				</form>


				<div class="table-responsive">
					<table class="table table-striped">
						<tr>
							<th>사용자 아이디</th>
							<th>사용자 이름</th>
							<th>사용자 별명</th>
							<th>등록일시</th>
						</tr>

						<c:forEach items="${userList }" var="user" varStatus="status">
							<tr class="userTr" data-userid="${user.userId } data-name=">
								<td class="userId">${user.userId }</td>
								<td>${user.name }</td>
								<td>${user.alias }</td>
								<td></td>
							</tr>
						</c:forEach>


					</table>
				</div>

				<a href="${cp }/user/form" class="btn btn-default pull-right">사용자
					등록</a><br> <br> <a href="${cp}/user/userListExcel"
					class="btn btn-default pull-right">엑셀다운</a>


				<!-- 사용자수 : 105건 이것부터 만들어보자.
		페이지네이션 : 11건
		일반적으로 페이징네이션을 할때는 쿼리를 두개쓴다.
	 -->
				<div class="text-center">
					<ul class="pagination">
						<%
											PageVo pageVo = (PageVo) request.getAttribute("pageVo");
										%>

						<!--  
										<%if (pageVo.getPage() == 1) {%>
										<li class="disabled"><span>«</span></li>
										<%} else {%>
										<li><a
											href="${cp}/userPagingList?page=<%=pageVo.getPage() - 1%>&pageSize=<%=pageVo.getPageSize()%>">«</a>
										</li>
										<%}%>
										-->
						<c:choose>
							<c:when test="${pageVo.page == 1 }">
								<li class="disabled"><span>«</span></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="${cp}/user/pagingList?page=${pageVo.page - 1}&pageSize=${pageVo.pageSize } ">«</a></li>
							</c:otherwise>

						</c:choose>


						<!--  
										<%//내가 현재 몇번쨰 페이지에 있는가?

			//PageVo pageVo  = (PageVo)request.getAttribute("pageVo");
			int paginationSize = (Integer) request
					.getAttribute("paginationSize");
			for (int i = 1; i <= paginationSize; i++) {%>
										<%if (pageVo.getPage() == i) {%>
										<li class="active"><span> <%=i%></span></li>
										<%} else {%>
										<li><a
											href="${cp}/userPagingList?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i%></a>
										</li>
										<%}
			}%>
										-->

						<c:forEach begin="1" end="${paginationSize }" var="i">
							<c:choose>
								<c:when test="${pageVo.page == i }">
									<li class="active"><span> ${i }</span></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${cp }/user/pagingList?page=${i }&pageSize=${pageVo.pageSize }">${i }</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<!-- 
										<%if (pageVo.getPage() == pageVo.getPageSize() + 1) {%>
										<li class="disabled"><span>»</span></li>
										<%} else {%>
										<li>
										<a href="${cp}/userPagingList?page=<%=paginationSize + 1%>&pageSize=<%=paginationSize%>">»</a>
										</li>
										<%}%>
										-->
						<c:choose>
							<c:when test="${pageVo.page == paginationSize }">
								<li class="disabled"><span>»</span></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="${cp}/user/pagingList?page=${pageVo.page + 1}&pageSize=${pageVo.pageSize }">»</a></li>
							</c:otherwise>

						</c:choose>

					</ul>



				</div>
			</div>
		</div>
	</div>
	<!-- /.blog-main -->
</div>