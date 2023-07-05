package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	
		//Variable
		@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement userName;
		//constructor
		@FindBy(className = "h_l")private WebElement logOutButton;
		//constructor
		public MyAccountPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//methods
		public String  getActualUserName()
		{
			String ActualUN=userName.getText();
			return ActualUN;
	
		}
		public void clickOnLogOutButton()
		{
			logOutButton.click();
		}



}
