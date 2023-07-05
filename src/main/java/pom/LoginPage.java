package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {

	
		//variable
		@FindBy(xpath = "//a[text()='Sign in']")private WebElement signInButtonHomePage;
		@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberField;
		@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPassword;
		@FindBy(name="password")private WebElement passwordField;
		@FindBy(xpath = "//span[text()='Sign in']")private WebElement signInButton;
		@FindBy(xpath = "//div[text()='My Account']")private WebElement myAccountButton;
		@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myProfile;
		
		
		
		//constructor
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Methods
		public void clickOnHomePageButton()
		{
			Reporter.log("clicking on signIn button",true);
			signInButtonHomePage.click();
		}
		
		public void enterMobileNumber(String MobNo) throws EncryptedDocumentException, IOException
		{
			Reporter.log("entering MobileNo",true);
			mobileNumberField.sendKeys(MobNo);
		}
		public void clickOnSignInWithPassword() 
		{
			Reporter.log("clicking on signInWith password",true);
			signInWithPassword.click();
		}
		public void enterPassword(String Pwd) throws EncryptedDocumentException, IOException
		{
			Reporter.log("entered Password",true);
			passwordField.sendKeys(Pwd);
		}
		public void clickOnSighInButton() throws InterruptedException
		{
			Reporter.log("clicking on signIn button",true);
			signInButton.click();
			Thread.sleep(1000);
		}
		
		public void clickOnMyAccountButton() 
		{
			Reporter.log("clicking My account button",true);
			myAccountButton.click();
		}
		public void clickOnMyProfileButton()
		{
			Reporter.log("clicking on My Profile button",true);
			myProfile.click();
		}

	

}
