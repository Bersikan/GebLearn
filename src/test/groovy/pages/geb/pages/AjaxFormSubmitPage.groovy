package pages.geb.pages

import geb.Page
import org.openqa.selenium.By


class AjaxFormSubmitPage extends Page {
    private static By headerBy = By.cssSelector("h1")
    private static By linksBy = By.cssSelector(".container__selenium li")
    public String validationBorderCssValue = "1px solid rgb(255, 0, 0)"


    static url = "/selenium-playground/ajax-form-submit-demo"
    static at = { $(headerBy).text() == "Form Submit Demo" }
    static content = {
        nameField(required: true) { $("#title") }
        nameFieldValidationBorder { nameField.css("border") }
        nameFieldValidation { nameField.previous(".title-validation.validation-error") }
        messageField(required: true) { $("#description") }
        submitButton(required: false) { $("#btn-submit")}
        requestIndicator { $("#submit-control") }
    }

}
