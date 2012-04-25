class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"index")
		"/status"(view:"/status")
		"500"(view:'/error')
	}
}
