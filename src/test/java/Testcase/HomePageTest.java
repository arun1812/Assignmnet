package Testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import base.Testbase;

public class HomePageTest extends Testbase{

	HomePage homepage;
	LoginPage loginpage;
public HomePageTest() throws IOException {
	super();
	// TODO Auto-generated constructor stub
}


	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		Initialization();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void DonateNowTest()
		{
			homepage.DonateNow();
		}

	@Test(priority=2)
	public void AmountDonateTest()
	{
		homepage.AmountDonate();
	}

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
