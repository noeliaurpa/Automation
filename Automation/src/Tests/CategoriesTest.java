package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.BaseTest;
import DataProviders.Categories;
import Pages.CategoryPage;
import Pages.NavigationPage;

public class CategoriesTest extends BaseTest{

	CategoryPage categoryPage;
	NavigationPage navigationPage;
	BasePage basePage;
	@Test(priority=14)
	public void goToCategories() {
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
		Assert.assertTrue(basePage.verifypresenceOfElementLocated("ctl00_Main_CategoryBrowser_TopCategoryList"));
	}
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=15)
	public void searchAntiquesAndCollectibles(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonAntiquesAndCollectibles(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=16)
	public void searchArtsAndCrafts(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonArtsAndCrafts(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=17)
	public void searchAuto(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonAuto(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=18)
	public void searchElectronics(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonElectronics(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=19)
	public void searchGarden(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonGarden(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=20)
	public void searchHome(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonHomeCategory(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}
	
	@Test(dataProvider = "parameterCategory", dataProviderClass = Categories.class, priority=21)
	public void searchMusic(String _dataSearch) {
		categoryPage = new CategoryPage(super.getDriver());
		Assert.assertTrue(categoryPage.buttonMusic(_dataSearch));
		navigationPage = new NavigationPage(super.getDriver());
		navigationPage.goToCategory();
	}

}
