package com.ttnd.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.LinkSharing.User

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock(User)
@TestFor(LoginController)
class LoginControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "test index"() {
        setup:
        session.user = user
        when:
        controller.index()
        then:
        response.forwardedUrl == "/user/index"
        where:
        user << ["user1"]
    }

    void "login Handler test"() {
        setup:
        User user = new User(username: username, password: password)
        user.active = active
        user.save(validate: false)
        when:
        controller.loginHandler(username, password,active)
        then:
        response.forwardedUrl == "/login/index"
        where:
        username | password | active
        "sagar"  | "sagar"  |true
    }

    void "test invalidate"() {
        setup:
        session.user = "sagar"
        when:
        controller.logout()
        then:
        session.user == null
    }


}
