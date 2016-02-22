package com.ttnd.LinkSharing

class Subscription {

    static belongsTo=[user:User,topic:Topic]
    Seriousness seriousness;
    static constraints = {
        seriousness(nullable: false,blank:false)
        user(nullable:true )
        topic(nullable:true)

    }
}