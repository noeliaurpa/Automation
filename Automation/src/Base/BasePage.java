package Base;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest{

	static String[] menuNav = { "ctl00_TopMenuRepeater_ctl00_MenuLink","ctl00_TopMenuRepeater_ctl01_MenuLink", "ctl00_TopMenuRepeater_ctl02_MenuLink", "ctl00_LoginView_LoginLink", 
			"ctl00_LoginView_RegisterLink", "ctl00_BrowseAllLink"};
	
	
	public static boolean verifypresenceOfElementLocated(String id) {
		// Se crea un wait para darle como un tiempo para poder encontrar el elemento
		// con el id seleccionado, en el tiempo
		// se le asignan 3 segundos para encontrar el elemento si no existe muestra un
		// mensaje.
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		return element.isDisplayed();
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
	
	public static  boolean verifyLoadsMenu() {
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
}