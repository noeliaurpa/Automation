package Base;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.Capabilities;

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
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurpi-as\\Downloads\\chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Create driver chrome");
				}else {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\nurpi-as\\Downloads\\geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("Create driver firefox");
				}
			}else {
				String nodeURL = "http://192.168.189.181:5566/wd/hub";
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(browser);
				capabilities.setPlatform(Platform.WINDOWS);
				URL nodeurl = new URL(nodeURL);
				driver = new RemoteWebDriver(nodeurl, capabilities);
			}
			
			
			
			
			
			
			/*
			if (browser.toLowerCase().equals("chrome")) {
				if (executionType.toLowerCase().equals("local")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurpi-as\\Downloads\\chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("Create driver chrome");
				}else {
					String nodeURL = "http://192.168.189.181:5566/wd/hub";
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setBrowserName(browser);
					capabilities.setPlatform(Platform.WINDOWS);
					URL nodeurl = new URL(nodeURL);
					driver = new RemoteWebDriver(nodeurl, capabilities);
				}
			} else {
				if (executionType.toLowerCase().equals("local")) {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\nurpi-as\\Downloads\\geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("Create driver firefox");
				}else {
					
					String nodeURL = "http://192.168.189.181:5566/wd/hub";
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setBrowserName(browser);
					capabilities.setPlatform(Platform.WINDOWS);
					URL nodeurl = new URL(nodeURL);
					driver = new RemoteWebDriver(nodeurl, capabilities);
				}
			}*/
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
