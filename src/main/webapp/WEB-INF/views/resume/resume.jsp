<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이력서 관리</title>
<style type="text/css">
</style>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/resume.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/header.jsp"/>
	
	<div class="container">
		<div class="resume_wrap">
			<div class="resume_head">
				<h2>내 이력서</h2>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="resume_profile">
						<div class="resume_profile_info">
							<h1>
								${ iVO.name }
							</h1>
						</div>
						<div>
							<img src="#void/${ pVO.img }" width="200px;" class="img-responsive img-circle prof_img"
								onerror="this.src='http://localhost/third_prj/resources/images/profile/defalt_profile.jpg'">
						</div>
						<div class="resume_profile_info">
							<strong>phone: ${ pVO.phone }</strong>
							<br>
							<strong>email: ${ iVO.email }</strong>
						</div>
						<div class="resume_profile_info">
							<strong>homepage: ${ pVO.url }</strong>
						</div>
						<div class="resume_profile_info">
							<strong>${ pVO.description }</strong>
						</div>
						<div class="edit_prof">
							<a href="http://localhost/third_prj/profile/profile.do">내 프로필 수정</a>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="resume_body">
						<div class="resume_card">
							<jsp:include page="/WEB-INF/views/resume/career.jsp"></jsp:include>
						</div>
						<div class="resume_card">
						
						</div>
						<div class="resume_card">
						
						</div>
						<div class="resume_card">
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>