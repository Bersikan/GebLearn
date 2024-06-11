package pages.geb.pages

import geb.Page
import geb.navigator.Navigator
import org.openqa.selenium.By

class DragAndDropDemoPage extends Page {
    private static By headerBy = By.cssSelector("h1")
    static url = "/selenium-playground/drag-and-drop-demo"
    static at = { $(headerBy).text() == "Drag and Drop Demo" }

    static content = {
        draggable1 { $("span", text: "Draggable 1") }
        draggable2 { $("span", text: "Draggable 2") }
        dropZone1 { $("#mydropzone") }
        dropList { $("#droppedlist") }

        draggable3 { $("#draggable") }
        dropZone2 { $("#droppable") }
    }


    void draggAndDrop(Navigator from, Navigator to) {
        interact {
            dragAndDrop(from, to)
        }
    }

}
