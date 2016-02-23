package com.ttnd.linksharing

import com.ttnd.LinkSharing.Subscription
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock(Subscription)
@TestFor(SubscriptionController)
class SubscriptionControllerSpec extends Specification {
    void "test delete"() {
        when:
        controller.delete(id)
        then:
        response.text == result
        where:
        id  | result
        123 | "Success"
        16  | "Subscription not found"
    }

}
