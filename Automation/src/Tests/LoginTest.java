/**
 * 
 */
package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.BaseTest;
import DataProviders.Users;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NavigationPage;

/**
 * @author nurpi-as
 *
 */
public class LoginTest extends BaseTest {

	LoginPage loginPage;

	@Test
	public void displayMenuLoginPage() {
		BasePage basePage = new BasePage(super.getDriver());
		Assert.assertTrue(basePage.verifyLoadsMenu());
	}
	
	@Test
	public void displayPageLogin() {
		loginPage = new LoginPage(super.getDriver());
		loginPage.buttonLoginMain();
		Assert.assertTrue(loginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}

	@Test(dataProvider = "parameterLogin", dataProviderClass = Users.class)
	public void verifyCredentialsLogin(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.logIn(username, password);
		HomePage homePage = new HomePage(super.getDriver());
		Assert.assertTrue(homePage.verifyUsr(username));
		NavigationPage navigationPage = new NavigationPage(super.getDriver());
		navigationPage.buttonLogout();
	}
}
