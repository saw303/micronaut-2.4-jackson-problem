package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.activation.MimeType
import javax.inject.Inject

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    @Inject
    ObjectMapper mapper

    void 'test it works'() {
        expect:
        application.running
    }

    void "Deserialize javax.activation.MimeType"() {

        given:
        String json = ' "application/json" '

        when:
        mapper.readValue(json, MimeType)

        then:
        noExceptionThrown()
    }

}
