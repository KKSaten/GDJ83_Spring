<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<div class="container col-md-6 mt-4 justify-content-center">

		<div class="d-grid gap-2 d-md-flex mb-3 justify-content-md-end">

			<div class="btn-group" role="group"
				aria-label="Button group with nested dropdown">
				
				<button type="submit" class="btn btn-light"
					onclick="location.href ='list?bank_id=${param.bank_id}' ">입출금내역</button>
				<button type="submit" class="btn btn-light"
					onclick="location.href ='list?bank_id=${param.bank_id}&io=1' ">출금내역</button>
				<button type="submit" class="btn btn-light"
					onclick="location.href ='list?bank_id=${param.bank_id}&io=0' ">입금내역</button>
			</div>
			
			<div class="btn-group" role="group"
				aria-label="Button group with nested dropdown">

				<button type="submit" class="btn btn-light"
					onclick="location.href ='list?bank_id=${param.bank_id}&order=0' ">최신순</button>
				<button type="submit" class="btn btn-light"
					onclick="location.href ='list?bank_id=${param.bank_id}&order=1' ">오래된순</button>
			</div>

		</div>


		<table class="table">
			<thead>
				<tr>
					<th>시간</th>
					<th>사용 내역</th>
					<th>입출금</th>
					<th>잔액</th>
				</tr>
			</thead>

			<tbody class="table-group-divider">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.timepoint}</td>
						<td>${dto.account_u}</td>

						<td class="${dto.difference>0?'text-primary':'text-danger'}">
							<c:choose>
								<c:when test="${dto.difference>0}">+${dto.difference}</c:when>
								<c:otherwise>${dto.difference}</c:otherwise>
							</c:choose>
						</td>

						<td>${dto.bal_result}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>


	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>