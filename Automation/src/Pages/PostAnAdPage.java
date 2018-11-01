package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class PostAnAdPage extends Base.BasePage {

	static String[] AllFielsFromPostAnAd = { "ctl00_Main_PostAdWizard_SubcategoriesList_ctl00_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl01_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl02_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl03_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl04_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl05_CategoryButton",
			"ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton",
			"ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton" };

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement postAnAd;

	public PostAnAdPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static boolean verifyLoadsFielsPostAnAd() {

		return BasePage.verifyLoadFiels(AllFielsFromPostAnAd);
	}

}
