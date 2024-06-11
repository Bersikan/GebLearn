package pages.geb.modules

import geb.Module
import org.openqa.selenium.By

class TopNavigationModule extends Module {
    private static By headerMenuBy = By.cssSelector(".header__menu")
    private static By menuContentBy = By.cssSelector(".table__main .grid.product__dropdown")


    static content = {
        menu { $(headerMenuBy) }
    }

    def openMenu(String menu) {
        interact {
            moveToElement($(headerMenuBy).$("a", text: menu))
        }
    }

    def openSubMenu(String name) {
        $(".table__main .grid.product__dropdown").$("p", text: name).click()
    }

}
