<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>내 프로필</title>
<style type="text/css">
</style>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/profile.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#save").click(function() {
		
		
		$("#profile_form").submit();
	});
});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/header.jsp"/>
	
	<div class="container">
		<div class="wrap">
			<div class="header">
				<h2>내 프로필</h2>
			</div>
			<div class="profile_body">
				<div class="form_body">
					<form action="#void" id="profile_form">
					
						<div class="form-group img">
							<label>프로필 이미지</label>
							<img alt="" src="">
						</div>
						
					 	<div class="form-group gender">
							<label>성별</label>
							<div class="radio" >
								<label>
									<input type="radio" name="gender" id="genderM" value="M" <c:if test="${ profileVO.getGender() eq 'M' }">checked</c:if>>
									남
								</label>
							</div>
							<div class="radio">
								<label>
									<input type="radio" name="gender" id="genderW"  value="W" <c:if test="${ profileVO.getGender() eq 'W' }">checked</c:if>>
									여
								</label>
							</div>
						</div>
						
					 	<div class="form-group phone">
							<label>휴대폰 번호</label>
							<input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력하세요" value="${ profileVO.getPhone() }">
						</div>
						
					 	<div class="form-group url">
							<label>홈페이지</label>
							<input type="text" class="form-control" name="url" id="url" placeholder="http://www.sist.com" value="${ profileVO.getUrl() }">
						</div>
						
						<div class="form-group tech_stack">
						 	<label>관심 기술</label>
						 	<select class="form-control">
						 		<option>선택해 주세요</option>
						 		<c:forEach var="tList" items="${ tList }">
						 			<option value="${tList.idx}" <c:if test ="${profileVO.getTech_idx() eq tList.idx}">selected="selected"</c:if>>
						 				${tList.subject}
						 			</option>
						 		</c:forEach>
							</select>
						</div>
						
					 	<div class="form-group description">
							<label>한 줄 소개</label>
							<textarea class="form-control" rows="2" name="description" id="description"><c:out value="${ profileVO.getDescription() }"/></textarea>
						</div>
						
						<button type="button" class="btn btn-success" id="save">저장</button>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>