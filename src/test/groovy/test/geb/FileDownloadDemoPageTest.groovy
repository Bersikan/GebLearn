package test.geb

import geb.spock.GebSpec
import org.apache.commons.lang3.RandomStringUtils
import pages.geb.pages.FileDownloadDemoPage

import java.nio.file.Paths

class FileDownloadDemoPageTest extends GebSpec {

    //toDo: fix test case to be compatible CI/CD systems
    void "check is file downloaded and its content"() {
        given:
        String filePath = Paths.get(System.getProperty("user.dir") + "\\downloads\\")
        String fileName = "Lambdainfo.txt"
        String inputContent = RandomStringUtils.randomAlphabetic(30)
        to FileDownloadDemoPage

        when:
        at FileDownloadDemoPage

        and:
        inputDataField << inputContent
        generateFileButton.click()
        downloadButton.click()

        then:
        assert fileContent(filePath, fileName) == inputContent
    }

    void cleanupSpec() {
        FileDownloadDemoPage.cleanDownloadFolder()
    }


}
