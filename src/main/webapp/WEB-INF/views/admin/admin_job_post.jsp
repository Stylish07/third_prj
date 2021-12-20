<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 채용공고 관리 페이지</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/admin_job_post.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function () {
	$("#add_job").click(function() {
		location.href="http://localhost/sist_resume/admin/admin_job_post_add.jsp";
	})
	$("#job_post_det").click(function() {
		location.href="http://localhost/sist_resume/admin/admin_job_post_list.jsp";
	})
})//ready

function removeData(idx) {
	if (confirm( idx + " 번 채용공고를 삭제하시겠습니까?")) {
		$("#removeJobpost").val( idx );
		
		$("#removeFrm").submit();
	}//end if
}//removeData
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/admin_header.jsp"/>
	
	<div class="container">
	<div class="admin_job">
		<div class="job_wrap">
			<div class="job_head">
				<h2>채용 공고</h2>
			</div>
			<div class="job_body">
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
</div>
</body>
</html>