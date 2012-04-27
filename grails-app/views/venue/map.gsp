<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityVenueName" value="${message(code: 'venue.label', default: 'Venue')}" />
<title><g:message code="default.show.label" args="[entityVenueName]" /></title>

	<script 
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" 
		type="text/javascript"></script>
	<script type="text/javascript">
	    //<![CDATA[
	    function initializeMap() {
			var mapOptions = {
				    zoom: 17
				    , center: new google.maps.LatLng(${venue.lat}, ${venue.lng})
				    , mapTypeId: google.maps.MapTypeId.ROADMAP
			}
	        var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
			addMarkerToMap(map);
	    }
	    
	    function addMarkerToMap(map){
         	var infowindow = new google.maps.InfoWindow({
         	    content: '<div><h1>${venue.name}</h1><p>${venue.street}, ${venue.city}</p><p>${venue.description}</p></div>'
         	});
         	var marker = new google.maps.Marker({
         	    position: new google.maps.LatLng(${venue.lat}, ${venue.lng})
     	    	, map: map
     	    	, title: '${venue.name}'
         	});
         	google.maps.event.addListener(marker, 'click', function() {
           	  infowindow.open(map,marker);
           	});
           	infowindow.open(map,marker);
		}
	    
	    function loadGoogleMapsApi() {
	    	  var script = document.createElement("script");
	    	  script.type = "text/javascript";
	    	  script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyCrLr_bPa4jdyklguH1OdJk_UPqrvjnwVw&sensor=false&callback=initializeMap";
	    	  document.body.appendChild(script);
	    	}
    	
	    $('#map_canvas').ready(function(){
			loadGoogleMapsApi();
		});
	    //]]>
    </script>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><a class="list" href="${createLink(uri: '/venue')}"><g:message
						code="default.list.label" args="[entityVenueName]" /></a></li>
			<li><a class="list" href="${createLink(uri: '/venue/show/')}${venue.id}"><g:message
						code="default.show.label" args="[entityVenueName]" /></a></li>
		</ul>
	</div>

	<div class="content">
		<div id="map_canvas" style="width: 930px; height: 600px"></div>
	</div>
</body>
</html>
