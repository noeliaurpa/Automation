package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import DataProviders.Users;
import Page.LoginPage;
import Page.NavigationPage;

public class MyAdsAndProfileTest extends BaseTest{

	NavigationPage navigationPage;
	LoginPage loginPage;

	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class, priority=1)
	public void verifyToDeployAllFielsUserLogged(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonMyAdsAndProfile();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(navigationPage.verifyLoadFielsMyAdsAndProfile());
	}
	
	@Test(priority=0)
	public void verifyToDeployLoginUserNotLogged() {
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonMyAdsAndProfile();
		loginPage = new LoginPage(super.getDriver());
		Assert.assertTrue(loginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}

}
