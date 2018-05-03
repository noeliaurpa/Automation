package Page;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BaseTest;

public class HomePage extends BaseTest {

	String[] allCategories = { "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton","ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton", 
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton", "ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton", 
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton", "ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton",
			"ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton"};
	static String[] menuNav = { "ctl00_TopMenuRepeater_ctl00_MenuLink","ctl00_TopMenuRepeater_ctl01_MenuLink", "ctl00_TopMenuRepeater_ctl02_MenuLink", "ctl00_LoginView_LoginLink", 
			"ctl00_LoginView_RegisterLink", "ctl00_BrowseAllLink"};

	public HomePage(WebDriver _driver) {
		PageFactory.initElements(_driver, this);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean verifyLoads() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element;
		boolean ShowElements = true;
		boolean[] validateDisplayElementsC = new boolean[allCategories.length];
		boolean[] validateDisplayElementsM = new boolean[menuNav.length];
		for (int i = 0; i < allCategories.length; i++) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(allCategories[i])));
			validateDisplayElementsC[i] = element.isDisplayed();
		}
		
		for (int i = 0; i < menuNav.length; i++) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(menuNav[i])));
			validateDisplayElementsM[i] = element.isDisplayed();
		}
		
		if (Arrays.asList(false).contains(validateDisplayElementsC) && Arrays.asList(false).contains(validateDisplayElementsM)) {
			ShowElements = false;
		}
		return ShowElements;
	}	
	
}
