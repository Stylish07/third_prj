<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/header.css">

<%
/* 접속된 사용자의 이름을 저장하는 변수를 담아서 userName으로 등록하는 코드필요 */
%>

<div class="bloc l-bloc" id="nav-bloc">
	<div class="container">
		<nav class="navbar row">
			<div class="navbar-header">
				<a class="navbar-brand" href="http://localhost/third_prj/index.do">이력서 및 채용공고</a>
				<!-- 브라우저 창이 작아지면 메뉴를 접었다 폈다 할수 있음 -->
				<button id="nav-toggle" type="button"
					class="ui-navbar-toggle navbar-toggle" data-toggle="collapse"
					data-target=".navbar-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse navbar-1">
				<ul class="site-navigation nav">
					<li><a href="http://localhost/third_prj/resume/resume.do">이력서</a></li>
					<li><a href="http://localhost/third_prj/portfolio/portfolio.do">포트폴리오</a></li>
					<li><a href="http://localhost/third_prj/job_post/job_post.do">채용공고</a></li>
					<li><a href="http://localhost/third_prj/notice/notice.do">공지사항</a></li>
					<c:if test="${ not empty userVO }">
						<li><a href="http://localhost/third_prj/profile/profile.do">${ userVO.getName() }'s 프로필</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</div>