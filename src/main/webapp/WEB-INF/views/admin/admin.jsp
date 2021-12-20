<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/admin.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function () {
	$("#main_user").click(function() {
		location.href="#void";
	});//main_user
	$("#main_user1").click(function() {
		location.href="#void";
	});//main_user
	$("#main_job_post").click(function() {
		location.href="#void";
	});//main_user
})//ready

function removeData(id) {
	if (confirm( id + " 회원을 삭제하시겠습니까?")) {
		$("#removeUserid").val( id );
		
		$("#removeFrm").submit();
	}//end if
}//removeData
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/admin_header.jsp"/>
	
<div class="container">
	<div style="padding-top: 50px;">
		<table class="table table-hover" style="width: 1300px;">
			<thead>
				<tr class="title_tr">
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>가입일</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ userList }"> 
						<tr >
							<th><c:out value="${user.id}"/></th>
							<th><c:out value="${user.name}"/></th>
							<th><c:out value="${user.email}"/></th>
							<th><c:out value="${user.input_date}"/></th>
							<th><input type="button" value="삭제" class="btn"  onclick="removeData('${ user.id }')"/></th>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 회원 삭제 -->
		<form name="removeFrm" id="removeFrm" action="#void" method="post">
			<input type="hidden" name="id" id="removeUserid"> 
		</form>
	</div><br/>
</div><!-- container -->	
	
</body>
</html>