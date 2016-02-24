package com.ttnd.LinkSharing

import Enums.Seriousness
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test for Subscriptions"() {

        setup:
        Subscription subscription = new Subscription(seriousness: seriousness)
        when:
        Boolean result = subscription.validate()
        then:
        result == valid;
        where:

        seriousness              | valid
        Seriousness.SERIOUS      | true
        Seriousness.CASUAL       | true
        Seriousness.VERY_SERIOUS | true
        null                     | false
        ""                       | false

    }

}