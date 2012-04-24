package de.rootsouttacontrol.rocalendar

class Venue {
	
	static constraints = {	
		name(blank:false, maxSize:100)
		street()
		zip()
		city(blank:false, maxSize:100)
		state()
		country()
		url(blank:true, nullable:true)
		description(blank:true, maxSize:1500)
		lat()
		lng()
	}
	
	// static hasMany = [events:Event]
	String name
	String street
	String zip
	String city
	String state
	String country
	String url
	String description
	String lat
	String lng

	String toString() {
		"${name} - ${city}"
	}
}
