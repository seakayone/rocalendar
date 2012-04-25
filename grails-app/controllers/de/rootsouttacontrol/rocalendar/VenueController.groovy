package de.rootsouttacontrol.rocalendar

import javax.tools.JavaFileManager.Location;
import grails.plugins.springsecurity.Secured


import org.springframework.dao.DataIntegrityViolationException
import grails.converters.*

class VenueController {
	def geocoderService
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [venueInstanceList: Venue.list(params), venueInstanceTotal: Venue.count()]
    }
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        [venueInstance: new Venue(params)]
    }
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save() {
		def venueLocation = geocoderService.geocodeVenue(params.street, params.city, params.state, params.country)
		
        def venueInstance = new Venue(params + venueLocation)
        if (!venueInstance.save(flush: true)) {
            render(view: "create", model: [venueInstance: venueInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'venue.label', default: 'Venue'), venueInstance.id])
        redirect(action: "show", id: venueInstance.id)
    }

    def show() {
        def venueInstance = Venue.get(params.id)
        if (!venueInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "list")
            return
        }

        [venueInstance: venueInstance]
    }
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit() {
        def venueInstance = Venue.get(params.id)
        if (!venueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "list")
            return
        }

        [venueInstance: venueInstance]
    }
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update() {
        def venueInstance = Venue.get(params.id)
        if (!venueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (venueInstance.version > version) {
                venueInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'venue.label', default: 'Venue')] as Object[],
                          "Another user has updated this Venue while you were editing")
                render(view: "edit", model: [venueInstance: venueInstance])
                return
            }
        }
		
		def venueLocation = geocoderService.geocodeVenue(params.street, params.city, params.state, params.country)
        venueInstance.properties = params + venueLocation

        if (!venueInstance.save(flush: true)) {
            render(view: "edit", model: [venueInstance: venueInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'venue.label', default: 'Venue'), venueInstance.id])
        redirect(action: "show", id: venueInstance.id)
    }
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete() {
        def venueInstance = Venue.get(params.id)
        if (!venueInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "list")
            return
        }

        try {
            venueInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'venue.label', default: 'Venue'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def map = {
		[venue: Venue.get(params.id)]
	}
}
