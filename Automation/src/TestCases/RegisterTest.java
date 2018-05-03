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
	
	@DataProvider(name = "parameterRegister")
	public Object[][] dataProvider() {
		return new Object[][] {
				{ "Clarisa", "Vela", "clarivela@gmail.com", "Clave", "clave123#", "clave123#", "hola", "hola" },
				{ "MariFlor", "Flori", "mariflor@gmail.com", "Florcita", "flori123", "flori123#", "hola", "hola" } };
	}

	@Test
	public static void DisplayPageRegister() {
		RegisterPage.ButtonRegisterMain();
		Assert.assertTrue(RegisterPage.verifypresenceOfElementLocated("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton"));
	}

	@Test
	public static void MandatoryMessageDisplayed() {
		// se le asigna al objeto el botón PageRegister que tiene ese id y se le dice que la
		// acción de ese botón va a ser clic
		RegisterPage.ButtonRegisterMain();
		RegisterPage.buttonRegister();
		Assert.assertTrue(RegisterPage.showMessagesEmptyFields());
	}

	@Test(dataProvider = "parameterRegister")
	public static void MessageWhenUserExist(String firsname, String lastname, String email, String username, String password, String confirmpassword, String securityQuestion, String securityanswer) {
		RegisterPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,securityanswer);
		Assert.assertTrue(RegisterPage.verifypresenceOfElementLocated("ctl00_Main_InfoLabel"));
	}

	@Test(dataProvider = "parameterRegister")
	public static void MessageDifferentPasswords(String firsname, String lastname, String email, String username, String password, String confirmpassword, String securityQuestion, String securityanswer) {
		RegisterPage.getUserData(firsname, lastname, email, username, password, confirmpassword, securityQuestion,securityanswer);
		Assert.assertTrue(RegisterPage.verifypresenceOfElementLocated("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare"));
	}
}
