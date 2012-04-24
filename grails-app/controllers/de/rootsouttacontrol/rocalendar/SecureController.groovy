package de.rootsouttacontrol.rocalendar

import grails.plugins.springsecurity.Secured

class SecureController {
	@Secured(['ROLE_ADMIN'])
	def index = { render 'Secure access only' }
}
