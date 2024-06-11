package test.geb

import geb.spock.GebSpec
import org.apache.commons.lang3.RandomStringUtils
import pages.geb.pages.AjaxFormSubmitPage
import spock.lang.Unroll

class AjaxFormSubmitTest extends GebSpec {
    
    @Unroll
    def "check Ajax form submit when name: '#name' and description: '#description'"() {
        given:
        to AjaxFormSubmitPage
        when:
        at AjaxFormSubmitPage
        nameField << name
        messageField << description
        submitButton.click()
        then:
        verifyAll {
            !submitButton.isDisplayed()
            requestIndicator.isDisplayed()
            messageField.value() == description
            nameField.value() == name

        }

        where:
        [name, description] << [["test", "123", "@#\$%"],
                                ["test", "123", "", "@#\$%"]].combinations()
    }

    def "check fields can accept unlimited strings size"() {
        given:
        String value = RandomStringUtils.randomAlphabetic(10000)
        to AjaxFormSubmitPage
        when:
        at AjaxFormSubmitPage
        nameField << value
        messageField << value
        and:
        submitButton.click()
        then:
        verifyAll {
            !submitButton.isDisplayed()
            requestIndicator.isDisplayed()
            nameField.value().length() == 10000
            messageField.value().length() == 10000
        }
    }

    @Unroll
    def "check Ajax form submit: empty name leads to an error with any description: #description"() {
        given:
        to AjaxFormSubmitPage
        when:
        at AjaxFormSubmitPage
        messageField << description
        submitButton.click()
        then:
        verifyAll {
            nameField.value() == ""
            nameFieldValidationBorder == validationBorderCssValue
            nameFieldValidation.isDisplayed()
            submitButton.isDisplayed()
        }

        where:
        description << ["test", "123", "", "@#\$%"]
    }


}
