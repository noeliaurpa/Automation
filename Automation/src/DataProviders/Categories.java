package DataProviders;

import org.testng.annotations.DataProvider;

public class Categories {

	@DataProvider(name = "parameterCategory")
	public Object[][] dataProviderOfCategories() {
		return new Object[][] { { "a" }, { "$" }, { "8" } };
	}

}
