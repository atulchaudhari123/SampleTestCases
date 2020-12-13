package TestScenario;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTestNGTestase {
	
	@Test (priority = 1)
	public void search()
	{
		System.out.println("-------Search Phone------");
//		String expectedValue = "ABC"; //can be read from xls, json or properties.
//		String actualValue = "ABCD";
//		System.out.println("Before Assertion");
//		Assert.assertEquals(actualValue, expectedValue);
//		System.out.println("Assertion got pass");
//		Assert.assertTrue(5>1, "Error Message");
//		Assert.assertFalse(5<1, "---No Error---");
//		if(expectedValue!=actualValue)
//		{
//		Assert.fail("Failed due to invalid data");
//		}
	}


	@Test (priority = 0)
	public void selectPhone()
	{
		System.out.println("-------Select the Phone--------");
		
		SoftAssert softAssert = new SoftAssert();
		
		String expectedValue = "ABC"; //can be read from xls, json or properties.
		String actualValue = "ABC";
		System.out.println("Before Soft Assertion");
		softAssert.assertEquals(actualValue, expectedValue);
		System.out.println("Soft Assertion got pass");
		softAssert.assertTrue(5>1, "----Error Message----");
		softAssert.assertFalse(5<1, "---No Error---");
		if(expectedValue!=actualValue)
		{
			softAssert.fail("Failed due to invalid data");
		}
	    softAssert.assertAll();
	   
	}

	@Test (priority = -1)
	public void checkout()
	{
		System.out.println("------Checkout the Phone-------");
	
	}
}
