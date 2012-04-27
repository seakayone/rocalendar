package de.rootsouttacontrol.rocalendar

class GeocoderService {

    boolean transactional = false

    def geocodeVenue(String street, String city, String state, String country) {
	
		def result = [:]
		def base = 'http://maps.google.com/maps/api/geocode/xml?'
		def params = [sensor:false,address:[street,city,state,country].collect { URLEncoder.encode(it,'UTF-8') }.join(',+')]
		def url = base + params.collect { k,v -> "$k=$v" }.join('&')
		def response = new XmlSlurper().parse(url)

		result.lat = response.result.geometry.location.lat.text().substring(0, 10)
		result.lng = response.result.geometry.location.lng.text().substring(0, 10)

		//	assert Math.abs(-74.0059729 - result.lat.toDouble()) < 0.0001
		//	assert Math.abs(-74.0059729 - result.lng.toDouble()) < 0.0001
		// debug
		//result.street = street
		//result.city = city
		//result.state = state
		//result.country = country
		//result.url = url

		return result 

    }

}
