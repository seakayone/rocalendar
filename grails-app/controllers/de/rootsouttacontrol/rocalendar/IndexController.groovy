package de.rootsouttacontrol.rocalendar

import de.rootsouttacontrol.rocalendar.Event

class IndexController {

	def index = {  
		def allEvents = Event.findAll()
		def allVenues = Venue.findAll()
		[latestEvents: allEvents, latestVenues: allVenues]
    }
}
