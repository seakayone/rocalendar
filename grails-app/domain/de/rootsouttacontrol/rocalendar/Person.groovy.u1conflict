package de.rootsouttacontrol.rocalendar

class Person extends SecUser {
	Profile profile
	
	static hasMany = [venues: Venue, events: Event]
	
    static constraints = {
		profile(nullable: true, unique: true)
    }
}
