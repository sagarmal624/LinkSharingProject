package com.ttnd.LinkSharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Resource_Rating)
class Resource_RatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test Resource Rating"() {

        setup:
        Resource_Rating resource_rating = new Resource_Rating(score: score)
        when:
        println(resource_rating.properties)
        Boolean result = resource_rating.validate()
        println("XXX validate"+resource_rating.validate())
        then:
        result == valid
        where:
        score | valid
        4     | true
        10    | false
        1     | true
        5     | true
        null  | false
        ""    | false

    }

}