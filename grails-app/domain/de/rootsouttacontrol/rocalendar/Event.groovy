package de.rootsouttacontrol.rocalendar

class Event {

    static constraints = {
		name(blank:false, maxSize:100)
		startDate(attributes:[precision:"minute"])
		endDate(attributes:[precision:"minute"],
			validator:{val, obj->
			return val.after(obj.startDate)})
		description(blank:true, maxSize:1500)
		entryFee(blank:true)
		filenameFlyer(blank:true)
    }

   	Date dateCreated
  	Date lastUpdated	
	static belongsTo = [venue:Venue]
	String name
	Date startDate
	Date endDate
	String description
	String entryFee
	String filenameFlyer

	String toString() {
                "${name}"
        }
}
