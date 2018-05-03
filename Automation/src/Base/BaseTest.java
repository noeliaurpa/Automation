package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	// Se crea el objeto que abrirá el explorador para iniciar todas las pruebas
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	// Este metodo lo tengo que agregar a una clase aparte
	@BeforeClass
	@Parameters({ "browser", "baseURL" })
	public static void setupDriver(String browser, String baseUrl) throws Exception {
		driver = createDriver(browser, baseUrl);
	}

	private static WebDriver createDriver(String browser, String baseUrl) throws Exception {
		if (browser.toLowerCase().equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurpi-as\\Downloads\\chromedriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capability);
			System.out.println("Create driver chrome");
		} else {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nurpi-as\\Downloads\\geckodriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capability);
			System.out.println("Create driver firefox");
		}
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}

	// Este metodo lo tengo que agregar en una clase aparte
	@AfterClass
	public static void closeDriver() {
		// cierra el objeto, por lo tanto cierra el navegador
		// driver.close();
		driver.quit();
	}
}
