package test.geb

import geb.spock.GebSpec
import io.qameta.allure.Allure
import io.qameta.allure.Step
import pages.geb.pages.DynamicDataLoadingPage

class DynamicDataLoadingPageTest extends GebSpec {

    void "check random photo and name are generated"() {
        given:
//        def fnPattern = ~"(First Name : \\p{L}{0,20})"
        def fnPattern = ~"(First Name : name)"
        def lnPattern = ~"(Last Name : \\p{L}{0,20})"
        to DynamicDataLoadingPage

        when:
        getRundomUserButton.click()


        then:
        getFirstName() ==~ fnPattern
        getLastName() ==~ lnPattern

    }


}
