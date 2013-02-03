package de.rootsouttacontrol.rocalendar

class Profile {

	String email
	
    static constraints = {
		email(unique: true)
    }
}
