package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import DataProviders.Users;
import Page.LoginPage;
import Page.NavigationPage;

public class PostAnAdTest extends BaseTest{

	NavigationPage navigationPage;
	LoginPage loginPage;

	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class, priority=1)
	public void displayAllFiels(String username, String password) { 
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonPostAnAd();
		Assert.assertTrue(navigationPage.verifyLoadsFielsPostAnAd());
	}
	
	@Test(priority=0)
	public void verifyTodeployLoginUserNotLogged() {
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonPostAnAd();
		loginPage = new LoginPage(super.getDriver());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}
	
}
