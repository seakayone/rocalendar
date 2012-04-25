
<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityVenueName"
	value="${message(code: 'venue.label', default: 'Venue')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
	<script 
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" 
		type="text/javascript"></script>
	<script
		src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA8LnR1umHYPuGexe-I0R_xhSEedscTwuAx4hZn6EjUEEnMd4RXhR2SD6gDMXQfL-9KjBJ_L7KPjClQQ"
		type="text/javascript"></script>
	<script type="text/javascript">
	    //<![CDATA[
	    function load() {
	      if (GBrowserIsCompatible()) {
	        var map = new GMap2(document.getElementById("map"));
	        map.setCenter(new GLatLng(${venue.lat}, ${venue.lng}), 13);
	 		map.addControl(new GLargeMapControl());
	    	map.addControl(new GMapTypeControl()); 
	
         	var point${venue.id} = new GLatLng(${venue.lat}, ${venue.lng})
      		var marker${venue.id} = new GMarker(point${venue.id})
      		marker${venue.id}.bindInfoWindowHtml("<strong>${venue.name}</strong><br/>${venue.street}<br>")
         	map.addOverlay(marker${venue.id})
	      }
	    }
	    $(document).ready(function(){
			//insert code here
			load();
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
		<div id="map" style="width: 930px; height: 600px"></div>
	</div>
</body>
</html>
