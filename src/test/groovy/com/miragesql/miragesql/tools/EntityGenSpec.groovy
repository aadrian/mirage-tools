package com.miragesql.miragesql.tools

import spock.lang.Specification

class EntityGenSpec extends Specification {
    def "validateLang() valid data"() {
        expect:
            EntityGen.validateLang(lang) == result

        where:
            lang     || result
            "java"   || true
            "groovy" || true
    }

    def "validateLang() invalid data"() {
        when:
            EntityGen.validateLang(lang)

        then:
            def error = thrown(expectedException)
            error.message == expectedMessage

        where:
            lang     || expectedException          | expectedMessage
            null     || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            ""       || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "Java"   || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "Groovy" || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "scala"  || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "edn"    || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "xml"    || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
            "json"   || IllegalArgumentException   | "Argument 'lang' must be 'java' or 'groovy' only!"
    }

}
