package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import DataProviders.Users;
import Page.LoginPage;
import Page.NavigationPage;

public class HomePageTest extends BaseTest {

	NavigationPage navigationPage;
	LoginPage loginPage;
	
	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class)
	public void clickButtonHomeMenu(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonHome();
		Assert.assertTrue(navigationPage.verifyLoadsCategories());
	}
	
	@Test()
	public void displayAllFiels() {
		navigationPage = new NavigationPage(super.getDriver());
		Assert.assertTrue(navigationPage.verifyLoadsCategories());
	}
}
