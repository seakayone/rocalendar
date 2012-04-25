import de.rootsouttacontrol.rocalendar.SecRole
import de.rootsouttacontrol.rocalendar.SecUser
import de.rootsouttacontrol.rocalendar.SecUserSecRole
import de.rootsouttacontrol.rocalendar.Venue

class BootStrap {

	def init = { servletContext ->
		
		def venue1 = new Venue(name: 'Baobab', street: 'Wenckstr. 1', zip: '64289', city:'Darmstadt', state:'Hessen', country:'Germany', url: 'http://baobab-erlebnisbar.de', description: 'description', lat: '49.8798200', lng: '8.6590900').save()
		def venue2 = new Venue(name: '603qm', street: 'Alexanderstr. 2', zip: '64289', city:'Darmstadt', state:'Hessen', country:'Germany', url: 'http://603qm.de', description: 'description', lat: '49.8749700', lng: '8.6575700').save()
		
		def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)
		
		def testUser = new SecUser(username: 'meUser', enabled: true, password: 'password').save(flush: true)
		SecUserSecRole.create(testUser, userRole, true)
		
		def testAdmin = new SecUser(username: 'meAdmin', enabled: true, password: 'password').save(flush: true)
		SecUserSecRole.create(testAdmin, adminRole, true)
	}
	def destroy = {
	}
}
