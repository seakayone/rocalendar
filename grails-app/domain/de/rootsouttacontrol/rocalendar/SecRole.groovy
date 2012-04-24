package de.rootsouttacontrol.rocalendar

class SecRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
