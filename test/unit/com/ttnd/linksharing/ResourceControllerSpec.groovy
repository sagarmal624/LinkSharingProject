package com.ttnd.linksharing

import com.ttnd.LinkSharing.Link_Resource
import com.ttnd.LinkSharing.Resource
import com.ttnd.LinkSharing.Topic
import grails.test.mixin.Mock
import com.ttnd.LinkSharing.User

import grails.test.mixin.TestFor
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Resource, Link_Resource, Topic, User])
@TestFor(ResourceController)
class ResourceControllerSpec extends Specification {

   void "test delete"() {
        setup:
        User user = new User().save(validate: false)
        Topic topic = new Topic().save(validate: false)
        Resource resource = new Link_Resource(createdBy: user, id: id, url: "https://web.whatsapp.com/", topic: topic, description: "hello sagar").save(validate: false)
        when:
        controller.delete(id)
        then:
        response.text == "Success"
        where:
        id<<10
    }
}
