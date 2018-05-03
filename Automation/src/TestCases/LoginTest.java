/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Page.LoginPage;
/**
 * @author nurpi-as
 *
 */
public class LoginTest extends BaseTest {

	@DataProvider(name = "parameterLogin")
	public Object[][] dataProvider() {
		return new Object[][] { { "noeliaurpi", "Nurpi1495$" }, { "noeliaurp", "Nurpi1495$" } };
	}
	
	@Test
	public void displayPageLogin() {
		LoginPage.buttonLoginMain();
		Assert.assertTrue(LoginPage.verifyButtonLoginVisible("ctl00_Main_LoginConrol_LoginButton"));
	}
	
	@Test(dataProvider = "parameterLogin")
	public void verifyCredentialsLogin(String username, String password) {
		LoginPage.logIn(username, password);
		Assert.assertTrue(LoginPage.verifyUsr(username));
	}
}
