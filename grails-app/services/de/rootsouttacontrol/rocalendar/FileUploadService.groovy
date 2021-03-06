package de.rootsouttacontrol.rocalendar

import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder

class FileUploadService {

    boolean transactional = true

    def String uploadFile(MultipartFile file, String name, String destinationDirectory) {

        def storagePath = createStoragePathDirectory(destinationDirectory)

        if (!file.isEmpty()) {
            file.transferTo(new File("${storagePath}/${name}"))
            println "Saved file: ${storagePath}/${name}"
            return "${storagePath}/${name}"

        } else {
            println "File ${file.inspect()} was empty!"
            return null
        }
    }
    
    private createStoragePathDirectory(String directoryName) {
    
        def servletContext = ServletContextHolder.servletContext
        def storagePath = servletContext.getRealPath(directoryName)

        // Create storage path directory if it does not exist
        def storagePathDirectory = new File(storagePath)
        if (!storagePathDirectory.exists()) {
            print "CREATING DIRECTORY ${storagePath}: "
            if (storagePathDirectory.mkdirs()) {
                println "SUCCESS"
            } else {
                println "FAILED"
            }
        }
        return storagePath   
    }
}

