package test.geb

import geb.spock.GebSpec
import org.apache.commons.lang3.RandomStringUtils
import pages.geb.pages.FileDownloadDemoPage

import java.nio.file.Paths

class FileDownloadDemoPageTest extends GebSpec {

    void "check is file downloaded and its content"() {
        given:
        String inputContent = RandomStringUtils.randomAlphabetic(30)
        to FileDownloadDemoPage
        when:
        at FileDownloadDemoPage
        and:
        inputDataField << inputContent
        generateFileButton.click()
        downloadButton.click()
        then:
        String filePath = Paths.get(System.getProperty("user.dir") + "\\downloads\\Lambdainfo.txt")
        assert fileContent(filePath) == inputContent
    }

    void cleanupSpec() {
        FileDownloadDemoPage.cleanDownloadFolder()
    }


}
