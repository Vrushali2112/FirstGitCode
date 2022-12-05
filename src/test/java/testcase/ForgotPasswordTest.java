package testcase;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;

public class ForgotPasswordTest extends BaseTest {
	public ForgotPasswordTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	public LoginPage lp;
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		driver=SetUpBrowser();
		lp=new LoginPage(driver);
		
	}
	@Test
	public void forgotPasswordText() throws InterruptedException
	{
		lp.textForgotPassword();
		
	}
	
	
	
}
	
	