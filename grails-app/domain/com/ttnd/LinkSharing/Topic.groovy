package com.ttnd.LinkSharing
import Enums.Visibility
class Topic {
    String name;
    static belongsTo = [createdBy: User]
    static hasMany = [subscriptions: Subscription, resources: Resource]
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    static mapping = {
        sort name: "asc"
    }
    static constraints = {
        name(nullable: false, blank: false)//,validator:{ val, obj -> !(Topic.findAllById(createdBy).any(val))})
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        visibility(blank: false, nullable: false, inList: Visibility.values() as List)
        resources(nullable: true)
        subscriptions(nullable: true)
        createdBy(nullable: true)
    }

    public String toString() {
        return name

    }

    public static List<TopicVO> getTrendingTopics() {
        List <Resource>topicList = Resource.createCriteria().list {
            projections {
                groupProperty('topic')
                count('id','counter')
            }
            'topic'{
                property('id')
                property('name')
                property('visibility')
                property('createdBy')
                eq('visibility',Visibility.PUBLIC)
            }
            order('counter','desc')
        }
       List<TopicVO> topicsvo = []
        topicList.eachWithIndex{it,index->
            topicsvo.add(new TopicVO(id: it.getAt(2), name: it.getAt(3), visibility: it.getAt(4), createdBy: it.getAt(5), count: it.getAt(1)))

        }
       return topicsvo
    }
}