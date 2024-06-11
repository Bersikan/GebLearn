import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

String projectPath =System.getProperty("user.dir")

ChromeOptions options = new ChromeOptions()
options.addArguments("--start-maximized")
Map<String, Object> prefs = new HashMap<String, Object>()
prefs.put("profile.default_content_settings.popups", 0)
prefs.put("download.prompt_for_download", false)
prefs.put("download.default_directory", "${projectPath}\\downloads\\")
options.setExperimentalOption("prefs", prefs)
driver = {
    new ChromeDriver(options)
}

baseUrl = "https://www.lambdatest.com"

//cacheDriverPerThread = true

//there is some issue with current geb and spock.
