package de.rootsouttacontrol.rocalendar

class GeoIpLookupService {

	boolean transactional = false
	def geoIpService

	def getLocation(String ipAddress) {
		def location = geoIpService.getLocation(ipAddress)
            	return location
	}	
}
