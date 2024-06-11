package test.geb

import geb.spock.GebSpec
import pages.geb.pages.SeleniumPlaygroundPage
import pages.geb.utils.PageLinkChecker

class SeleniumPlaygroundTest extends GebSpec {

    void "check there is no broken links on the page"() {
        given:
        to SeleniumPlaygroundPage

        when:
        at SeleniumPlaygroundPage

        then:
        assert PageLinkChecker.collectBrokenLinks(pageLinks()[0..4]).size() == 0
    }

}
