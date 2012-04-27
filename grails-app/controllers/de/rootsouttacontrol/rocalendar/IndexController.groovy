package de.rootsouttacontrol.rocalendar

import de.rootsouttacontrol.rocalendar.Event

class IndexController {

	def index = {
		def allEvents = getLatestEvents()
		def allVenues = getLatestVenues()
		[latestEvents: allEvents, latestVenues: allVenues]
	}

	private getLatestEvents() {
		def allEvents = Event.findAll()
	}
	
	private getLatestVenues() {
		def allVenues = Venue.findAll()
	}

}
