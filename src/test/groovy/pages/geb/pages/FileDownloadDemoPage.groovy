package pages.geb.pages

import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.FluentWait

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Duration

class FileDownloadDemoPage extends Page {
    private static By headerBy = By.cssSelector("h1")

    static url = "/selenium-playground/generate-file-to-download-demo"
    static at = { $(headerBy).text() == "File Download Demo" }
    static content = {
        inputDataField(required: true) { $("#textbox") }
        generateFileButton(required: true) { $("#create") }
        downloadButton { $("#link-to-download") }
    }

    static String fileContent(String inputFilePath, String fileName) {
        String value = ""
        if (isFileDownloaded(inputFilePath, fileName)) {
            Path path = Paths.get("${inputFilePath}\\${fileName}")
            value = Files.readAllLines(path).get(0)
        }
        return value
    }

    static boolean isFileDownloaded(String dirPath, String fileName) {
        File file = new File(dirPath, fileName)
        FluentWait<File> wait = new FluentWait<File>(file)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("No file was downloaded")
        return wait.until(f -> f.exists() && f.canRead())
    }

    static void cleanDownloadFolder() {
        Files.walk(Paths.get(System.getProperty("user.dir") + "/downloads"))
                .filter(Files::isRegularFile)
                .forEach(Files::delete)
    }

}
