package Page;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;
import TestCases.RegisterTest;

public class RegisterPage extends BasePage {

	WebDriver driver;
	static String[] registrationFields = {
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired",
			"ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired" };

	@FindBy(id = "ctl00_LoginView_RegisterLink")
	static WebElement btnRegisterMain;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
	static WebElement firstName;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
	static WebElement lastName;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
	static WebElement email;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
	static WebElement userName;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
	static WebElement password;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
	static WebElement confirmPassword;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
	static WebElement securityQuestion;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
	static WebElement securityAnswer;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
	static WebElement btnRegister;

	public RegisterPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	public void ButtonRegisterMain() {
		BasePage.clickOnElement(btnRegisterMain);
	}

	private void setFirstName(String _firstName) {
		BasePage.sendKeysToElement(firstName, _firstName);
	}

	private void setLastName(String _lasName) {
		BasePage.sendKeysToElement(lastName, _lasName);
	}

	private void setEmail(String _email) {
		BasePage.sendKeysToElement(email, _email);
	}

	private void setUsername(String _userName) {
		BasePage.sendKeysToElement(userName, _userName);
	}

	private void setPassword(String _password) {
		BasePage.sendKeysToElement(password, _password);
	}

	private void setConfirmpassword(String _confirmPassword) {
		BasePage.sendKeysToElement(confirmPassword, _confirmPassword);
	}

	private void setSecurityQuestion(String _securityQuestion) {
		BasePage.sendKeysToElement(securityQuestion, _securityQuestion);
	}

	private void setSecurityanswer(String _securityAnswer) {
		BasePage.sendKeysToElement(securityAnswer, _securityAnswer);
	}

	public void buttonRegister() {
		BasePage.clickOnElement(btnRegister);
	}

	public void getUserData(String _firsname, String _lastname, String _email, String _username, String _password,
			String _confirmpassword, String _securityQuestion, String _securityanswer) {
		ButtonRegisterMain();
		setFirstName(_firsname);
		setLastName(_lastname);
		setEmail(_email);
		setUsername(_username);
		setPassword(_password);
		setConfirmpassword(_confirmpassword);
		setSecurityQuestion(_securityQuestion);
		setSecurityanswer(_securityanswer);
		buttonRegister();
	}

	public boolean verifypresenceOfElement(String id) {
		if (BasePage.verifyLoadsMenu()) {
			WebElement element = driver.findElement(By.id(id));
			return BasePage.waitForElementVisible(element);
		}
		return false;
	}

	public boolean showMessagesEmptyFields() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element;
		boolean showMessages = true;
		boolean[] validateDisplaywMessages = new boolean[registrationFields.length];
		for (int i = 0; i < registrationFields.length; i++) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registrationFields[i])));
			validateDisplaywMessages[i] = element.isDisplayed();
		}
		if (Arrays.asList(false).contains(validateDisplaywMessages)) {
			showMessages = false;
		}
		return showMessages;
	}

}
