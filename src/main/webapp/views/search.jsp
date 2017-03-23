<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통합검색 페이</title>

<!-- Le styles -->
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="/resources/css/bootstrap-responsive.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	$(document).ready(function(){
		
		$(document).on("click",".jik",function(){
			$('#dam').show();
		});
		
		$(document).on("click",".jik",function(){
			$('#dam').show();
		});
		
	});
	
</script>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<h5>필터 도우미</h5>
				<div class="well sidebar-nav">
					<div>
						<ul class="nav nav-list">
							<li class="nav-header">직종 (3494)</li>
							<li><input type="checkbox" id="jik1" class="jik" style="vertical-align: auto;float:left;"/> <label for="jik1" style="" >응용프로그래머  (1034) </label></li>
							<li ><input type="checkbox" id="jik2" class="jik" style="vertical-align: top;float:left;"/> <label for="jik2" style="" >Java (1034)</label></li>
							<li ><input type="checkbox" id="jik3" class="jik" style="vertical-align: top;float:left;"/> <label for="jik3" style="" >python (1034)</label></li>
							<li ><input type="checkbox" id="jik4" class="jik" style="vertical-align: top;float:left;"/> <label for="jik4" style="" >안드로이드 (1034)</label></li>
						</ul>
					</div>
					<div style="display:none;" id="dam">
						<ul class="nav nav-list">
							<li class="nav-header">→담당업무</li>
							<li><input type="checkbox" id="i_jik1" style="vertical-align: auto;float:left;"/> <label for="i_jik1" style="" >빅데이터 분석  (334) </label></li>
							<li ><input type="checkbox" id="i_jik2" style="vertical-align: top;float:left;"/> <label for="i_jik2" style="" >빅데이터 마이닝 (234)</label></li>
						</ul>
					</div>
					<div>
						<ul class="nav nav-list">
							<li class="nav-header">지역 (2912)</li>
							<li><input type="checkbox" id="loc1" class="loc" style="vertical-align: auto;float:left;"/> <label for="loc1" style="" >서울 > 구로구 (323) </label></li>
							<li><input type="checkbox" id="loc2" class="loc" style="vertical-align: auto;float:left;"/> <label for="loc2" style="" >서울 > 마포구 (291)</label></li>
							<li><input type="checkbox" id="loc3" style="vert
							ical-align: auto;float:left;"/> <label for="loc3" style="" >경기 > 성남시 분당구 (806)</label></li>
							<li><input type="checkbox" id="loc4" style="vertical-align: auto;float:left;"/> <label for="loc4" style="" >부산 > 부산진구 (333)</label></li>
							<li><input type="checkbox" id="loc5" style="vertical-align: auto;float:left;"/> <label for="loc5" style="" >경북 > 칠곡군 (32)</label></li>
						</ul>
					</div>
					
					<div style="display:none;">
						<ul class="nav nav-list">
							<li class="nav-header">→인근지하철</li>
							<li><input type="checkbox" id="jik1" style="vertical-align: auto;float:left;"/> <label for="jik1" style="" >신도림(1호선) (24) </label></li>
							<li ><input type="checkbox" id="jik2" style="vertical-align: top;float:left;"/> <label for="jik2" style="" >오류역(234)</label></li>
						</ul>
					</div>
					<div>
						<ul  class="nav nav-list">
							<li class="nav-header">경력/학력 </li>
						</ul>
						
						<table class="nav nav-list" border="1" width="50%" style="float:left;border-right: 0px;">
							<thead>
								<tr>
									<td>경력</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" id="pos1" style="vertical-align: auto;float:left;"/> <label for="pos1" style="" >신입</label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="pos2" style="vertical-align: auto;float:left;"/> <label for="pos2" style="" >경력</label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="pos3" style="vertical-align: auto;float:left;"/> <label for="pos3" style="" >경력 무관</label></td>
								</tr>
							</tbody>
						</table>
						<table class="nav nav-list" border="1" width="50%" style="float:left;">
							<thead>
								<tr>
									<td>학력</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" id="sch1" style="vertical-align: auto;float:left;"/> <label for="sch1" style="" >대학(4년) 졸업</label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="sch2" style="vertical-align: auto;float:left;"/> <label for="sch2" style="" >대학(2,3년) 졸업</label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="sch3" style="vertical-align: auto;float:left;"/> <label for="sch3" style="" >석사 이상 </label></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div>
						<ul  class="nav nav-list">
							<li class="nav-header">근무형태 / 채용구분</li>
						</ul>
						
						<table class="nav nav-list" border="1" width="50%" style="float:left;border-right: 0px;">
							<thead>
								<tr>
									<td>근무형태</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" id="biz1" style="vertical-align: auto;float:left;"/> <label for="biz1" style="" >정규직</label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="biz2" style="vertical-align: auto;float:left;"/> <label for="biz2" style="" >계약직</label></td>
								</tr>
							</tbody>
						</table>
						<table class="nav nav-list" border="1" width="50%" style="float:left;">
							<thead>
								<tr>
									<td>채용구분</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" id="type1" style="vertical-align: auto;float:left;"/> <label for="type1" style="" >일반채용 </label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="type2" style="vertical-align: auto;float:left;"/> <label for="type2" style="" >헤드헌팅 </label></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="type3" style="vertical-align: auto;float:left;"/> <label for="type3" style="" >파견대행 </label></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br/>
					<div>
						<ul class="nav nav-list">
							<li class="nav-header">선택 사항</li>
							<li><input type="checkbox" id="exc1" style="vertical-align: auto;float:left;"/> <label for="exc1" style="" >입사지원한 공고 제외</label></li>
							<li><input type="checkbox" id="exc2" style="vertical-align: auto;float:left;"/> <label for="exc2" style="" >조회한 공고 제외</label></li>
							<li><input type="checkbox" id="exc3" style="vertical-align: auto;float:left;"/> <label for="exc3" style="" >스크랩한 공고 제외</label></li>
						</ul>
					</div>
					
					<div align="center" style="padding-top:20px;">
						<ul class="nav nav-list">
							<li><input type="button" value="검색" style="width:200px;" /></li>
						</ul>
					</div>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<div class="hero-unit">
					<h2>검색 결과</h2>
					<!-- <p></p> -->
					<!-- <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p> -->
				</div>
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
				<!--/span-->
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
				<!--/span-->
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
				<!--/span-->
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
				<!--/span-->
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
				<!--/span-->
				<div class="span10">
					<h2>Heading</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum
						nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
						malesuada magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn" href="#">View details &raquo;</a>
					</p>
				</div>
					<!--/span-->
				<!-- row -->
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
		<p>&copy; Company 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->
</body>
</html>