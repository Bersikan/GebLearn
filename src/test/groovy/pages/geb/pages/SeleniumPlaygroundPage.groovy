package pages.geb.pages

import geb.Page
import org.openqa.selenium.By
import pages.geb.modules.TopNavigationModule


class SeleniumPlaygroundPage extends Page {
    private static By headerBy = By.cssSelector("h1")
    private static By linksBy = By.cssSelector(".container__selenium li")


    static url = "/selenium-playground/"
    static at = { $(headerBy).text() == "Selenium Playground" }
    static content = {
        links { $(linksBy) }
        topNavigationMenu { module(TopNavigationModule) }
        allPageLinkList { $("[href]") }
    }

    void clickLink(String linkName) {
        links.find(By.linkText(linkName)).click()
    }

    List pageLinks() {
        List links = new ArrayList()
        allPageLinkList.forEach { links.add(it.getAttribute("href")) }
        return links
    }

}
