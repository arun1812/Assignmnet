package Testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Payment;
import base.Testbase;

public class PaymentTest extends Testbase {

	LoginPage loginpage;
	HomePage homepage;
	Payment payment;
	public PaymentTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setpage() throws IOException, InterruptedException 
	{
		Initialization();
		loginpage=new LoginPage();
		payment=new Payment();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.DonateNow();
		homepage.AmountDonate();
	}
	
	@Test(priority=1)
	public void PaymentDebitCardTest() throws InterruptedException, IOException
	{
		payment.PaymentDebitCard();
	}
	
	@AfterMethod
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}