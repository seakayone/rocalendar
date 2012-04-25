package de.rootsouttacontrol.rocalendar

import grails.plugins.springsecurity.Secured

class PersonController {

	def springSecurityService
	
	def index() {
		  redirect(action: "list", params: params)
	}
	
	@Secured(['ROLE_ADMIN'])
	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[personInstanceList: Person.list(params), personInstanceTotal: Person.count()]
	}
	
	@Secured(['ROLE_ADMIN'])
	def show() {
		Person personInstance = Person.get(params.id)
		[personInstance: personInstance]
	}

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def me() {
		Person personInstance = loggedInPerson()
		[personInstance: personInstance]
	}
	
	private loggedInPerson() {
		Person.get(springSecurityService.principal.id)
	}
}
