package com.ttnd.linksharing

import com.ttnd.LinkSharing.Subscription
import com.ttnd.LinkSharing.Topic
import com.ttnd.LinkSharing.User
import com.ttnd.LinkSharing.Visibility

class TopicController {

    def index() { }
    def show(){
        println"0...............show id...." +params.id
        Topic topic=Topic.get(params.id)
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
