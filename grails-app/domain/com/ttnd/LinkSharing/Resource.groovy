package com.ttnd.LinkSharing


abstract class Resource {
    String description;
    Date dateCreated;
    Date lastUpdated;
    static belongsTo = [createdBy:User,topic:Topic]
    static hasMany = [resource_ratings:Resource_Rating,readingItems:ReadingItem]
    static constraints = {

        description(nullable: false,blank: false,validator:{val,obj->!(val.isInteger())})
        dateCreated(nullable:true)
        lastUpdated(nullable:true)
        createdBy(nullable:true)
        topic(nullable:true)
        resource_ratings(nullable:true)
        readingItems(nullable:true)
    }
}