package de.rootsouttacontrol.rocalendar



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(EventService)
@Mock([Event, EventService])
class EventServiceTests {

	void testCreatePersistence() {

		def testInstancesEvent = [
			new Event(name: 'NameEvent'
			, startDate: new Date(2012, 05, 01, 18, 0, 0)
			, endDate: new Date(2012, 05, 01, 22, 0, 0)
			, description: 'description'
			, entryFee: 'entryFee'
			, filenameFlyer: 'filenameFlyer'
			, belongsTo: venue
			)
		]
		mockDomain(Event, testInstancesEvent)

		EventService eventService = new EventService()
		eventService.createPersistence(event)

		Event result = Event.findByName("NameEvent")
		assertEquals result.name, event.name
	}
}
