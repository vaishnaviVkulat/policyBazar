package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.UtilityClass;

public class Listener extends Base implements ITestListener
{
	
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			UtilityClass.TakesScrrenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    @Override
    
    public void onTestSuccess(ITestResult result) 
    {
    	Reporter.log("TC"+result.getName()+"passed sucessfully",true);
    }
    @Override
    public void onTestStart(ITestResult result) 
    {
    	Reporter.log("TC execution started for the TC "+result.getName(),true);
    }
}
