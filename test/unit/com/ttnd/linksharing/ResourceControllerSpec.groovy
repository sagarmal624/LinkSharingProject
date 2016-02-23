package com.ttnd.linksharing

import com.ttnd.LinkSharing.Resource
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock(Resource)
@TestFor(ResourceController)
class ResourceControllerSpec extends Specification {


    void "test delete"() {
        when:
        controller.delete(id)
        then:
        response.text == result
        where:
        id | result
        10 |"ResourceNotFound"
        11 | "ResourceNotFound"

    }

}
