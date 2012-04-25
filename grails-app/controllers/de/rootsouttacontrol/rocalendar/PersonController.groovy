package de.rootsouttacontrol.rocalendar

import grails.plugins.springsecurity.Secured

class PersonController {

	def springSecurityService
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def index() {
		Person personInstance = loggedInPerson()
		[personInstance: personInstance]
	}

	private loggedInPerson() {
		Person.get(springSecurityService.principal.id)
	}
}
