import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

ChromeOptions options = new ChromeOptions()
options.addArguments("--start-maximized")

driver = {
    new ChromeDriver(options)
}

baseUrl = "https://www.lambdatest.com"

//cacheDriverPerThread = true

//there is some issue with current geb and spock.
