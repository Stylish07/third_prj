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

function img_chg() {
	let img = $("#img").val();
	
	let blockExt = ["jpg", "jpeg", "png"];
	let blockFlag = false;
	
	let ext = (img.substring(img.lastIndexOf(".") + 1)).toLowerCase();
	for(var i = 0; i < blockExt.length; i++) {
		if(ext == blockExt[i]) {
			blockFlag = true;
			
			break;
		}
	}
	
	if(!blockFlag) {
		alert("업로드 가능한 확장자가 아닙니다.");
		$("#img").val("");
		
		return;
	}
	
	$("#img_form").submit();
}
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
					<form action="http://localhost/third_prj/profile/saveImg.do" id="img_form" method="post" enctype="multipart/form-data">
						<div class="form-group img">
							<label>프로필 이미지</label>
							<c:choose>
								<c:when test="${ not empty profileVO.img }">
									<img src="http://localhost/third_prj/resources/upload/${ profileVO.img }"
										alt="이미지 업로드 중 입니다." class="img-responsive" width="200px" onerror="this.src='http://localhost/third_prj/resources/images/profile/loading.gif'">
								</c:when>
								<c:otherwise>
									<img src="http://localhost/third_prj/resources/images/profile/defalt_profile.jpg"
										class="img-responsive" width="200px">
								</c:otherwise>
							</c:choose>
							<input type="file" name="img" id="img" accept=".jpg, .jpeg, .png" onchange="img_chg()">
							<span id="helpBlock" class="help-block">프로필 사진은 .jpg .jpeg .png 파일만 가능하고, 최대 파일 크기는 10MB 입니다.</span>
						</div>
					</form>
				
					<form action="http://localhost/third_prj/profile/saveProfile.do" id="profile_form" method="post">
						<div class="form-group gender">
							<label>성별</label>
							<div class="radio" >
								<label>
									<input type="radio" name="gender" id="genderM" value="M" <c:if test="${ profileVO.gender eq 'M' }">checked</c:if>>
									남
								</label>
							</div>
							<div class="radio">
								<label>
									<input type="radio" name="gender" id="genderW"  value="W" <c:if test="${ profileVO.gender eq 'W' }">checked</c:if>>
									여
								</label>
							</div>
						</div>
						
					 	<div class="form-group phone">
							<label>휴대폰 번호</label>
							<input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력하세요" value="${ profileVO.phone }">
						</div>
						
					 	<div class="form-group url">
							<label>홈페이지</label>
							<input type="text" class="form-control" name="url" id="url" placeholder="http://www.sist.com" value="${ profileVO.url }">
						</div>
						
						<div class="form-group tech_stack">
						 	<label>관심 기술</label>
						 	<select class="form-control" name="tech_idx">
						 		<option>선택해 주세요</option>
						 		<c:forEach var="tList" items="${ tList }">
						 			<option value="${tList.idx}" <c:if test ="${profileVO.tech_idx eq tList.idx}">selected="selected"</c:if>>
						 				${tList.subject}
						 			</option>
						 		</c:forEach>
							</select>
						</div>
						
					 	<div class="form-group description">
							<label>한 줄 소개</label>
							<textarea class="form-control" rows="2" name="description" id="description"><c:out value="${ profileVO.description }"/></textarea>
						</div>
						
						<%-- <input type="hidden" name="id" value="${ userVO.getId() }"> --%>
						
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