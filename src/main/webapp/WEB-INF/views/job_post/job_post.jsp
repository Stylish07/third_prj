<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채용공고</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/job_post.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	// 기술 선택
	$("#tech_idx").change(function() {
		if ($("#tech_idx").val() != "none") {
			location.href = "http://localhost/third_prj/job_post/job_post.do?tech_idx=" + $("#tech_idx").val();
		} else  {
			location.href = "http://localhost/third_prj/job_post/job_post.do";
		}
	});
});
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
				<div class="filter">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-3">
							<c:if test="${ not empty userVO }">
								<p>${ userVO.name }님의 선호 기술: </p>
								<c:forEach var="tList" items="${ tList }">
									<c:if test ="${ tList.idx eq profileVO.tech_idx }">
										<c:out value="${tList.subject}"/>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<div class="col-md-4">
							<select class="form-control" id="tech_idx">
							 	<option value="none">기술 스택</option>
								<c:forEach var="tList" items="${ tList }">
								 	<option value="${tList.idx}"<c:if test ="${ tech_idx eq tList.idx }">selected="selected"</c:if>>
								 		${tList.subject}
								 	</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="list">
					<table class="table table-hover">
						<thead>
							<tr>
								<td class="idx">번호</td>
								<td class="img">이미지</td>
								<td class="company">회사명</td>
								<td class="subject">기술</td>
								<td class="career">경력</td>
								<td class="input_date">게시일</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="jobList" items="${ jobList }"> 
								<tr class="list_tr">
									<td>${ jobList.idx }</td>
									<td>
										<img src="http://localhost/third_prj/resources/upload/job_post/${ jobList.img }" 
											class="img-responsive" width="70px" onerror="this.src='http://localhost/third_prj/resources/upload/job_post/noimage.png'">
									</td>
									<td><a href="http://localhost/third_prj/job_post/job_post_view.do?idx=${ jobList.idx }">${ jobList.company }</a></td>
									<td>${ jobList.subject }</td>
									<td>${ jobList.career }년</td>
									<td>${ jobList.input_date }</td>
								</tr> 
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>