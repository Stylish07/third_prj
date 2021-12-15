<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이력서 및 채용공고</title>
<style type="text/css">
</style>
<link rel="stylesheet" href="http://localhost/third_prj/resources/css/index.css">
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
		<div class="wrap">
			<div class="row">
				<div class="col-md-3">
					<div class="login">
						<c:choose>
							<c:when test="${ empty sessionScope.id }">
								<a href="http://localhost/third_prj/login/login_page.jsp" class="link_login">로그인</a>
								<div class="sub_area">
									<a href="http://localhost/third_prj/login/find.jsp" class="link_look">아이디 비밀번호 찾기</a>
									 / 
									<a href="http://localhost/third_prj/login/sign_up.jsp" class="link_join">회원가입</a>
								</div>
							</c:when>
							<c:otherwise>
								<!-- 로그인 정보가 세션이 있을 경우 나타나야 하는 정보를 만들기 -->
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-md-9">
					<div class="carousel_wrap">
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
						 	<ol class="carousel-indicators">
							    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="5"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="6"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="7"></li>
						  	</ol>
						  	
							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<img src="http://localhost/third_prj/resources/images/carousel/a.png">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/b.png">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/c.jpeg">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/d.png">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/e.jpg">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/f.png">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/g.jpg">
							    </div>
							    <div class="item">
							    	<img src="http://localhost/third_prj/resources/images/carousel/h.png">
							    </div>
							</div>
							
							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>
							<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="contents no1">
				<div class="content_wrap">
					<div class="row">
						<div class="col-md-6">
							<div class="content_title">
								<h2><strong>이력서를 작성해보세요</strong></h2>
							</div>
						</div>
						<div class="col-md-6">
							<img src="http://localhost/third_prj/resources/images/main_page/popol_ex.png" width="500px">
						</div>
					</div>
				</div>
			</div>
			<div class="contents no2">
				<div class="content_wrap">
					<div class="row">
						<div class="col-md-6">
							<img src="http://localhost/third_prj/resources/images/main_page/resume_ex.png" width="500px">
						</div>
						<div class="col-md-6">
							<div class="content_title">
								<h2><strong>포트폴리오를 작성해보세요</strong></h2>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="contents no3">
				<div class="content_wrap">
					<div class="tab_subtitle">
						<h2><strong>국내외 많은 기업이 당신을 기다립니다.</strong></h2>
					</div>
					<table class="table table-bordered company_tab">
						<tr>
							<td>
								<div class="comp_logo"><img alt="kakao" src="http://localhost/third_prj/resources/images/comp_logo/kakao.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="line" src="http://localhost/third_prj/resources/images/comp_logo/line.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="naver" src="http://localhost/third_prj/resources/images/comp_logo/naver.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="lguplus" src="http://localhost/third_prj/resources/images/comp_logo/lguplus.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="11st" src="http://localhost/third_prj/resources/images/comp_logo/11st.png" width="190px"></div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="comp_logo"><img alt="deliveryhero" src="http://localhost/third_prj/resources/images/comp_logo/deliveryhero.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="kakaocommerce" src="http://localhost/third_prj/resources/images/comp_logo/kakaocommerce.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="kakaoenterprise" src="http://localhost/third_prj/resources/images/comp_logo/kakaoenterprise.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="woowahan" src="http://localhost/third_prj/resources/images/comp_logo/woowahan.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="netmarble" src="http://localhost/third_prj/resources/images/comp_logo/netmarble.png" width="190px"></div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="comp_logo"><img alt="carrotmarket" src="http://localhost/third_prj/resources/images/comp_logo/carrotmarket.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="watcha" src="http://localhost/third_prj/resources/images/comp_logo/watcha.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="socar" src="http://localhost/third_prj/resources/images/comp_logo/socar.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="vcnc" src="http://localhost/third_prj/resources/images/comp_logo/vcnc.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="estsoft" src="http://localhost/third_prj/resources/images/comp_logo/estsoft.png" width="190px"></div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="comp_logo"><img alt="krafton" src="http://localhost/third_prj/resources/images/comp_logo/krafton.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="dramacompany" src="http://localhost/third_prj/resources/images/comp_logo/dramacompany.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="zigbang" src="http://localhost/third_prj/resources/images/comp_logo/zigbang.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="myrealtrip" src="http://localhost/third_prj/resources/images/comp_logo/myrealtrip.png" width="190px"></div>
							</td>
							<td>
								<div class="comp_logo"><img alt="dreamus" src="http://localhost/third_prj/resources/images/comp_logo/dreamus.png" width="190px"></div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/headerfooter/footer.jsp"/>
</body>
</html>