<%@ page import="de.rootsouttacontrol.rocalendar.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="event.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${eventInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="event.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="minute"  value="${eventInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="event.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="minute"  value="${eventInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="event.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1500" value="${eventInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'entryFee', 'error')} ">
	<label for="entryFee">
		<g:message code="event.entryFee.label" default="Entry Fee" />
		
	</label>
	<g:textField name="entryFee" value="${eventInstance?.entryFee}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'filenameFlyer', 'error')} ">
	<label for="filenameFlyer">
		<g:message code="event.filenameFlyer.label" default="Filename Flyer" />
	</label>
	<g:textField name="filenameFlyer" value="${eventInstance?.filenameFlyer}"/>
	<input type="file" id="flyerupload" name="flyerupload"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'venue', 'error')} required">
	<label for="venue">
		<g:message code="event.venue.label" default="Venue" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="venue" name="venue.id" from="${de.rootsouttacontrol.rocalendar.Venue.list()}" optionKey="id" required="" value="${eventInstance?.venue?.id}" class="many-to-one"/>
</div>

