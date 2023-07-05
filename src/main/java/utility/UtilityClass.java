package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass 
{
    //CommonMethodUse
	//Screenshot
	//Scrolling
	//read Data from excel Sheet
	//Wait
	public static void TakesScrrenShot(WebDriver driver,String fileName ) throws IOException
	{
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File("C:\\Users\\vitth\\eclipse-workspace\\policyBazar\\Screenshots"+fileName+".png");
		 FileHandler.copy(src, dest);
		 Reporter.log("takesScreenshot",true);
		 Reporter.log("Screenshot location is.."+dest,true);
		 
	}
	//Scrolling
	public static void ScrollIntoView(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("aruguments[0].scrollIntoView(true)",element);
		Reporter.log("scrollinIntoView",true);
	}
	public static String readDataFromExcelSheet(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream("D:\\18th feb ExcelTest.xlsx");
        String value = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(rowNum).getCell(cellNum).getStringCellValue();
	    return value;
	}
	//wait
	public static void wait(int waitTime) throws InterruptedException
	{
		Thread.sleep(waitTime);
	}
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myFile = new FileInputStream("C:\\Users\\vitth\\eclipse-workspace\\selenium2\\myProperty.properities");
		prop.load(myFile);
		 String value = prop.getProperty(key);	
		 Reporter.log("read data"+key+"from property file",true);
		 return value;
		 
	}
	
}
