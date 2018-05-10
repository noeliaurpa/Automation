package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import DataProviders.Users;
import Pages.LoginPage;
import Pages.NavigationPage;

public class MyAdsAndProfileTest extends BaseTest{

	NavigationPage navigationPage;
	LoginPage loginPage;

	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class, priority=11)
	public void verifyToDeployAllFielsUserLogged(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonMyAdsAndProfile();
		Assert.assertTrue(navigationPage.verifyLoadFielsMyAdsAndProfile());
		navigationPage.buttonLogout();
	}
	
	@Test(priority=10)
	public void verifyToDeployLoginUserNotLogged() {
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonMyAdsAndProfile();
		loginPage = new LoginPage(super.getDriver());
		Assert.assertTrue(loginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}

}
