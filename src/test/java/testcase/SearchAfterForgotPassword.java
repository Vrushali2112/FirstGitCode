package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;

public class SearchAfterForgotPassword extends BaseTest {
	
	public SearchAfterForgotPassword() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	public LoginPage lp;
	public ForgotPasswordPage fp;

	@BeforeMethod
	public void setup() throws InterruptedException
	{
		driver=SetUpBrowser();
    	lp=new LoginPage(driver);
    	fp=new ForgotPasswordPage(driver);
	}
	@Test
	public void checkForgotPasswordPage() throws InterruptedException
	{
		String expectedError="No Search Results";
		lp.ClickForgotPassword();
		String ActualError=fp.ForgotPasswordPageCheck();
		Assert.assertEquals(ActualError, expectedError);
	}

}
