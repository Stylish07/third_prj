<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/sign_in.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://localhost/third_prj/resources/js/sign_in.js"></script>

<script type="text/javascript">
$(function() {
	$("#sign_in_btn").click(function() {
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
		
		$("#sign_in_form").submit();
	});
});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/header.jsp"/>

	<div class="container">
		<div class="body_wrap">
			<div class="row">
			    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<form role="form" id="sign_in_form" action="http://localhost/third_prj/accounts/user_sign_in.do" method="post">
						<fieldset>
							<h2><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> 로그인</h2>
							<hr class="colorgraph">
							<div class="form-group">
			                    <input type="text" name="id" id="id" class="form-control input-lg" placeholder="아이디" value="android123">
							</div>
							<div class="form-group">
			                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="비밀번호" value="javajava">
							</div>
							<span class="button-checkbox">
								<button type="button" class="btn" data-color="info">아이디 저장</button>
			                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
								<a href="#void" class="btn btn-link pull-right">아이디 / 비밀번호 찾기</a>
							</span>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
			                        <input type="button" class="btn btn-lg btn-success btn-block" id="sign_in_btn" value="로그인">
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<a href="#void" class="btn btn-lg btn-primary btn-block">회원가입</a>
								</div>
							</div>
							<div class="sign_in_fail" id="sign_in_fail">
								<c:if test="${ login == false }">
									아이디 비밀번호가 일치하지 않습니다.<br>
									올바른 정보를 입력해주세요.
								</c:if>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>