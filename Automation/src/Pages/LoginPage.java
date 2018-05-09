package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import Tests.LoginTest;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	@FindBy(id = "ctl00_LoginView_LoginLink")
	WebElement btnLoginMain;

	@FindBy(id = "ctl00_Main_LoginConrol_UserName")
	WebElement userName;

	@FindBy(id = "ctl00_Main_LoginConrol_Password")
	WebElement password;

	@FindBy(id = "ctl00_Main_LoginConrol_LoginButton")
	WebElement btnLogin;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void buttonLoginMain() {
		BasePage.clickOnElement(btnLoginMain);
	}

	private void username(String _userName) {
		BasePage.sendKeysToElement(userName, _userName);
	}

	private void password(String _password) {
		BasePage.sendKeysToElement(password, _password);
	}

	private void buttonLogin() {
		BasePage.clickOnElement(btnLogin);
	}

	public void logIn(String _userName, String _password) {
		buttonLoginMain();
		username(_userName);
		password(_password);
		buttonLogin();
	}

	public boolean verifyButtonLoginVisible(String id) {
		if (BasePage.verifyLoadsMenu()) {
			WebElement element = driver.findElement(By.id(id));
			return BasePage.waitForElementVisible(element);
		}
		return false;
	}

	public boolean verifyErrorMsg(String errorMsg) {
		return driver.getPageSource().contains(errorMsg);
	}

}
