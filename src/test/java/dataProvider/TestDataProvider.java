package dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

@DataProvider
	
	public Object [][] getData(Method m)
	
	{
	System.out.println("Method which are invoking data provider is = " +m.getName());
		Object [][] data = new Object[2][3];
		
		data [0][0] = "John";
		data [0][1] = "Smith";
		data [0][2] = 1234567890;
		
		data [1][0] = "Mark";
		data [1][1] = "Carlo";
		data [1][2] = 1144668800;
		
		return data;
	}
}
