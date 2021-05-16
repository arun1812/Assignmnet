package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class LoginPage  extends Testbase{

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
// Page factory
	
	@FindBy(id="auth-local-btn")
	WebElement user_pass;
	
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="submit")
	WebElement login;

// Actions
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public HomePage Login(String un,String pwd) throws IOException, InterruptedException
	{
		user_pass.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\Arun\\JAVA\\Assignmnet\\login.exe");
		
		return new HomePage();
		
	}
}
