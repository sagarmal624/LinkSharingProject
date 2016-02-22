package com.ttnd.LinkSharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Document_Resource)
class Document_ResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test for Document Resource"() {

        setup:
        Document_Resource document_resource = new Document_Resource(filepath: filepath, description: description)
        println(document_resource.properties)
        when:
        Boolean result = document_resource.validate()
        String path = document_resource.toString()
        then:
        result == valid
        checkpath == path.equals(checkfilepath)
        where:
        sno | filepath                | description         | valid | checkfilepath           | checkpath

        1   | "/home/sagar/sagar.txt" | "hello sagar"       | true  | "/home/sagar/sagar.txt" | true
        2   | null                    | "how are you"       | false | null                    | true
        3   | 123                     | ""                  | false | 123                     | false
        4   | ""                      | null                | false | ""                      | false
        5   | "/home/sagar"           | "i am fine and you" | true  | "/home/sagar"           | true
        6   | null                    | null                | false | null                    | true
        7   | 13                      | 15                  | false | 13                      | false
        8   | ""                      | ""                  | false | ""                      | false

    }

}
