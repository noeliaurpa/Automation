package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class NavigationPage extends Base.BasePage{

	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement home;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement postAnAd;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement myAdsAndProfile;
	
	@FindBy(id = "ctl00_LoginView_MemberLoginStatus")
	WebElement logoutUser;
	
	@FindBy(id = "ctl00_LoginView_RegisterLink")
	WebElement register;
	
	@FindBy(id = "ctl00_LoginView_LoginLink")
	WebElement login;

	public NavigationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void buttonLogout() {
		BasePage.clickOnElement(logoutUser);
	}

	public CategoryPage goToCategory() {
		BasePage.clickOnElement(home);
		return new CategoryPage(driver);
	}
	
	public HomePage goToHome() {
		BasePage.clickOnElement(home);
		return new HomePage(driver);
	}
	
	public LoginPage goToLogin() {
		BasePage.clickOnElement(login);
		return new LoginPage(driver);
	}

	public RegisterPage goToRegister() {
		return new RegisterPage(driver);
	}
	
	public PostAnAdPage goToPostAnAd() {
		BasePage.clickOnElement(postAnAd);
		return new PostAnAdPage(driver);
	}

	public MyAdsAndProfilePage goToMyAdsAndProfile() {
		BasePage.clickOnElement(myAdsAndProfile);
		return new MyAdsAndProfilePage(driver);
	}

}
