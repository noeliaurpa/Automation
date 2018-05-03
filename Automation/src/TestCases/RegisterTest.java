/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Page.RegisterPage;

/**
 * @author nurpi-as
 *
 */
public class RegisterTest extends BaseTest {
	
	RegisterPage registerPage;
	
	@DataProvider(name = "parameterRegister")
	public Object[][] dataProvider() {
		return new Object[][] {
				{ "Clarisa", "Vela", "clarivela@gmail.com", "Clave", "clave123#", "clave123#", "hola", "hola" },
				{ "MariFlor", "Flori", "mariflor@gmail.com", "Florcita", "flori123", "flori123#", "hola", "hola" } };
	}

	@Test
	public void DisplayPageRegister() {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.ButtonRegisterMain();
		Assert.assertTrue(registerPage.verifypresenceOfElementLocated("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton"));
	}

	@Test
	public void MandatoryMessageDisplayed() {
		// se le asigna al objeto el botón PageRegister que tiene ese id y se le dice que la
		// acción de ese botón va a ser clic
		registerPage = new RegisterPage(super.getDriver());
		registerPage.ButtonRegisterMain();
		registerPage.buttonRegister();
		Assert.assertTrue(registerPage.showMessagesEmptyFields());
	}

	@Test(dataProvider = "parameterRegister")
	public void MessageWhenUserExist(String firsname, String lastname, String email, String username, String password, String confirmpassword, String securityQuestion, String securityanswer) {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,securityanswer);
		Assert.assertTrue(registerPage.verifypresenceOfElementLocated("ctl00_Main_InfoLabel"));
	}

	@Test(dataProvider = "parameterRegister")
	public void MessageDifferentPasswords(String firsname, String lastname, String email, String username, String password, String confirmpassword, String securityQuestion, String securityanswer) {
		registerPage = new RegisterPage(super.getDriver());
		registerPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,securityanswer);
		Assert.assertTrue(registerPage.verifypresenceOfElementLocated("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare"));
	}
}
