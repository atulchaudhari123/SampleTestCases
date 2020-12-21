package TestScenario;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tours {
	WebDriver driver = null;

	String browserName = "Chrome";

	@BeforeTest

	public void tourAplicationSetUp() {

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Atul\\Silenium\\Selenium Webdriver Download\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Atul\\Silenium\\Selenium Webdriver Download\\IEDriverServer_x64_2.40.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://selenium-examples.nichethyself.com/");
	}

	@Test
	public void Tour() throws InterruptedException {

		driver.findElement(By.linkText("Customized tours")).click();
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='days']")));
		sel.selectByVisibleText("Home Stay");
		driver.findElement(By.xpath("//*[@id=\"international\"]/form/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[9]/button")).click();
		Thread.sleep(5000);
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		System.out.println("a1");
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("London");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
