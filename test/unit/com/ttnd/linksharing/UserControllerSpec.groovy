package com.ttnd.linksharing

import com.ttnd.linksharing.UserController
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.LinkSharing.User;

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock(User)
@TestFor(UserController)
class UserControllerSpec extends Specification {


    void "test register"() {

        when:
        controller.register(firstname, lastname, email, username, password, cpassword)
        then:
        response.text == result
        where:
        firstname | lastname    | email             | username  | password | cpassword | result
        "sagar"   | "shankhala" | "sagar@gmail.com" | "sagar"   | "123445" | "123445"  | "success"
        "sagar"   | "shankhala" | "sagar@gmail.com" | "sagar"   | "1245"   | "123445"  | "error"
        ""        | ""          | null              | "sagar12" | ""       | ""        | "error"
    }

    void "test index action"() {

        when:
        session.user = user;
        controller.index()
        then:
        response.text == result
        where:
        user      | result
        "sagar"   | "sagar Dashboard"
        "diwakar" | "diwakar Dashboard"
        null      | "null Dashboard"
    }

}
