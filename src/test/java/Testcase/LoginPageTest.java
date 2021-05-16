package Testcase;

import java.io.IOException;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import base.Testbase;

public class LoginPageTest extends Testbase  {

	LoginPage loginpage;
	HomePage homepage;
	String username,password;
public LoginPageTest() throws IOException {
	super();
	// TODO Auto-generated constructor stub
}


	@BeforeMethod
	public void setup() throws IOException 
	{
		Initialization();
		loginpage= new LoginPage();
	}

	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Pritunl Zero1");
		System.out.println("Title is " +title );
	}

	@Test(priority=2)
	public void LoginTest() throws IOException, SQLException, InterruptedException 
	{
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Home page URL is " + driver.getCurrentUrl());
	}

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
