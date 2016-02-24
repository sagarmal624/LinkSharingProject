package com.ttnd.linksharing

import com.ttnd.LinkSharing.Resource
import com.ttnd.LinkSharing.ResourceSearchCo
import com.ttnd.LinkSharing.Subscription
import com.ttnd.LinkSharing.Topic
import com.ttnd.LinkSharing.User
import Enums.Visibility
class TopicController {
    def save(String topicname,String visibility){
         User user=User.findByFirstname(session.user)
         Topic topic=new Topic(name:topicname,createdBy:user,visibility:Visibility.toEnum(visibility)).save(flash:true,failOnError:"true")
         if(topic==null)
         {
             flash.error="Validation Error"
           render flash.error
         }else {
             render "success"
         }
    }
    def show(long id, ResourceSearchCo co){

        List<Resource>resources=Resource.search(co).list()
        println "----------------====>>>>"+resources
      Topic topic=Topic.read(id)

        if(topic==null)
          {
              flash.error="Topic is not found with given id"
           redirect(action:"index",controller:"login")
          }else{
              if(topic.visibility==Visibility.PUBLIC)
              {
                  render "Success"
              }else {
                  Subscription subscription=Subscription.findByUserAndTopic(User.findByFirstname(session.user),topic)
                          if(subscription){
                              flash.error="Topic is not private and not subscribe by loged in user"
                              forward(controller:"login",action:"index")
                          }else {

                              render "success"
                          }

              }
          }

    }
}
