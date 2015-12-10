import org.example.Role
import org.example.User
import org.example.UserRole



/**
 * @author Kejia Li
 * @author Ashok Periyaswamy
 * @since 0.0.4
 */
class BootStrap {

	def grailsApplication

	def systemSettingService
	def lexiconService

	def init = { servletContext ->
		User admin = new User(username:'admin', password:'admin', enabled:true).save(flash:true)
		User user = new User(username:'user', password:'user', enabled:true).save(flash:true)

		Role userRole = new Role(authority: 'ROLE_USER').save(flash:true)
		Role adminRole = new Role(authority: 'ROLE_ADMIN').save(flash:true)

		new UserRole(user:user , role:userRole).save(flash:true)
		new UserRole(user:admin, role:adminRole).save(flash:true)
		new UserRole(user:admin, role:userRole).save(flash:true)
	}
}
