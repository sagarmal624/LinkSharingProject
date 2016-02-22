package com.ttnd.LinkSharing


import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {


    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    @Unroll
    void "Test User Validation"() {

        setup:
        User user = new User(username: uname, firstname: fname, lastname: lname, email: mail, password: pwd, admin: admn, active: active, dateCreated: dateCreated, lastUpdated: lastUpdated)
        println(user.properties)
        when:
        Boolean result = user.validate()
        String username = user.toString()
        then:
        result == valid
        username.equals(validname)
        where:
        uname         | fname      | lname       | mail           | pwd           | admn  | active | dateCreated    | lastUpdated    | valid | validname
        "sagar"       | "sagar"    | "mal"       | "sa@gm.LinkSharing"    | "amaxx"       | true  | true   | null           | null           | true  | "sagar"
        "sagarmal624" | ""         | null        | "sa@gm.LinkSharing"    | "sagar"       | false | false  | null           | new Date()     | false | "sagarmal624"
        "123"         | null       | "sagar  "   | null           | "12345670890" | true  | null   | null           | new Date()     | false | "123"
        "sagar"       | "sagarmal" | "shankhala" | "sagar@gm.LinkSharing" | "125"         | false | true   | 02 - 01 - 1993 | 02 - 01 - 1993 | false | "sagar"
        "sagar"       | " "        | " "         | ""             | ""            | null  | null   | null           | null           | false | "sagar"
        "shankhala"   | null       | null        | null           | null          | null  | null   | null           | true           | false | "shankhala"

    }

}