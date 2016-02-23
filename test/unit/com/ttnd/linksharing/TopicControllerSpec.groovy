package com.ttnd.linksharing

import com.ttnd.LinkSharing.Topic

import com.ttnd.LinkSharing.User
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
}
