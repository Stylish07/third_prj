<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row resume_card_header">
	<div class="resume_card_left col-md-3">
		<h3 class="card_title">수상 / 자격증</h3>
	</div>
	<div class="resume_card_middle col-md-3 col-md-offset-1">
		<h4>${ certificateVO.title }</h4>
	</div>
	<div class="resume_card_right col-md-2 col-md-offset-3">
		<button class="btn btn-primary btn-lg" type="button"
			data-toggle="collapse" data-target="#certificate"
			aria-expanded="false" aria-controls="certificate">+ 상세</button>
	</div>
</div>
<div>
	<div class="collapse" id="certificate">
		<div class="well resume_form">

			<form id="cert_frm" action="http://localhost/third_prj/resume/resumeSave.do" method="post">
				<div class="form-group">
					<label for="cert_title">* 수상/자격명</label> <input type="text"
						class="form-control" id="cert_title" placeholder="ex) 정보처리기사"
						name="title" value="${certificateVO.title}">
				</div>
				<div class="form-group">
					<label>* 취득 년월</label> <input type="month" name="get_date"
						value="${certificateVO.get_date}">
				</div>
				<div class="form-group">
					<label>설명</label>
					<textarea class="form-control" rows="7"
						placeholder="수상/자격증에 관한 사항을 작성해주세요." name="description">${certificateVO.description}</textarea>
				</div>
				<input type="hidden" name="category" value="certificate">
			</form>

		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-4">
				<button type="button" class="btn btn-success btn-lg" id="save_cert">저장</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-lg" id="reset_cert">삭제</button>
			</div>
		</div>
		<form id="remove_cert" action="http://localhost/third_prj/resume/resumeReset.do" method="post">
			<input type="hidden" name="table" value="certificate">
		</form>
	</div>
</div>