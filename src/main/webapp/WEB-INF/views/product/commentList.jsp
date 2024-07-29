<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<table class="table">
	<thead>
		<tr>
			<th>Comment</th>
		</tr>
	</thead>

	<tbody class="table-group-divider">
		<c:forEach items="${list}" var="comment">
			<tr>
				<th>${comment.boardWriter}</th>
				<td>${comment.boardContents}</td>
				<td>${comment.createDate}</td>
				<td>
					<c:if test="${comment.boardWriter eq member.member_id}">
						<button type="button" class="btn btn-danger delBtn"
						data-del-id="${comment.boardNum}">X</button>
					</c:if>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>


<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item ${pager.pre?'':'disabled'}">
		<a class="page-link pn" data-page-num="${pager.startNum-1}" href="#">Previous</a>
		</li>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
			var="i">
			<li class="page-item">
			<a class="page-link pn" data-page-num="${i}" href="#">${i}</a></li>
		</c:forEach>
		<li class="page-item ${pager.next?'':'disabled'}">
		<a class="page-link pn" data-page-num="${pager.lastNum+1}" href="#">Next</a>
		</li>
	</ul>
</nav>