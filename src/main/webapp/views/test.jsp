<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통합검색 페이</title>

<!-- Le styles -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet"
	href="//d2d3qesrx8xj6s.cloudfront.net/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066">
<style type="text/css">
/* CSS REQUIRED */
.state-icon {
	left: -5px;
}

.list-group-item-primary {
	color: rgb(255, 255, 255);
	background-color: rgb(66, 139, 202);
}

/* DEMO ONLY - REMOVES UNWANTED MARGIN */
.well .list-group {
	margin-bottom: 0px;
}
</style>
<link href="/resources/css/bootstrap-responsive.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
$(function () {
    $('.list-group.checked-list-box .list-group-item').each(function () {
        
        // Settings
        var $widget = $(this),
            $checkbox = $('<input type="checkbox" class="hidden" />'),
            color = ($widget.data('color') ? $widget.data('color') : "primary"),
            style = ($widget.data('style') == "button" ? "btn-" : "list-group-item-"),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };
            
        $widget.css('cursor', 'pointer')
        $widget.append($checkbox);

        // Event Handlers
        $widget.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });
          

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $widget.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $widget.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$widget.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $widget.addClass(style + color + ' active');
            } else {
                $widget.removeClass(style + color + ' active');
            }
        }

        // Initialization
        function init() {
            
            if ($widget.data('checked') == true) {
                $checkbox.prop('checked', !$checkbox.is(':checked'));
            }
            
            updateDisplay();

            // Inject the icon if applicable
            if ($widget.find('.state-icon').length == 0) {
                $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span> ');
            }
        }
        init();
    });
    
    $('#get-checked-data').on('click', function(event) {
        event.preventDefault(); 
        var checkedItems = {}, counter = 0;
        $("#check-list-box li.active").each(function(idx, li) {
            checkedItems[counter] = $(li).text();
            counter++;
        });
        alert(JSON.stringify(checkedItems, null, '\t'));
    });
});


</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-xs-2">
				<h3 class="text-left">필터</h3>
				<div class="well" style="max-height:auto;">
					<span class="caption">직종</span>
					<ul id="check-list-box" class="list-group checked-list-box">
						<li class="list-group-item" data-style="button">응용프로그래머 (123)</li>
						<li class="list-group-item">Java (123)</li>
						<li class="list-group-item">엔지니어 (123)</li>
					</ul>
					<span class="caption">지역</span>
					<ul id="check-list-box" class="list-group checked-list-box">
						<li class="list-group-item">서울시 > 구로구 (23)</li>
						<li class="list-group-item">서울시 > 노원구 (23)</li>
						<li class="list-group-item">서울시 > 금천구 (23)</li>
					</ul>
					
					<span class="caption">경력 / 학력</span>
					<div style="font-size:9px;">
						<ul id="check-list-box" class="list-group" style="width:50%;float:left;line-height: 50%;text-align: center;">
							<li class="list-group-item">경력</li>
						</ul>
						<ul id="check-list-box" class="list-group" style="width:50%;float:left;line-height: 50%;text-align: center;">
							<li class="list-group-item">학력</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">신입</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">대학(4년) 졸업</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">경력</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">대학(2,3년) 졸업</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">경력 무관</li>
						</ul>
						<ul id="check-list-box" class="list-group checked-list-box" style="width:50%;float:left;">
							<li class="list-group-item">석사 이상</li>
						</ul>
					</div>
					
					<!-- <span class="caption">경력 / 학력</span> -->
					
					<ul id="check-list-box" class="list-group checked-list-box" style="width:60%;float:left;font-size:9px;height:10px;">
						<li class="list-group-item">조회한 공고 제외</li>
						<li class="list-group-item">입사지원한 공고 제외</li>
						<li class="list-group-item">스크랩한 공고 제외</li>
					</ul>
					<ul id="check-list-box" class="list-group checked-list-box" style="width:40%;float:left;line-height:725%;font-size:8px;">
						<li class="list-group-item rowspan2">초기화</li>
					</ul>
					
					<!-- <div>
						<ul class="list-group">
							<li class="button"><button id="get-checked-data">검색</button>
						</li>
					</ul
					</div> >-->
				</div>
			</div>
			<div class="span9">
				<div class="hero-unit">
					<h1>테스트 페이지</h1>
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
		</div>
	</div>
	<div class="container" style="margin-top: 20px;">
		
	</div>
</body>
</html>