package de.rootsouttacontrol.rocalendar

import de.rootsouttacontrol.rocalendar.Event

class IndexController {

	def index = {
		[
			latestEvents: getLatestEvents()
			, latestVenues: getLatestVenues()
			, upcomingEvents: getUpcomingEvents()
		]
	}

	private getLatestEvents() {
		return Event.listOrderByDateCreated(max: 5, order: "desc");
	}
	
	private getLatestVenues() {
		return Venue.listOrderByDateCreated(max: 5, order: "desc");
	}
	
	private getUpcomingEvents() {
		def upcomingEvents = Event.findAllByStartDateBetween(new Date(), new Date() + 14, [max: 5, sort: "startDate", order: "asc"])
	}

}
