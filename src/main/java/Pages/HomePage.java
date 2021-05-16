package Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Testbase;

public class HomePage extends Testbase{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
// Page factory
	
	@FindBy(id="cmp-nfr-top-side-donate")
	WebElement donatenow;
	@FindBy(xpath="//button[@id='story-popup-donate-amt-option3']")
	WebElement amtselection;
	@FindBy(id="ig_tips_dropdown")
	WebElement selectROI;
	
	@FindBy(id="story-popup-donate-button")
	WebElement donate;
	
	@FindBy(name="full_name")
	WebElement name;
	@FindBy(name="email_receipt")
	WebElement email;
	@FindBy(id="mobile")
	WebElement mobile;
	@FindBy(name="city_text")
	WebElement city;
	@FindBy(id="story-popup-donate-button")
	WebElement donatefinal;
	
// Actions
	
	public void DonateNow()
	{
		
		donatenow.click();
	}
	
	public void AmountDonate()
	{
		amtselection.click();
		Select ROI=new Select(selectROI);
		ROI.selectByIndex(2);
		name.sendKeys(prop.getProperty("Name"));
		email.sendKeys(prop.getProperty("Email"));
		mobile.sendKeys(prop.getProperty("Mobile"));
		city.sendKeys(prop.getProperty("City"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('#fsModal').scrollBy(0,500)");
		donatefinal.click();
	}
	
}
