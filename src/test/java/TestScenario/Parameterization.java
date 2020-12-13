package TestScenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.TestDataProvider;

public class Parameterization {
	//Step 2 - Linking test with test data provider
//	@Test (dataProvider = "getData")
	@Test (dataProviderClass = TestDataProvider.class, dataProvider = "getData")
	public void createNewUser(String FirstName, String LastName, int MobileNumber)
	
	{
		System.out.println("Create User = "+FirstName+ "----"+LastName+"----"+MobileNumber);
	}
	
//	@Test (dataProvider = "getData")
	@Test (dataProviderClass = TestDataProvider.class, dataProvider = "getData")
	public void deleteNewUser(String FirstName, String LastName, int MobileNumber)
	
	{
		System.out.println("Delete User = " +FirstName+ "----"+LastName+"----"+MobileNumber);
	}

	//Step 1
	
}
