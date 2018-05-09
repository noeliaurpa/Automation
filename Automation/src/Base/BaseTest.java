package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
			if (browser.toLowerCase().equals("chrome")) {
				if (executionType.toLowerCase().equals("local")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurpi-as\\Downloads\\chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Create driver chrome");
				}else {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurpi-as\\Downloads\\chromedriver.exe");
					DesiredCapabilities capability = DesiredCapabilities.chrome();
					driver = new ChromeDriver(capability);
					System.out.println("Create driver chrome");
				}
			} else {
				if (executionType.toLowerCase().equals("local")) {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\nurpi-as\\Downloads\\geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("Create driver firefox");
				}else {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\nurpi-as\\Downloads\\geckodriver.exe");
					DesiredCapabilities capability = DesiredCapabilities.firefox();
					driver = new FirefoxDriver(capability);
					System.out.println("Create driver firefox");
				}
			}
			driver.manage().window().maximize();
			driver.get(baseUrl);
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
