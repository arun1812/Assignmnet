package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Payment extends Testbase{

	public Payment() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
// Page factory
	
	@FindBy(id="donate-card-contribute")
	WebElement payment;
	
	public void PaymentDebitCard() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\Arun\\JAVA\\Assignmnet\\payment1.exe");
		Thread.sleep(10000);
		payment.click();
	}

}
