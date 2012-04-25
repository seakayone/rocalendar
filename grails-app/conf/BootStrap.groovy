import grails.plugins.springsecurity.SpringSecurityService;
import de.rootsouttacontrol.rocalendar.SecRole
import de.rootsouttacontrol.rocalendar.SecUser
import de.rootsouttacontrol.rocalendar.SecUserSecRole
import de.rootsouttacontrol.rocalendar.Venue
import de.rootsouttacontrol.rocalendar.Person

class BootStrap {

	def SpringSecurityService
	def init = { servletContext ->

		def venue1 = Venue.findByName('Baobab') ?: new Venue(name: 'Baobab', street: 'Wenckstr. 1', zip: '64289', city:'Darmstadt', state:'Hessen', country:'Germany', url: 'http://baobab-erlebnisbar.de', description: 'description', lat: '49.8798200', lng: '8.6590900').save()
		def venue2 = Venue.findByName('603qm') ?: new Venue(name: '603qm', street: 'Alexanderstr. 2', zip: '64289', city:'Darmstadt', state:'Hessen', country:'Germany', url: 'http://603qm.de', description: 'description', lat: '49.8749700', lng: '8.6575700').save()

		def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?:new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(flush: true)


		def persons = Person.list() ?: []
		if (!persons) {
			def user = new Person(
					username: 'meUser'
					, enabled: true
					, password: 'password'// password: SpringSecurityService.encodePassword('password')
					).save(flush: true)
			SecUserSecRole.create(user, userRole, true)

			def admin = new Person(
					username: 'meAdmin'
					, enabled: true
					, password: 'password'// password: SpringSecurityService.encodePassword('password')
					).save(flush: true)
			SecUserSecRole.create(admin, adminRole, true)
		}
	}
	def destroy = {
	}
}
