<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
table {text-align: center; margin-left: auto; margin-right:auto; margin-top: 15px;}
td {padding: 20px; cursor: pointer; font-size: 18px}

.title{font-weight: bold; font-size: 30px;}
a{ color: #000000; text-decoration: none;}
a:hover { color: #000000; text-decoration: none; }
</style>

<script type="text/javascript">
$(function () {
	$("#logout_ad").click(function () {
		var logout_con = confirm("로그아웃하시겠습니까?");
		if(logout_con == true){
			location.href="#void";
		}//end if
		else if(logout_con == false){
		}//end else
	})//logout
	
})//ready
</script>

	<header>
		<div >
			<table style="width: 1500px;">
				<tr>
					<td class="title" ><a href="http://localhost/third_prj/admin/admin.do">관리자 페이지</a></td><!-- 얘는 그냥 링크로 하시면 되요-->
					<td>&nbsp;</td>
					<td id="user_ad"><a href="http://localhost/third_prj/admin/admin.do">회원 관리</a></td>
					<td>||</td> 
					<td id="job_post_ad"><a href="http://localhost/third_prj/admin/admin_job_post.do">채용공고 관리</a></td>
					<td>||</td>
					<td id="notice_ad"><a href="#void">공지사항 관리</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td id="pass_ad">비밀번호 변경</td>
					<td>&nbsp;</td>
					<td id="logout_ad">로그아웃</td>
				</tr>
			</table>
		</div>
	</header>