package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import DataProviders.Users;
import Pages.LoginPage;
import Pages.NavigationPage;

public class PostAnAdTest extends BaseTest{

	NavigationPage navigationPage;
	LoginPage loginPage;

	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class, priority=13)
	public void displayAllFiels(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonPostAnAd();
		Assert.assertTrue(navigationPage.verifyLoadsFielsPostAnAd());
		navigationPage.buttonLogout();
	}
	
	@Test(priority=12)
	public void verifyToDeployUserNotLogged() {
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonPostAnAd();
		loginPage = new LoginPage(super.getDriver());
		Assert.assertTrue(loginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}
	
}
