
<%@ page import="de.rootsouttacontrol.rocalendar.Venue" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'venue.label', default: 'Venue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-venue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="map" action="map" id="${venueInstance?.id}"><g:message code="default.map.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-venue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list venue">
			
				<g:if test="${venueInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="venue.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${venueInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.street}">
				<li class="fieldcontain">
					<span id="street-label" class="property-label"><g:message code="venue.street.label" default="Street" /></span>
					
						<span class="property-value" aria-labelledby="street-label"><g:fieldValue bean="${venueInstance}" field="street"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.zip}">
				<li class="fieldcontain">
					<span id="zip-label" class="property-label"><g:message code="venue.zip.label" default="Zip" /></span>
					
						<span class="property-value" aria-labelledby="zip-label"><g:fieldValue bean="${venueInstance}" field="zip"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="venue.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${venueInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="venue.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${venueInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="venue.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:fieldValue bean="${venueInstance}" field="country"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="venue.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${venueInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="venue.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${venueInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.events}">
				<li class="fieldcontain">
					<span id="events-label" class="property-label"><g:message code="venue.events.label" default="Events" /></span>
					
						<g:each in="${venueInstance.events}" var="e">
						<span class="property-value" aria-labelledby="events-label"><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${venueInstance?.id}" />
					<g:link class="edit" action="edit" id="${venueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
