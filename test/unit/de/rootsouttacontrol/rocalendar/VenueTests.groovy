package de.rootsouttacontrol.rocalendar

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Venue)
class VenueTests {

	protected void setUp() {
		super.setUp()
		Venue venue = new Venue(
				name: 'name'
				, street: 'street'
				, zip: 'zip'
				, city: 'city'
				, state: 'state'
				, country: 'country'
				, url: 'url'
				, description: 'description'
				, lat: 'lat'
				, lng: 'lng')
		assertEquals "name", venue.name
		assertEquals "street", venue.street
		assertEquals "zip", venue.zip
		assertEquals "city", venue.city
		assertEquals "state", venue.state
		assertEquals "country", venue.country
		assertEquals "url", venue.url
		assertEquals "description", venue.description
		assertEquals "lat", venue.lat
		assertEquals "lng", venue.lng
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testToString() {
		def v = new Venue(
				name: 'name'
				, street: 'street'
				, zip: 'zip'
				, city: 'city'
				, state: 'state'
				, country: 'country'
				, url: 'url'
				, description: 'description'
				, lat: 'lat'
				, lng: 'lng')
		assertEquals "name - city", v.toString() 
	}
}
