
<%@ page import="de.rootsouttacontrol.rocalendar.Venue" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'venue.label', default: 'Venue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-venue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="map" action="mapall"><g:message code="default.mapall.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-venue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'venue.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="street" title="${message(code: 'venue.street.label', default: 'Street')}" />
					
						<g:sortableColumn property="zip" title="${message(code: 'venue.zip.label', default: 'Zip')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'venue.city.label', default: 'City')}" />
					
						<g:sortableColumn property="state" title="${message(code: 'venue.state.label', default: 'State')}" />
					
						<g:sortableColumn property="country" title="${message(code: 'venue.country.label', default: 'Country')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${venueInstanceList}" status="i" var="venueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${venueInstance.id}">${fieldValue(bean: venueInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: venueInstance, field: "street")}</td>
					
						<td>${fieldValue(bean: venueInstance, field: "zip")}</td>
					
						<td>${fieldValue(bean: venueInstance, field: "city")}</td>
					
						<td>${fieldValue(bean: venueInstance, field: "state")}</td>
					
						<td>${fieldValue(bean: venueInstance, field: "country")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${venueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
