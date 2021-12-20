<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채용 공고</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/job_post_view.css">
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
		<div class="job_wrap">
			<div class="job_head">
				<h2>채용 공고</h2>
			</div>
			<div class="job_body">
				<img src="http://localhost/third_prj/resources/upload/job_post/${ jobList.img }" class="img-responsive"
					width="200px" onerror="this.src='http://localhost/third_prj/resources/upload/job_post/noimage.png'">
				<br>	
				회사명: <h3>${ jobPostVO.company }</h3>
				<br>
				주소: <h3>${ jobPostVO.address }</h3>
				<br>
				홈페이지: <h3>${ jobPostVO.homepage }</h3>
				<br>
				기술: <h4>${ jobPostVO.subject }</h4>
				경력: <h4>${ jobPostVO.career }년</h4>
				<br>
				내용: <h4>${ jobPostVO.description }</h4>
				<br>
				<br>
				<br>
				작성자: <p>${ jobPostVO.id }</p>
				작성일: <p>${ jobPostVO.input_date }</p>
				<div>
					<br>
					<br>
					<a class="btn btn-default" href="http://localhost/third_prj/job_post/job_post.do" role="button">목록으로</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>