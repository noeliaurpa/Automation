package Base;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

	static String[] menuNav = { "ctl00_TopMenuRepeater_ctl00_MenuLink", "ctl00_TopMenuRepeater_ctl01_MenuLink",
			"ctl00_TopMenuRepeater_ctl02_MenuLink", "ctl00_LoginView_LoginLink", "ctl00_LoginView_RegisterLink",
			"ctl00_BrowseAllLink" };
	static WebDriver driver;

	//constructor que reciba el driver
	//Investigar cuando se utiliza un try catch
	public BasePage(WebDriver _driver){
		driver = super.getDriver();
	}
	
	public boolean verifypresenceOfElementLocated(String id) {
		// Se crea un wait para darle como un tiempo para poder encontrar el elemento
		// con el id seleccionado, en el tiempo
		// se le asignan 3 segundos para encontrar el elemento si no existe muestra un
		// mensaje.

		WebDriverWait wait = new WebDriverWait(driver, 3);
		//Hablar con purro y que me diga un caso explicito donde utilizar el try catch
		
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		return element.isDisplayed();
	}

	public void logoutUser(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		clickOnElement(element);
	}
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendKeysToElement(WebElement element, String userData) {
		element.sendKeys(userData);
	}

	public static boolean waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element.isDisplayed();
	}

	@SuppressWarnings("unlikely-arg-type")
	public static boolean verifyLoadsMenu() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element;
		boolean ShowElements = true;
		boolean[] validateDisplayElements = new boolean[menuNav.length];

		for (int i = 0; i < menuNav.length; i++) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(menuNav[i])));
			validateDisplayElements[i] = element.isDisplayed();
		}

		if (Arrays.asList(false).contains(validateDisplayElements)) {
			ShowElements = false;
		}
		return ShowElements;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean verifyLoadFiels(String[] list) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element;
		boolean[] validateDisplayElements = new boolean[list.length];
		for (int i = 0; i < list.length; i++) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(list[i])));
			validateDisplayElements[i] = element.isDisplayed();
		}
		if (Arrays.asList(false).contains(validateDisplayElements)) {
			return false;
		}
		return true;
	}

}