package com.ttnd.LinkSharing

class Resource_Rating {
    static belongsTo = [resource: Resource, user: User]
    Integer score;
    static constraints = {
        score(validator: {Integer val->(1..5).contains(val) })
        user(nullable: true)
        resource(nullable: true)
    }
}