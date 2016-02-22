package com.ttnd.LinkSharing
class User {
    String username
    String firstname
    String lastname
    String email
    String password
    Boolean admin
    Boolean active
    byte[] photo
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,resource_ratings:Resource_Rating,readingItems:ReadingItem]
    static constraints = {
        username(blank:false,nullable:false,unique:true)
        firstname (blank: false, nullable: false)
        lastname  (blank: false, nullable: false)
        password (blank:false,nullable:false,size:5..10)
        email (email:true ,blank:false,nullable:false,unique:true)
        admin (defaultValue: true,nullable:true)
        photo (size:0..5000000,nullable:true)
        active (defaultValue: true,nullable: true)
        dateCreated(nullable: true,blank:true)
        lastUpdated(nullable:true,blank:true)
        topics(nullable:true)
        subscriptions(nullable:true)
        resources(nullable:true)
        resource_ratings(nullable:true)
        readingItems(nullable:true)

    }
    public String toString()
    {
        return username

    }
}