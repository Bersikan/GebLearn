package pages.geb.pages

import geb.Page
import org.openqa.selenium.By

import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths

class FileDownloadDemoPage extends Page {
    private static By headerBy = By.cssSelector("h1")

    static url = "/selenium-playground/generate-file-to-download-demo"
    static at = { $(headerBy).text() == "File Download Demo" }
    static content = {
        inputDataField(required: true) { $("#textbox") }
        generateFileButton(required: true) { $("#create") }
        downloadButton { $("#link-to-download") }
    }


    static String fileContent(String inputFilePath) {
        int maxTime = 10
        Path path
        String value = ""
        for (int i = 0; i < maxTime; i++) {
            try {
                path = Paths.get(inputFilePath)
                value = Files.readAllLines(path).get(0)
            } catch (NoSuchFileException ignored) {
                Thread.sleep(1000)
                i++
            }
        }
        return value
    }

    static void cleanDownloadFolder() {
        Files.walk(Paths.get(System.getProperty("user.dir") + "/downloads"))
                .filter(Files::isRegularFile)
                .forEach(Files::delete)
    }

}
