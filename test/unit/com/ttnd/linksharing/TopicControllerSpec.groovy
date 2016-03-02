package com.ttnd.linksharing

import com.ttnd.LinkSharing.Topic

import com.ttnd.LinkSharing.User
import com.ttnd.LinkSharing.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([Topic, User])
@TestFor(TopicController)
class TopicControllerSpec extends Specification {
    void "test save"() {
        when:
        session.user = user
        controller.save(topicname, visibility)
        then:
        response.text == result
        where:
        user    | topicname    | visibility | result
        "sagar" | "javagrails" | "PUBLIC"   | "success"
        "sagar" | "java"       | "private"  | "success"

    }
    void "topic show"() {
        setup:
        Topic topic = new Topic(id: id, visibility: visbility).save(validate: false)
        when:
        controller.show(id)
        then:
        response.text == "Success"
        where:
        id | visbility
        1  | Visibility.PUBLIC
    }

}
