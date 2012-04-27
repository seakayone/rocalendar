package de.rootsouttacontrol.rocalendar



class GeocoderService {

    boolean transactional = false

    def geocodeVenue(String street, String city, String state, String country) {
	
		def result = [:]
		def base = 'http://maps.google.com/maps/api/geocode/xml?'
		def params = [sensor:false,address:[street,city,state,country].collect { URLEncoder.encode(it,'UTF-8') }.join(',+')]
		def url = base + params.collect { k,v -> "$k=$v" }.join('&')
		def response = new XmlSlurper().parse(url)

		result.lat = response.result.geometry.location.lat.text().split('\\.')[0,1].join('.')
		result.lng = response.result.geometry.location.lng.text().split('\\.')[0,1].join('.')

		return result 

    }

}
