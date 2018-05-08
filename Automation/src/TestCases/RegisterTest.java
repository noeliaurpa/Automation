/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.BaseTest;
import Page.RegisterPage;
import DataProviders.Users;

/**
 * @author nurpi-as
 *
 */
public class RegisterTest extends BaseTest {

	RegisterPage registerPage;

	@Test
	public void displayMenuRegisterPage() {
		BasePage basePage = new BasePage(super.getDriver());
		Assert.assertTrue(basePage.verifyLoadsMenu());
	}
	
	@Test
	public void DisplayPageRegister() {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.ButtonRegisterMain();
		Assert.assertTrue(registerPage.verifypresenceOfElement("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton"));
	}

	@Test
	public void MandatoryMessageDisplayed() {
		// se le asigna al objeto el botón PageRegister que tiene ese id y se le dice
		// que la
		// acción de ese botón va a ser clic
		registerPage = new RegisterPage(super.getDriver());
		registerPage.ButtonRegisterMain();
		registerPage.buttonRegister();
		Assert.assertTrue(registerPage.showMessagesEmptyFields());
	}

	@Test(dataProvider = "parameterRegister", dataProviderClass = Users.class)
	public void MessageWhenUserExist(String firsname, String lastname, String email, String username, String password,
			String confirmpassword, String securityQuestion, String securityanswer) {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,
				securityanswer);
		Assert.assertTrue(registerPage.verifypresenceOfElement("ctl00_Main_InfoLabel"));
	}

	@Test(dataProvider = "parameterRegister", dataProviderClass = Users.class)
	public void MessageDifferentPasswords(String firsname, String lastname, String email, String username,
			String password, String confirmpassword, String securityQuestion, String securityanswer) {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,
				securityanswer);
		Assert.assertTrue(registerPage.verifypresenceOfElement("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare"));
	}
}
