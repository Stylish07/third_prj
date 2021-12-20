<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>포트폴리오</title>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/portfolio.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
function portfolio_write(){
	location.href="#void";
}//portfolio_write

function deletePortfolio(idx) {
	if(confirm(idx+"번 포트폴리오를 삭제하시겠습니까?")) {
		$("#deleteIdx").val(idx);
		$("#deleteFrm").submit();
	}//end if
}//deletePortfolio
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/headerfooter/header.jsp"/>
	
	<!-- container -->
		<div class="container">
			<div class="portfolio_wrap">
				<div class="portfolio_head">
					<h2 style="font-weight: bold;">포트폴리오 목록</h2>
				</div>
				<div>
					<input class="portfolioBtn" type="button" value="포트폴리오 추가" onclick="portfolio_write()">
				</div>
				<div class="portfolioTable">
					<table class="table table-hover">
						<thead>
							<tr>
								<td style="width: 110px; font-size: 18px; font-weight: bold; text-align: center; color: #333">번호</td>
								<td style="width: 1000px; font-size: 18px; font-weight: bold; text-align: center; color: #333">포트폴리오명</td>
								<td style="width: 110px"></td>
							</tr>
						</thead>
						<tbody>
							<c:if test="${ empty portfolioData }">
								<tr>
									<td colspan="3">포트폴리오가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:forEach var="portfolio" items="${ portfolioData }">
								<tr>
									<td style="font-size: 18px; text-align: center; color: #333"><c:out value="${ portfolio.idx }"/></td>
									<td style="font-size: 18px; text-align: center; color: #333"><a href="#void?idx=${ portfolio.idx }"><c:out value="${ portfolio.proj_title }"/></a></td>
									<td><input class="deleteBtn" type="button" value="삭제" onclick="deletePortfolio(${portfolio.idx})"></td>
								</tr> 
							</c:forEach>
						</tbody>
					</table>
				<form name="deleteFrm" id="deleteFrm" action="#void" method="post">
					<input type="hidden" name="idx" id="deleteIdx"/>
				</form>
				</div>
			</div>
		</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>