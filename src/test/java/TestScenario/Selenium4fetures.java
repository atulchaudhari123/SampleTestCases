package TestScenario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4fetures {

	WebDriver driver = null;

	@BeforeClass
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

//	@Test
	public void screenshot() throws InterruptedException, IOException {

		driver.get("http://selenium-examples.nichethyself.com/");
		driver.findElement(By.linkText("Customized tours")).click();
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='days']")));
		sel.selectByVisibleText("Home Stay");
		driver.findElement(By.xpath("//*[@id=\"international\"]/form/div[2]/label/input")).click();

		WebElement label = driver.findElement(By.xpath("//*[@id=\"international\"]/form/div[2]/label"));

		File file = label.getScreenshotAs(OutputType.FILE);

		File dest = new File("label.png");
		FileUtils.copyFile(file, dest);

		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[9]/button")).click();
	}

//	@Test
	public void openNewBrowserWindow() {

		driver.get("http://selenium-examples.nichethyself.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void openNewBrowserTab() {

		driver.get("http://selenium-examples.nichethyself.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
