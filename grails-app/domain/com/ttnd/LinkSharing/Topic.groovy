package com.ttnd.LinkSharing

class Topic {
    String name;
    static belongsTo = [createdBy:User]
    static hasMany = [subscriptions:Subscription,resources:Resource]
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static constraints = {
        name(nullable:false,blank:false)//,validator:{ val, obj -> !(Topic.findAllById(createdBy).any(val))})
        dateCreated(nullable:true)
        lastUpdated(nullable:true)
        visibility (blank:false,nullable: false,inList: Visibility.values() as List)
        resources(nullable: true)
        subscriptions(nullable: true)
        createdBy(nullable: true)
    }
    public String toString()
    {
        return name

    }

}