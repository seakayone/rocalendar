package de.rootsouttacontrol.rocalendar

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Venue)
class EventTests {

	protected void setUp() {
		super.setUp()
		Venue venue = new Venue(
				name: 'NameVenue'
				, street: 'street'
				, zip: 'zip'
				, city: 'city'
				, state: 'state'
				, country: 'country'
				, url: 'url'
				, description: 'description'
				, lat: 'lat'
				, lng: 'lng')
		Event event = new Event(
				name: 'NameEvent'
				, startDate: new Date(2012, 05, 01, 18, 0, 0)
				, endDate: new Date(2012, 05, 01, 22, 0, 0)
				, description: 'description'
				, entryFee: 'entryFee'
				, filenameFlyer: 'filenameFlyer'
				, belongsTo: venue
				)
		assertEquals 'nameEvent', event.name
		assertEquals new Date(2012, 05, 01, 18, 0, 0), event.startDate
		assertEquals new Date(2012, 05, 01, 22, 0, 0), event.endDate
		assertEquals 'description', event.description
		assertEquals 'entryFee', event.entryFee
		assertEquals 'filenameFlyer', event.filenameFlyer
		assertEquals venue, event.venue
		 
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testToString() {
		Venue venue = new Venue(
				name: 'NameVenue'
				, street: 'street'
				, zip: 'zip'
				, city: 'city'
				, state: 'state'
				, country: 'country'
				, url: 'url'
				, description: 'description'
				, lat: 'lat'
				, lng: 'lng')
		Event event = new Event(
				name: 'NameEvent'
				, startDate: new Date(2012, 05, 01, 18, 0, 0)
				, endDate: new Date(2012, 05, 01, 22, 0, 0)
				, description: 'description'
				, entryFee: 'entryFee'
				, filenameFlyer: 'filenameFlyer'
				, belongsTo: venue
				)
		assertEquals 'NameEvent', event.toString() 
	}
}
