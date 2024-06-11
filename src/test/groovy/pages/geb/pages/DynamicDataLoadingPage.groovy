package pages.geb.pages

import geb.Page
import io.qameta.allure.Step
import org.openqa.selenium.By


class DynamicDataLoadingPage extends Page {
    private static By headerBy = By.cssSelector("h1")
    private static String randomPhotoPath = "https://randomuser.me/api/portraits/"

    static url = "/selenium-playground/dynamic-data-loading-demo"
    static at = { $(headerBy).text() == "Dynamic Data Loading" }
    static content = {
        getRundomUserButton(required: true) { $("#save") }
        resultContainer { $("#loading") }
        photo(waitCondition: { it.getAttribute("src").startsWith(randomPhotoPath) }) { $("#loading img") }
    }

    String getFirstName() {
        waitFor { resultContainer.text().contains("First Name") }
        return resultContainer.text().split("\n\n")[0]
    }

    String getLastName() {
        waitFor { resultContainer.text().contains("Last Name") }
        return resultContainer.text().split("\n\n")[1]
    }

}
