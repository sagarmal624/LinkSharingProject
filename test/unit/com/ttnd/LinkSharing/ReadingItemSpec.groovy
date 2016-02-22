package com.ttnd.LinkSharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test for ReadingItem"() {
        setup:
        ReadingItem readingItem = new ReadingItem(isRead: isread)
        when:
        Boolean result = readingItem.validate()
        then:
        result == valid
        where:
        isread | valid
        true   | true
        false  | true
        null   | false


    }

}