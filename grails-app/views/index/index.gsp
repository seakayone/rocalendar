<%@ page import="de.rootsouttacontrol.rocalendar.Event"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityEventName"
	value="${message(code: 'event.label', default: 'Event')}" />
<g:set var="entityVenueName"
	value="${message(code: 'venue.label', default: 'Venue')}" />
<title>Home</title>
</head>
<body>
	Test
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><a class="list" href="${createLink(uri: '/venue')}"><g:message
						code="default.list.label" args="[entityVenueName]" /></a></li>
			<li><a class="list" href="${createLink(uri: '/event')}"><g:message
						code="default.list.label" args="[entityEventName]" /></a></li>
		</ul>
	</div>

	<div class="content">
		
		<div class="">
			<h1>Hello Reggae World</h1>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
				penatibus et magnis dis parturient montes, nascetur ridiculus mus.
				Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
				Nulla consequat massa quis enim. Donec pede justo, fringilla vel,
				aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut,
				imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede
				mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum
				semper nisi. Aenean vulputate eleifend tellus.</p>
		</div>
		
		<div>
			<h1>Neuste Veranstaltungen</h1>
			<ul>
				<g:each in="${latestEvents}" var="c">
					<li>
						${c.startDate} ${c.name}
					</li>
				</g:each>
			</ul>
		</div>
		
		<div>
			<h1>Neueste Orte</h1>
			<ul>
				<g:each in="${latestVenues}" var="c">
					<li>
						${c.toString()}
					</li>
				</g:each>
			</ul>
		</div>
		
	</div>
</body>
</html>
