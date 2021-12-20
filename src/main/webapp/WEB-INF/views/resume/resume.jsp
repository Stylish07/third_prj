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
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/resume.css">
<!--jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#save_career").click(function() {
		if($("#company_name").val() == "") {
			alert("회사명은 필수 입력 항목 입니다.");
			$("#company_name").focus();
			
			return;
		}
		
		if($("task_name").val() == "") {
			alert("직무는 필수 입력 항목입니다.");
			$("task_name").focus();
			
			return;
		}
		
		if($("work_period").val() == "") {
			alert("근무 기간은 필수 입력 항목입니다.");
			$("work_period").focus();
			
			return;
		}
		$("#career_frm").submit();
	});
	
	$("#save_edu").click(function() {
		if($("#edu_univ_name").val() == "") {
			alert("학교명은 필수 입력 항목 입니다.");
			$("#edu_univ_name").focus();
			
			return;
		}
		if($("#edu_major").val() == "") {
			alert("전공은 필수 입력 항목 입니다.");
			$("#edu_major").focus();
			
			return;
		}
		if($("#edu_degree").val() == "") {
			alert("학위은 필수 입력 항목 입니다.");
			$("#edu_degree").focus();
			
			return;
		}
		if($("#ent").val() == "") {
			alert("입학년도는 필수 입력 항목 입니다.");
			$("#ent").focus();
			
			return;
		}
		
		$("#edu_frm").submit();
	});
	
	$("#save_cert").click(function() {
		if($("#cert_title").val() == "") {
			alert("수상/자격증은 필수 입력 항목 입니다.");
			$("#cert_title").focus();
			
			return;
		}
		
		$("#cert_frm").submit();
	});
	
	$("#save_lang").click(function() {
		if($("#lang_name").val() == "") {
			alert("외국어명은 필수 입력 항목 입니다.");
			$("#lang_name").focus();
			
			return;
		}
		if($("#exam_title").val() == "") {
			alert("시험 이름은 필수 입력 항목 입니다.");
			$("#exam_title").focus();
			
			return;
		}
		if($("#lang_score").val() == "") {
			alert("점수는 필수 입력 항목 입니다.");
			$("#lang_score").focus();
			
			return;
		}
		
		$("#lang_frm").submit();
	});
	
	$("#reset_career").click(function() {
		if(confirm("정말 삭제하시겠습니까?")) {
			$("#remove_career").submit();
		}
	});
	
	$("#reset_edu").click(function() {
		if(confirm("정말 삭제하시겠습니까?")) {
			$("#remove_education").submit();
		}
	});
	
	$("#reset_cert").click(function() {
		if(confirm("정말 삭제하시겠습니까?")) {
			$("#remove_cert").submit();
		}
	});
	
	$("#reset_lang").click(function() {
		if(confirm("정말 삭제하시겠습니까?")) {
			$("#remove_lang").submit();
		}
	});
});
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
								${ userVO.name }
							</h1>
						</div>
						<div>
							<c:choose>
								<c:when test="${ not empty profileVO.img }">
									<img src="http://localhost/third_prj/resources/upload/${ profileVO.img }" width="200px;"
										class="img-responsive img-circle prof_img"
										onerror="this.src='http://localhost/third_prj/resources/images/profile/loading.gif'">
								</c:when>
								<c:otherwise>
									<img src="http://localhost/third_prj/resources/images/profile/defalt_profile.jpg"
										class="img-responsive" width="200px">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="resume_profile_info">
							<strong>phone: ${ profileVO.phone }</strong>
							<br>
							<strong>email: ${ userVO.email }</strong>
						</div>
						<div class="resume_profile_info">
							<strong>homepage: ${ profileVO.url }</strong>
						</div>
						<div class="resume_profile_info">
							<strong>${ profileVO.description }</strong>
						</div>
						<div class="edit_prof">
							<a href="http://localhost/third_prj/profile/profile.do">내 프로필 수정</a>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="resume_body">
						<div class="resume_card">
							<jsp:include page="career.jsp"></jsp:include>
						</div>
						<div class="resume_card">
							<jsp:include page="education.jsp"></jsp:include>
						</div>
						<div class="resume_card">
							<jsp:include page="certificate.jsp"></jsp:include>
						</div>
						<div class="resume_card">
							<jsp:include page="language.jsp"></jsp:include>
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