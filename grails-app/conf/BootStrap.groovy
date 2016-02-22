import com.ttnd.LinkSharing.Link_Resource
import com.ttnd.LinkSharing.ReadingItem
import com.ttnd.LinkSharing.Resource_Rating
import com.ttnd.LinkSharing.Topic
import com.ttnd.LinkSharing.User
import com.ttnd.LinkSharing.Resource
import com.ttnd.LinkSharing.Document_Resource
import com.ttnd.LinkSharing.Visibility
import com.ttnd.LinkSharing.Seriousness
class BootStrap {
    def createResourceRatings() {
        List<ReadingItem> readingItems = ReadingItem.findAllByIsReadNotEqual(true)
        log.info "before resource rating............."
        readingItems.each {
            it.getUser().addToResource_ratings(new Resource_Rating(score: 2, resource: it.resource, user: it.user)).save(flush: true, failOnError: true)
            log.info "resource rating is dont......................"
        }
    }
    def subscribeTopics()
    {
        (1..2).each {i->

            List<Topic>topics=Topic.findAllByCreatedByNotEqual(User.get(i))
            log.info "------->>>>>"+topics.createdBy
            topics.each {j->
                afterInserted(i,j)
            }
        }


    }
    def createReadingItems(){
        (1..2).each {i->
            log.info "before reading item is created...."
            List<Resource>resources=Resource.findAllByCreatedBy(User.get(i))
            resources.eachWithIndex {j,index->
                if(index%2)
                    j.getCreatedBy().addToReadingItems(new ReadingItem(isRead:true,resource:j)).save(flush:true,failOnError:true)
                else
                    j.getCreatedBy().addToReadingItems(new ReadingItem(isRead:false,resource:j)).save(flush:true,failOnError:true)

                log.info "reading item:${j} is saved"

            }

        }

    }
    def createTopic() {
        (1..2).each { int i ->
            User user = User.get(i)

            log.info(".....creating topic for .userid:.... ${user}...............................")
            if (Topic.countByCreatedBy(user) == 0) {
                (1..5).each {
                    Topic topic = new Topic(name: "Grails${it}", visibility: Visibility.PUBLIC)
                    user = User.get(i).addToTopics(topic).save(flush: true, failOnError: true)
                    if (user == null) {
                        log.error "error during inserting topics to user:${user}"
                    } else {

                        log.info "....Topic is inserted..for User:${user}.."
                        afterInserted(i, topic)
                    }
                }
                log.info "all topics for ${user} are inserted successfullyy...... "

            }
            log.info "....Topics are already exist..for User:${user}.."
        }
    }

    def createResources() {
        (1..2).each { int i ->
            User user = User.get(i)

            log.info(".....creating Link Resources for .userid:.... ${user}...............................")
            if (Resource.countByCreatedBy(user) == 0) {
                (1..5).each {
                    List<Topic> topics = Topic.findAllByName("Grails${it}")

                    topics.each { topic ->

                        (1..2).each {
                            if (linkResource(topic))
                                log.info"....Link resources is inserted..for User:${user}.."
                            else
                                log.info "link resources is not inserted...for user ${user}....."
                        }

                        (1..2).each {
                            if (documentResource(topic))
                                log.info"....document resources is inserted..for User:${user}.."
                            else
                                log.info "document resources is not inserted...for user ${user}....."
                        }


                    }
                }
                log.info "all  resources for ${user} are inserted successfullyy...... "

            }
            log.info "....Topics are already  exist..for User:${user}.."
        }
    }
    Boolean linkResource(Topic topic)
    {

        Link_Resource link_resource = new Link_Resource(topic:topic ,url: "https://www.google.co.in/", description:topic.getName())
        User user = User.get(topic.getCreatedBy().id).addToResources(link_resource).save(flush: true, failOnError: true)


        if (user == null) {
            log.error "error during inserting Link resources to user:${user}"
            return false
        } else {

            return true
        }


    }
    Boolean documentResource(Topic topic)
    {

        Document_Resource document_resource = new Document_Resource(topic:topic ,filepath: "/home/sagar/sg.txt", description:topic.getName())
        User user = User.get(topic.getCreatedBy().id).addToResources(document_resource).save(flush: true, failOnError: true)


        if (user == null) {
            log.error "error during inserting document resources to user:${user}"
            return false
        } else {

            return true
        }
    }

    def afterInserted(int i, Topic topic) {
        log.info "before subscriptions..........."
        topic = topic.addToSubscriptions(user: i, seriousness: Seriousness.VERY_SERIOUS).save(flush: true, failOnError: true)
        if (topic)
            log.info "after subscription................."
        else
            log.error "error during inserting automatic subscriptions...."
    }

    def createUser() {
        if (User.count() == 0) {
            User user = new User(username: "sagar1201624", firstname: "sagar", lastname: "shankhala", password: PasswordConstant.PASSWORD, email: "sagar232112044a@gmail.com", admin: false)
            log.info "................before normal user is inserted........."
            if (user.save(flush: true, failOnError: true) == null)
                log.error(".........Error during normal user is inserted..............")
            else
                log.info ".....normal user is inserted......."



            log.info ".....before admin user is inserted......."
            User admin = new User(username: "sag2ar1063mal", firstname: "sagar", lastname: "shankhala", password: PasswordConstant.PASSWORD, email: "sa123ga2r0a@gmail.com", admin: true)
            if (admin.save(flush: true, failOnError: true) == null)

                log.error(".........Error during admin is inserted..............")
            else
                log.info "admin User is inserted"
        } else
            log.info ".....already Records are exist................"
    }
    def init = {
        log.info "bootstrap is started............."
        createUser()
        createTopic()
        createResources()
        subscribeTopics()
        createReadingItems()
        createResourceRatings()
        log.info "at the end of bootstrap......"
    }
    def destroy = {
    }

}