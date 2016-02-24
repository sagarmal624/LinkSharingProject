package com.ttnd.linksharing
import com.ttnd.LinkSharing.RatingInfoVO
import com.ttnd.LinkSharing.Resource
import com.ttnd.LinkSharing.ResourceSearchCo
import com.ttnd.LinkSharing.Topic
import com.ttnd.LinkSharing.TopicVO

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
    def search(ResourceSearchCo co)
    {
        List<Resource>resources=Resource.search(co).list()

        render resources.description
    }
    def RatingProperties() {
        Resource resource = Resource.get(5)
        RatingInfoVO ratingInfoVO = resource.ratingInfo
        render "${ratingInfoVO}"
    }
  def show()
  {
      // RatingProperties();

      List<TopicVO>trendingTopics= Topic.getTrendingTopics()
        List concat=[]
      trendingTopics.each{
           concat.add "Id:${it.id},Name:${it.name},CreatedBy:${it.createdBy},Count:${it.count}"
      }
      render concat
  }




}
