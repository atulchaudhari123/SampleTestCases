package TestScenario;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankingApplication {
boolean flag=true;

@BeforeTest
public void beforeTest()
{
	System.out.println("---@Before Test annotation is kicked off---");
}

@AfterTest
public void afterTest()
{
	System.out.println("---@After Test annotation is kicked off---");
}

@BeforeMethod
public void beforeMethod()
{
	System.out.println("---@Before Method annotation is kicked off---");
}

@AfterMethod
public void afterMethod()
{
	System.out.println("---@After Meethod annotation is kicked off---");
}
	
	@Test (priority = 1)
	public void LoginBankApp(ITestContext context)
	{
		System.out.println("---Login to Banking Application---");
        context.setAttribute("CustomerName", "John Smith");
	}


	@Test (priority = 2, dependsOnMethods = {"LoginBankApp"})
	public void checkBalance(ITestContext context)
	{
		System.out.println("----Cheking the Account Balance----");
	    context.getAttribute("CustomerName");
	    String CustName = (String) context.getAttribute("CustomerName");
	    System.out.println("Customer Name is -- " +CustName);
	}

	@Test (priority = 3, dependsOnMethods = {"LoginBankApp","checkBalance"})
	public void BalanceTransfer(ITestContext context)
	{
//		if (flag)
//		{
//			throw new SkipException("Skipping this test case");
//		}
		System.out.println("----Transfer the fund to other Bank account---");
	}
	
	@Test (priority = 4, dependsOnMethods = {"LoginBankApp"})
	public void LogoutBankApp(ITestContext context)
	{
		System.out.println("------Logout from Banking Application-------");
	}
}


