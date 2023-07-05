package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;
import pom.MyAccountPage;
import utility.UtilityClass;
//@Listeners(test.Listener.class)
public class PB_TC_1090ValidatePolicyUserName extends Base {
	
	MyAccountPage myAc;
	LoginPage login;
	String TCID="PB_TC_1234";
	@BeforeClass
	public void launchPolicyBazar() throws InterruptedException
	{
		//UtilityClass utilityClass = new UtilityClass();
		UtilityClass.wait(1000);
		launchingBrowser();
		login =new LoginPage(driver);
		myAc =new MyAccountPage(driver);
		//String TCID="PB_TC_3456";
	}
	@BeforeMethod
	public void SignInToPolicyBazar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		UtilityClass.wait(200);
		login.clickOnHomePageButton();
		UtilityClass.wait(1000);
		login.enterMobileNumber(UtilityClass.readDataFromPropertyFile("MobNo"));
		UtilityClass.wait(200);
		login.clickOnSignInWithPassword();
		UtilityClass.wait(1000);
		login.enterPassword(UtilityClass.readDataFromPropertyFile("PWd"));
		UtilityClass.wait(200);
		login.clickOnSighInButton();
		UtilityClass.wait(1000);
		login.clickOnMyAccountButton();
		UtilityClass.wait(200);
		login.clickOnMyProfileButton();
		UtilityClass.wait(200);
		Set<String>s1=driver.getWindowHandles();
		ArrayList<String>l=new ArrayList<>(s1);
		String mainPageID=l.get(0);
		String childID=l.get(1);
		driver.switchTo().window(childID);
		Reporter.log("Switching to child page ",true);
		UtilityClass.wait(200);
		
	}
	
	
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException 
  {
	  String actualUN=myAc.getActualUserName();
	  
	String ExpUN=UtilityClass.readDataFromPropertyFile("UN");
	  Assert.assertEquals(actualUN,ExpUN,"TC is failed actual and exp UN is not match");
	 
	//UtilityClass.TakesScrrenShot(driver,actualUN+""+TCID);
  }
  @AfterMethod
  public void logOutFromPolicyBazar()
  {
	  myAc.clickOnLogOutButton();
  }
  @AfterClass
  public void closePolicyBazar()
  {
	  CloseBrowser();
  }
}
