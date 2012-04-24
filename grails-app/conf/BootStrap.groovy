import de.rootsouttacontrol.rocalendar.SecRole
import de.rootsouttacontrol.rocalendar.SecUser
import de.rootsouttacontrol.rocalendar.SecUserSecRole


class BootStrap {

	def init = { servletContext ->
		def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)

		def testUser = new SecUser(username: 'me', enabled: true, password: 'password').save(flush: true)

		SecUserSecRole.create testUser, adminRole, true

		assert SecUser.count() == 1
		assert SecRole.count() == 2
		assert UserRole.count() == 1
	}
	def destroy = {
	}
}
