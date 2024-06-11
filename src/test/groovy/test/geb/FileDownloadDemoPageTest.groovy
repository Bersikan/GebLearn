package test.geb

import geb.spock.GebSpec
import org.apache.commons.lang3.RandomStringUtils
import pages.geb.pages.FileDownloadDemoPage

class FileDownloadDemoPageTest extends GebSpec {
    private static inputFilesDirPath = System.getProperty("user.dir") + "\\build\\downloads\\"

    void setupSpec() {
        FileDownloadDemoPage.createInputFileDir(inputFilesDirPath)
    }

    void "check is file downloaded and its content"() {
        given:
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
        assert fileContent(inputFilesDirPath, fileName) == inputContent
    }

    void cleanup() {
        FileDownloadDemoPage.cleanDownloadFolder(inputFilesDirPath)
    }


}
