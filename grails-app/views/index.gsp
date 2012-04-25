<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityEventName"
	value="${message(code: 'event.label', default: 'Event')}" />
<g:set var="entityVenueName"
	value="${message(code: 'venue.label', default: 'Venue')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><a class="venue" href="${createLink(uri: '/venue')}"><g:message
						code="default.list.label" args="[entityVenueName]" /></a></li>
			<li><a class="event" href="${createLink(uri: '/event')}"><g:message
						code="default.list.label" args="[entityEventName]" /></a></li>
		</ul>
	</div>

	<div class="content">
		<h1>Hello Reggae World</h1>
	</div>
</body>
</html>