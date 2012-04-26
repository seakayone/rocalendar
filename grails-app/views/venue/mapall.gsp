
<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityVenueName"
	value="${message(code: 'venue.label', default: 'Venue')}" />
<title><g:message code="default.show.label"
		args="[entityVenueName]" /></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	    //<![CDATA[
	    function initializeMap() {

			var mapCenterLatLng = new google.maps.LatLng(${location.lat}, ${location.lng});

			var myOptions = {
				    zoom: 13
				    , center: mapCenterLatLng
				    , mapTypeId: google.maps.MapTypeId.ROADMAP
			}
	        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

			<g:each in="${venueList}" status="i" var="venue">
				var venueLatLng${venue.id} = new google.maps.LatLng(${venue.lat}, ${venue.lng});
				var contentString${venue.id} = '<div><h1>${venue.name}</h1><p>${venue.street}, ${venue.city}</p><p>${venue.description}</p></div>';
				var infowindow${venue.id} = new google.maps.InfoWindow({
					content: contentString${venue.id}
	         	});

				var marker${venue.id} = new google.maps.Marker({
	         	    position: venueLatLng${venue.id}
	         	    , map: map
	         	    , title: '${venue.name}'
	         	});
	
	         	google.maps.event.addListener(marker${venue.id}, 'click', function() {
	         	  infowindow${venue.id}.open(map,marker${venue.id});
	         	});
         	</g:each>
	
	    }
	    function loadGoogleMapsApi() {
	    	  var script = document.createElement("script");
	    	  script.type = "text/javascript";
	    	  script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyCrLr_bPa4jdyklguH1OdJk_UPqrvjnwVw&sensor=false&callback=initializeMap";
	    	  document.body.appendChild(script);
	    	}
    	
	    $(document).ready(function(){
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
		</ul>
	</div>

	<div class="content">
		<div id="map_canvas" style="width: 930px; height: 600px"></div>
	</div>
</body>
</html>
