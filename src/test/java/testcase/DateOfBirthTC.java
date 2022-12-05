package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.LoginPage;
import utility.CommonFunction;

public class DateOfBirthTC extends BaseTest  {
	public DateOfBirthTC() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	public LoginPage lp;
	public CommonFunction utobj;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver=SetUpBrowser();
    	lp=new LoginPage(driver);
    	utobj=new CommonFunction();
	}
	@Test
	public void selectDOBFacebook() throws InterruptedException
	{
		lp.ClickCreateNewAccount();
		Thread.sleep(3000);
		lp.selectDOB();
	}
	
	

	
}
