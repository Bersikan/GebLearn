package test.geb

import geb.spock.GebSpec
import pages.geb.pages.DragAndDropDemoPage

class DragAndDropPageTest extends GebSpec {

    void "check drag and drop is work correctly"() {
        given:
        to DragAndDropDemoPage
        when:
        at DragAndDropDemoPage
        draggAndDrop(draggable1, dropZone1)
        draggAndDrop(draggable2, dropZone1)
        dropZone2.css("background") == "rgb(233, 233, 233)"
        dropZone2.$(text: "Drop here").isDisplayed()
        draggAndDrop(draggable3, dropZone2)

        then:
        dropList.$(text: "Draggable 1").isDisplayed()
        dropList.$(text: "Draggable 2").isDisplayed()
        dropZone2.$(text: "Dropped!").isDisplayed()
        dropZone2.css("background-color") == "rgba(14, 186, 197, 1)"
    }
}
