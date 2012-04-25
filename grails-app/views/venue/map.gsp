
<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'event.label', default: 'Event')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
	<script
		src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA8LnR1umHYPuGexe-I0R_xhSEedscTwuAx4hZn6EjUEEnMd4RXhR2SD6gDMXQfL-9KjBJ_L7KPjClQQ"
		type="text/javascript"></script>
	<script type="text/javascript">
	    //<![CDATA[
	    function load() {
	      if (GBrowserIsCompatible()) {
	        var map = new GMap2(document.getElementById("map"));
	        map.setCenter(new GLatLng(49.8919, 8.65), 13);
	 	map.addControl(new GLargeMapControl());
	    	map.addControl(new GMapTypeControl()); 
		
		<g:each in="${venueList}" status="i" var="venue">
	         	var point${venue.id} = new GLatLng(${venue.lat}, ${venue.lng})
	      		var marker${venue.id} = new GMarker(point${venue.id})
	      		marker${venue.id}.bindInfoWindowHtml("<strong>${venue.name}</strong><br/>${venue.street}<br>")
	         	map.addOverlay(marker${venue.id})
	      </g:each>
	
	      }
	    }
	    //]]>
    </script>
</head>
<body>
	<div id="map" style="width: 800px; height: 600px"></div>
</body>
</html>
