<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 로그인</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/admin_login.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#login").click(function() {
		if ($("#id").val() == "") {
			$("#sign_in_fail").html("아이디를 입력해주세요.");
			
			$("#id").focus();
			
			return;
		}
		
		if ($("#password").val() == "") {
			$("#sign_in_fail").html("비밀번호를 입력해주세요.");
			$("#password").focus();
			
			return;
		}
		
		$("#login_form").submit();
	});	
});
</script>
</head>
<body>
	<div class="container">
      <form class="form-signin" action="http://localhost/third_prj/admin/admin_login_process.do" id="login_form" method="post">
        <h2 class="form-signin-heading">관리자 로그인</h2>
        <label for="inputEmail" class="sr-only">아이디</label>
        <input type="text" name="id" id="id" class="form-control" placeholder="아이디" value="hj" required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="비밀번호" value="sist" required>
        <button class="btn btn-lg btn-primary btn-block" id="login">로그인</button>
		
		<div class="sign_in_fail" id="sign_in_fail">
			<c:if test="${ login == false }">
				아이디 비밀번호가 일치하지 않습니다.<br>
				올바른 정보를 입력해주세요.
			</c:if>
		</div>
      </form>
    </div> <!-- /container -->
</body>
</html>