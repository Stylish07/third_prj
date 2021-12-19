<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지사항</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/notice.css">
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
		<div class="notice_wrap">
			<div class="notice_head">
				<h2>공지사항</h2>
			</div>
			<div class="notice_body">
				<table class="table table-hover">
					<thead class="thead">
						<tr>
							<td class="idx">번호</td>
							<td class="title">제목</td>
							<td class="admin">작성자</td>
							<td class="input_date">작성일</td>
							<td class="count">조회</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notice" items="${ notice }"> 
							<tr>
								<td>${ notice.idx }</td>
								<td><a href="http://localhost/third_prj/notice/notice_view.do?idx=${ notice.idx }">${ notice.title }</a></td>
								<td>${ notice.id }</td>
								<td>${ notice.input_date }</td>
								<td>${ notice.count }</td>
							</tr> 
						</c:forEach>
					</tbody>
				</table>
				<div class="page_nation">
					<nav>
						<ul class="pagination">
							<li>
								<a href="#" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
							<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
							<li>
								<a href="#" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>