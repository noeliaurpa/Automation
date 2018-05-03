package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import Base.BaseTest;

public class LoginPage extends BaseTest{

	@FindBy(id="ctl00_LoginView_LoginLink")
	static WebElement btnLoginMain;
	
	@FindBy(id="ctl00_Main_LoginConrol_UserName")
	static WebElement userName;
	
	@FindBy(id="ctl00_Main_LoginConrol_Password")
	static WebElement password;
	
	@FindBy(id="ctl00_Main_LoginConrol_LoginButton")
	static WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	public static void buttonLoginMain() {
		BasePage.clickOnElement(btnLoginMain);
	}
	
	private static void username(String _userName) {
		BasePage.sendKeysToElement(userName, _userName);
	}
	
	private static void password(String _password) {
		BasePage.sendKeysToElement(password, _password);
	}
	
	private static void buttonLogin() {
		BasePage.clickOnElement(btnLogin);
	}

	public static void logIn(String _userName, String _password) {
		buttonLoginMain();
		username(_userName);
		password(_password);
		buttonLogin();
	}
	
	public static boolean verifyButtonLoginVisible(String id) {
		if(BasePage.verifyLoadsMenu()) {
			WebElement element = driver.findElement(By.id(id));
			return BasePage.waitForElementVisible(element);
		}
		return false;
	}
	
	public boolean verifyErrorMsg(String errorMsg) {
		return driver.getPageSource().contains(errorMsg);
	}
	
	public static boolean verifyUsr(String usr) {
		WebElement element = driver.findElement(By.id("ctl00_LoginView_MemberName"));
		return element.isDisplayed() && element.getText().equals(usr);
	}

}
