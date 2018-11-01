package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class MyAdsAndProfilePage extends Base.BasePage {

	static String[] AllFielsFromMyAdsAnsProfile = { "ctl00_Main_CurrentAdsButton", "ctl00_Main_InactiveAdsButton",
			"ctl00_Main_SavedAdsButton", "ctl00_Main_ActivationAdsButton", "ctl00_Main_ProfileLink",
			"ctl00_Main_CommonSearchTextBox", "ctl00_Main_CommonCategoryDropDown_CategoryList",
			"ctl00_Main_SearchButton" };

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	private WebElement myAdsProfile;

	public MyAdsAndProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static boolean verifyLoadFielsMyAdsAndProfile() {

		return BasePage.verifyLoadFiels(AllFielsFromMyAdsAnsProfile);
	}

}
