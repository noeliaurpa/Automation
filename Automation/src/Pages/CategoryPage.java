package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Base.BaseTest;

public class CategoryPage extends BaseTest{

	WebDriver driver;
	String nameCategory;
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
	WebElement antiquesAndCollectibles;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
	WebElement artsAndCrafts;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
	WebElement auto;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")
	WebElement electronics;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")
	WebElement garden;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")
	WebElement homeCategory;
	
	@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")
	WebElement music;
	
	@FindBy(id = "ctl00_Main_SearchTermTextBox")
	WebElement data;
	
	@FindBy(id = "ctl00_Main_SearchButton")
	WebElement search;
	
	public CategoryPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public boolean buttonAntiquesAndCollectibles(String _data) {
		nameCategory = " Antiques & Collectibles";
		BasePage.clickOnElement(antiquesAndCollectibles);
		return search(_data, antiquesAndCollectibles, nameCategory);
	}
	
	public boolean buttonArtsAndCrafts(String _data) {
		nameCategory = " Arts & Crafts";
		BasePage.clickOnElement(artsAndCrafts);
		return search(_data, artsAndCrafts, nameCategory);
	}
	
	public boolean buttonAuto(String _data) {
		nameCategory = " Auto";
		BasePage.clickOnElement(auto);
		return search(_data, auto, nameCategory);
	}
	
	public boolean buttonElectronics(String _data) {
		nameCategory = " Electronics";
		BasePage.clickOnElement(electronics);
		return search(_data, electronics, nameCategory);
	}
	public boolean buttonGarden(String _data) {
		nameCategory = " Garden";
		BasePage.clickOnElement(garden);
		return search(_data, garden, nameCategory);
	}
	
	public boolean buttonHomeCategory(String _data) {
		nameCategory = " Home";
		BasePage.clickOnElement(homeCategory);
		return search(_data, homeCategory, nameCategory);
	}
	
	public boolean buttonMusic(String _data) {
		nameCategory = " Music";
		BasePage.clickOnElement(music);
		return search(_data, music, nameCategory);
	}
	
	public void buttonSearch() {
		BasePage.clickOnElement(search);
	}
	
	private void addDataToSearch(String _data) {
		BasePage.sendKeysToElement(data, _data);
	}
	
	public boolean search(String _data, WebElement _element, String _nameCategory) {
		addDataToSearch(_data);
		Select elementCombobox = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList")));
		String selectValue = elementCombobox.getFirstSelectedOption().getText();
		if(selectValue.trim().equals((_nameCategory).trim())) {
			buttonSearch();
			WebElement element = driver.findElement(By.id("ctl00_Main_NormalSearchCriteria"));
			BasePage basePage = new BasePage(super.getDriver());
			return BasePage.waitForElementVisible(element);
		}
		return false;
	}

}
