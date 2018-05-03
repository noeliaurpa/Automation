package DataProviders;

import org.testng.annotations.DataProvider;

public class Users {

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	@DataProvider(name = "parameterRegister")
	public Object[][] dataProviderOfRegister() {
		return new Object[][] {
				{ "Clarisa", "Vela", "clarivela@gmail.com", "Clave", "clave123#", "clave123#", "hola", "hola" },
				{ "MariFlor", "Flori", "mariflor@gmail.com", "Florcita", "flori123", "flori123#", "hola", "hola" } };
	}
	
	@DataProvider(name = "parameterLogin")
	public Object[][] dataProviderOfLogin() {
		return new Object[][] { { "noeliaurpi", "Nurpi1495$" }, { "noeliaurp", "Nurpi1495$" } };
	}

}
