package com.ttnd.LinkSharing

abstract class Resource {
    String description;
    Date dateCreated;
    Date lastUpdated;
    static  transients=['ratingInfo']
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
    RatingInfoVO getRatingInfo() {
        List result = Resource_Rating.createCriteria().get {
            projections {
                count('id')
                sum('score')
                avg('score')
            }
            eq('user', User.get(1))
        }
        new RatingInfoVO(totalVotes: result[0], totalScore: result[1],averageScore: result[2])
    }

    static namedQueries = {
        search { ResourceSearchCo co ->

            if (co.topicId) {
                eq('topic_id', co.topicId)
            }
            if(co.visibility){
                'topic'{
                     eq("visibility",co.visibility)
                }

            }
           }
    }
}