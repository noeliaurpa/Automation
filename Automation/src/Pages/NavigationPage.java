package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Base.BaseTest;

public class NavigationPage extends BaseTest {

	WebDriver driver;
	static String[] allFielsFromCategories = { "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton" };

	static String[] AllFielsFromMyAdsAnsProfile = { "ctl00_Main_CurrentAdsButton", "ctl00_Main_InactiveAdsButton",
			"ctl00_Main_SavedAdsButton", "ctl00_Main_ActivationAdsButton", "ctl00_Main_ProfileLink",
			"ctl00_Main_CommonSearchTextBox", "ctl00_Main_CommonCategoryDropDown_CategoryList",
			"ctl00_Main_SearchButton" };
	static String[] AllFielsFromPostAnAd = { "ctl00_Main_PostAdWizard_SubcategoriesList_ctl00_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl01_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl02_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl03_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl04_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl05_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton",
			"ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton" };

	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement home;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement postAnAd;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement myAdsAndProfile;
	
	@FindBy(id = "ctl00_LoginView_MemberLoginStatus")
	WebElement logoutUser;

	public NavigationPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void buttonLogout() {
		BasePage.clickOnElement(logoutUser);
	}
	public void buttonHome() {
		BasePage.clickOnElement(home);
	}

	public void buttonPostAnAd() {
		BasePage.clickOnElement(postAnAd);
	}

	public void buttonMyAdsAndProfile() {
		BasePage.clickOnElement(myAdsAndProfile);
	}

	public void goToHome() {
		buttonHome();
	}

	public void goToPotAnAd() {
		buttonPostAnAd();
	}

	public void goToMyAdsAndProfile() {
		buttonMyAdsAndProfile();
	}

	public boolean verifyLoads(String id) {
		WebElement element = driver.findElement(By.id(id));
		return BasePage.waitForElementVisible(element);
	}

	public static boolean verifyLoadFielsMyAdsAndProfile() {
		
		return BasePage.verifyLoadFiels(AllFielsFromMyAdsAnsProfile);
	}

	public boolean verifyLoadsCategories() {
	
		return BasePage.verifyLoadFiels(allFielsFromCategories);
	}

	public boolean verifyLoadsFielsPostAnAd() {
		
		return BasePage.verifyLoadFiels(AllFielsFromPostAnAd);
	}
}
