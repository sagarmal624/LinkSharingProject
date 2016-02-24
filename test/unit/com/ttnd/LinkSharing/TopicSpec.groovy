package com.ttnd.LinkSharing

import Enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Test Topic Validation"() {

        setup:

        Topic topic = new Topic(name: name, visibility: visibility, dateCreated: dateCreated, lastUpdated: lastUpdated);
        when:
        Boolean result = topic.validate();
        String topicname = topic.toString()

        then:
        result == valid
        checkname == topicname.equals(validname)
        where:

        name     | visibility         | dateCreated | lastUpdated | valid | validname | checkname
        "grails" | Visibility.PRIVATE | null        | null        | true  | "sagars"  | false
        "java"   | Visibility.PUBLIC  | null        | null        | true  | "java"    | true
        "grails" | Visibility.PRIVATE | ""          | "null"      | true  | "grails"  | true
        "mvc"    | Visibility.PUBLIC  | null        | null        | true  | "mva"     | false
        "hello"  | Visibility.PUBLIC  | null        | null        | true  | "hello"   | true
        "sagar"  | Visibility.PRIVATE | null        | null        | true  | "sagar"   | true
        "sagar"  | Visibility.PUBLIC  | null        | null        | true  | "sagar"   | true
        ""       | Visibility.PRIVATE | null        | null        | false | ""        | false

    }


}