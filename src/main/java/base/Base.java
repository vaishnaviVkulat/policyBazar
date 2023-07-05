package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.UtilityClass;

public class Base 
{
     protected WebDriver driver;
	public void launchingBrowser() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		utility.UtilityClass.wait(1000);
		Reporter.log("launching Browser ",true);
	}
	public void CloseBrowser()
	{
		Reporter.log("closing Browser",true);
		driver.quit();
	}
	public void launchbrowserusingPropertyFile() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.readDataFromPropertyFile("url"));
		Reporter.log("launching browser..",true);
	}
}
