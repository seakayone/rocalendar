<%@ page import="de.rootsouttacontrol.rocalendar.Venue" %>



<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="venue.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${venueInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'street', 'error')} ">
	<label for="street">
		<g:message code="venue.street.label" default="Street" />
		
	</label>
	<g:textField name="street" value="${venueInstance?.street}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'zip', 'error')} ">
	<label for="zip">
		<g:message code="venue.zip.label" default="Zip" />
		
	</label>
	<g:textField name="zip" value="${venueInstance?.zip}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="venue.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" maxlength="100" required="" value="${venueInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'state', 'error')} ">
	<label for="state">
		<g:message code="venue.state.label" default="State" />
		
	</label>
	<g:textField name="state" value="${venueInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'country', 'error')} ">
	<label for="country">
		<g:message code="venue.country.label" default="Country" />
		
	</label>
	<g:textField name="country" value="${venueInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="venue.url.label" default="Url" />
		
	</label>
	<g:textField name="url" value="${venueInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="venue.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1500" value="${venueInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'lat', 'error')} ">
	<label for="lat">
		<g:message code="venue.lat.label" default="Lat" />
		
	</label>
	<g:textField name="lat" value="${venueInstance?.lat}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: venueInstance, field: 'lng', 'error')} ">
	<label for="lng">
		<g:message code="venue.lng.label" default="Lng" />
		
	</label>
	<g:textField name="lng" value="${venueInstance?.lng}"/>
</div>

