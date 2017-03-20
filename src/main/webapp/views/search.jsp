<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통합검색 페이</title>

<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="//d2d3qesrx8xj6s.cloudfront.net/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066"> -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
<![endif]-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style>
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
                $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span>');
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
        $('#display-json').html(JSON.stringify(checkedItems, null, '\t'));
    });
});
</script>
</head>
<body>
	<div>
		<h1>안녕하세요!.</h1>
	</div>
	
	<div class="container" style="margin-top:20px;">
	<div class="row">
        <div class="col-xs-6">
            <h3 class="text-center">Basic Example</h3>
            <div class="well" style="max-height: 300px;width:300px;">
        		<ul class="list-group checked-list-box">
                  <li class="list-group-item">Cras justo odio
                  	<ul>
                  		<li class="list-group-item">333</li>
                  	</ul>
                  </li>
                  
                  <li class="list-group-item" data-checked="true">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                </ul>
            </div>
        </div>
        <div class="col-xs-6">
            <h3 class="text-center">Colorful Example</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
            	<ul id="check-list-box" class="list-group checked-list-box">
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item" data-color="success">Dapibus ac facilisis in</li>
                  <li class="list-group-item" data-color="info">Morbi leo risus</li>
                  <li class="list-group-item" data-color="warning">Porta ac consectetur ac</li>
                  <li class="list-group-item" data-color="danger">Vestibulum at eros</li>
                </ul>
                <br />
                <button class="btn btn-primary col-xs-12" id="get-checked-data">Get Checked Data</button>
            </div>
            <pre id="display-json"></pre>
        </div>
	</div>
    <div class="row">
        <div class="col-xs-6">
            <h3 class="text-center">Using Button Style's</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
        		<ul class="list-group checked-list-box">
                  <li class="list-group-item" data-style="button">Cras justo odio</li>
                  <li class="list-group-item" data-style="button" data-color="success">Dapibus ac facilisis in</li>
                  <li class="list-group-item" data-style="button" data-color="info">Morbi leo risus</li>
                  <li class="list-group-item" data-style="button" data-color="warning">Porta ac consectetur ac</li>
                  <li class="list-group-item" data-style="button" data-color="danger">Vestibulum at eros</li>
                </ul>
            </div>
        </div>
        <div class="col-xs-6">
            <h3 class="text-center">Just a Small Party</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
            	<ul class="list-group checked-list-box">
                  <li class="list-group-item" data-style="button">Cras justo odio</li>
                  <li class="list-group-item" data-color="success">Dapibus ac facilisis in</li>
                  <li class="list-group-item" data-style="button" data-color="info">Morbi leo risus</li>
                  <li class="list-group-item" data-color="warning">Porta ac consectetur ac</li>
                  <li class="list-group-item" data-style="button" data-color="danger">Vestibulum at eros</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>