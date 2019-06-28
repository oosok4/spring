<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/views/common/basicLib.jsp"%>





<c:forEach items="${data.userList }" var="user" varStatus="status">
	<tr class="userTr" data-userid="${user.userId } data-name=">
		<td class="userId">${user.userId }</td>
		<td>${user.name }</td>
		<td>${user.alias }</td>
		<td></td>
	</tr>
</c:forEach>


SEPERATORSEPERATOR






<!-- 사용자수 : 105건 이것부터 만들어보자.
		페이지네이션 : 11건
		일반적으로 페이징네이션을 할때는 쿼리를 두개쓴다.
	 -->
<div class="text-center">
	<ul class="pagination">
		<%PageVo pageVo = (PageVo) request.getAttribute("pageVo");%>

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
					href="javascript:userPagingListAjaxHtml(${pageVo.page-1},${pageVo.pageSize })">«</a></li>
			</c:otherwise>

		</c:choose>


		
										

		<c:forEach begin="1" end="${data.paginationSize }" var="i">
			<c:choose>
				<c:when test="${pageVo.page == i }">
					<li class="active"><span> ${i }</span></li>
				</c:when>
				<c:otherwise>
					<li><a
						href="javascript:userPagingListAjaxHtml(${pageVo.page-1},${pageVo.pageSize })">${i }</a></li>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		
		<c:choose>
			<c:when test="${pageVo.page == paginationSize }">
				<li class="disabled"><span>»</span></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="javascript:userPagingListAjaxHtml(${pageVo.page-1},${pageVo.pageSize })">»</a></li>
			</c:otherwise>

		</c:choose>

	</ul>



</div>
</div>
</div>
</div>
<!-- /.blog-main -->
</div>