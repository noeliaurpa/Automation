package Base;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	// Se crea el objeto que abrirá el explorador para iniciar todas las pruebas
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	@Parameters({ "browser", "baseURL", "executionType" })
	public static void setupDriver(String browser, String baseUrl, String executionType) throws Exception {
		driver = createDriver(browser, baseUrl, executionType);
	}

	private static WebDriver createDriver(String browser, String baseUrl, String executionType) throws Exception {
		try {
			
			if (executionType.toLowerCase().equals("local")) {
				if (browser.toLowerCase().equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Create driver chrome");
				}else {
					System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("Create driver firefox");
				}
			}else {
				Runtime.getRuntime().exec("cmd.exe /C start \"start hub\" \".\\resources\\Hub.bat\"");
				Runtime.getRuntime().exec("cmd.exe /C start \"start hub\" \".\\resources\\Node.bat\"");
				String nodeURL = "http://192.168.189.181:5567/wd/hub";
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(browser);
				capabilities.setPlatform(Platform.WINDOWS);
				URL nodeurl = new URL(nodeURL);
				driver = new RemoteWebDriver(nodeurl, capabilities);
			}
			
			driver.manage().window().maximize();
			driver.get(baseUrl);
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			System.out.println("EL ERROR ES: "+e);
			return driver;
		}

	}

	// Este metodo lo tengo que agregar en una clase aparte
	@AfterTest
	public static void closeDriver() {
		// cierra el objeto, por lo tanto cierra el navegador
		// driver.close();
		driver.quit();
	}
}
