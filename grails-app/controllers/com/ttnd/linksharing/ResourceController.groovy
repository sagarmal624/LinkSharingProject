package com.ttnd.linksharing
import com.ttnd.LinkSharing.Resource
class ResourceController {
    def index() {}
    def delete(long id) {
        log.info "befor delete the resource"
        def resource = Resource.load(id)
        println "--------------resource object----->"+resource
        if (resource==null) {
            flash.error="ResourceNotFound"
         render flash.error
          // forward(action:"index",controller:"login")
        } else {
            resource.delete(flush:true)
         render "deleted"
        }
    }
}
