package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Page.HomePage;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	@Test
	public void displayAllFiels() {
		homePage = new HomePage(super.getDriver());
		Assert.assertTrue(homePage.verifyLoads());
	}

}
