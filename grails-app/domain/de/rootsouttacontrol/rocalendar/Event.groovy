package de.rootsouttacontrol.rocalendar

class Event {
	
	static belongsTo = [venue:Venue]
   	Date dateCreated
  	Date lastUpdated
	String name
	Date startDate
	Date endDate
	String description
	String entryFee
	String filenameFlyer

	static constraints = {
		name(blank:false, maxSize:100)
		startDate(blank:false, attributes:[precision:"minute"])
		endDate(blank:true, attributes:[precision:"minute"],
			validator:{val, obj->
			return val.after(obj.startDate)})
		description(blank:true, maxSize:1500)
		entryFee(blank:true)
		filenameFlyer(blank:true)
	}

	String toString() {
                "${name}"
        }
}
