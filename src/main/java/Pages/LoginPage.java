package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonFunction;

public class LoginPage {

@FindBy(xpath="//input[@id='email']")
WebElement email;
@FindBy(xpath="//input[@id='pass']")
WebElement password;
@FindBy(xpath="//button[@name='login']")
WebElement LogIn;
@FindBy(xpath="//a[normalize-space()='Forgot password?']")
WebElement ForgotPassword;
@FindBy(xpath="//a[text()='Create new account']")
WebElement CreateNewAccount;
@FindBy(xpath="//select[@id='month']")
WebElement month;
@FindBy(xpath="//select[@id='day']")
WebElement day;
@FindBy(xpath="//select[@id='year']")
WebElement year;

WebDriver driver;
CommonFunction utobj;
public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	utobj=new CommonFunction();
}
public void setUserName(String UserName)
{
	email.clear();
	email.sendKeys(UserName);
}
public void setPassword(String pass)
{
	password.clear();
	password.sendKeys(pass);
}
public void ClickLogin()
{
	LogIn.click();
}
public void textForgotPassword()
{
	String forgot=ForgotPassword.getText();
	System.out.println(forgot);
}
public void ClickForgotPassword()
{
	ForgotPassword.click();
}
public void ClickCreateNewAccount()
{
	CreateNewAccount.click();
}
public void selectDOB()
{
	utobj.drpdown(month,"Dec");
	utobj.drpdown(day,"21");
	utobj.drpdown(year,"1994");
	
}




}
