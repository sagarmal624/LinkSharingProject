package com.ttnd.LinkSharing
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link_Resource)
class Link_ResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test for Link Resource"() {
        setup:
        Link_Resource link_resource = new Link_Resource(url: url, description: description)
        print(link_resource.properties)
        when:
        Boolean result = link_resource.validate()
        String linkname = link_resource.toString()
        then:
        result == valid
        checklink == linkname.equals(link)

        where:

        url                         | description                 | valid | link                        | checklink
        "https://www.google.co.in/" | "i am from google.LinkSharing "     | true  | "https://www.google.co.in/" | true
        "www.gmail.LinkSharing"             | "i am from gmail.LinkSharing"       | false | "www.gmail.LinkSharing"             | true
        null                        | null                        | false | "hello"                     | false
        13                          | 15                          | false | ""                          | false
        "  "                        | "hello sagaarv "            | false | " "                         | false
        "www.google.LinkSharing"            | ""                          | false | "www.google.LinkSharing"            | true
        "https://www.google.co.in/" | null                        | false | "https://www.google.co.in/" | true
        null                        | "https://www.google.co.in/" | false | "null"                      | false
        "https://www.google.co.in/" | 15                          | false | ""                          | false

    }

}