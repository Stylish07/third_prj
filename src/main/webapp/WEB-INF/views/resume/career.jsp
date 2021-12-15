<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = (String) session.getAttribute("id");
%>
<form id="career_frm" action="http://localhost/third_prj/resume/career_process.do" method="post">
	<label>* 회사 이름</label>
	<input type="text" class="form-control" id="company_name" name="company" placeholder="ex) 삼성SDS" value="${ careerVO.company }">

	<label>* 직무</label>
	<input type="text" class="form-control" id="task_name" name="task" placeholder="ex) 프론트엔드 개발자" value="${ careerVO.task }">
						
	<label>* 근무 기간</label>
	<input type="text" class="form-control" id="work_period" name="period" placeholder="ex) 2년 3개월" value="${ careerVO.period }">
	
	<label>* 사용 기술</label>
	<input type="text" class="form-control" id="using_stack" name="tech" placeholder="ex) android, Java, ..." value="${ careerVO.tech }">
	
	<label>* 업무 내용</label>
	<textarea class="form-control" id="career_description" name="description" rows="7" placeholder="업무 및 성과를 작성해주세요.">${ careerVO.description }</textarea>
</form>