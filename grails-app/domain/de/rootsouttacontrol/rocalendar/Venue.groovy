package de.rootsouttacontrol.rocalendar

import java.util.Date;

class Venue {
	
	static hasMany = [events:Event]
	Date dateCreated
	Date lastUpdated
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
	
	String toString() {
		"${name} - ${city}"
	}
}
