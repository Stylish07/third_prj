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
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/notice_view.css">
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
				<table class="table table-bordered not_tab">
					<tbody>
						<tr>
							<td class="title">제목</td>
							<td colspan="7">${ noticeVO.title }</td>
						</tr>
						<tr>
							<td class="id1">작성자</td>
							<td class="id2">${ noticeVO.id }</td>
							<td class="idx1">글 번호</td>
							<td class="idx2">${ noticeVO.idx }</td>
							<td class="input_date1">작성일</td>
							<td class="input_date2">${ noticeVO.input_date }</td>
							<td class="count1">조회수</td>
							<td class="count2">${ noticeVO.count }</td>
						</tr>
						<tr>
							<td colspan="8" class="desc">${ noticeVO.description }</td>
						</tr>
					</tbody>
				</table>
				<div>
					<a class="btn btn-default" href="http://localhost/third_prj/notice/notice.do" role="button">목록으로</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>