package com.ttnd.linksharing

import com.ttnd.LinkSharing.Seriousness
import com.ttnd.LinkSharing.Subscription
import com.ttnd.LinkSharing.Topic

import com.ttnd.LinkSharing.User;
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(SubscriptionController)
@Mock([Subscription, User, Topic])
class SubscriptionControllerSpec extends Specification {
    void "test delete"() {
        setup:
        User user = new User().save(validate: false)
        Topic topic = new Topic().save(validate: false)
        Subscription subscription = new Subscription(user: user, topic: topic)
        subscription.id = id
        subscription.save(validate: false)
        when:
        controller.delete(id)
        then:
        response.text.equals(result)
        where:
        id | result
        12 | "Success"


    }

    void "test save"() {
        setup:
        User user = new User().save(validate: false)
        session.user = user
        Topic topic = new Topic()
        topic.id = id
        topic.save(validate: false)
        when:
        controller.save(id)
        then:
        response.text == result
        where:
        id | result
        12 | "Success"
    }

    void "test update"() {
        setup:
        User user = new User().save(validate: false)
        Subscription subscription = new Subscription(user: user,seriousness: Seriousness.SERIOUS)
        subscription.id = id
        subscription.save(validate: false)
        when:
        controller.update(id, seriousness)
        then:
        response.text == result
        where:
        id | seriousness | result
        12 | "serious"   | "Success"

    }

}
