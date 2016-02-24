package com.ttnd.linksharing

import Enums.Seriousness
import com.ttnd.LinkSharing.Subscription
import com.ttnd.LinkSharing.Topic
import com.ttnd.LinkSharing.User
class SubscriptionController {
    def index() { }
    def delete(long id)
    {
        Subscription subscription = Subscription.get(id)
        if(subscription)
        {
            subscription.delete()
            render("Success")
        }
        else {
            render("Subscription not found")
        }
    }
    def save(long topicId)
    {
        Subscription newSubscription = new Subscription(seriousness:Seriousness.SERIOUS,user:User.findByFirstname(session.user),topic:Topic.get(topicId))

        if(newSubscription.validate())
        {
            newSubscription.save(flush:true)
            render("Success")
        }
        else {
            render("Cannot make subscription")
        }

    }
    def update(int id,String seriousness)
    {
        Subscription subscription = Subscription.findByIdAndSeriousness(id,Seriousness.getSeriousness(seriousness))
        if(subscription.validate())
        {
            subscription.save()
            render("Success")
        }
        else {
            render("Subscription cannot be updated")
        }
    }
}
