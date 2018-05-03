/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.BaseTest;
import DataProviders.Users;
import Page.LoginPage;

/**
 * @author nurpi-as
 *
 */
public class LoginTest extends BaseTest {

	LoginPage loginPage;

	@Test
	public void displayMenuLoginPage() {
		Assert.assertTrue(BasePage.verifyLoadsMenu());
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
		Assert.assertTrue(loginPage.verifyUsr(username));
	}
}
