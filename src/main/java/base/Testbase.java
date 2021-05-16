package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver edriver;
	
	
	
	public Testbase()
	{
	 try{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Arun\\JAVA\\Assignmnet\\src\\main\\java\\confiig\\" + "config.properties");
		prop.load(ip);
	 	}	
	 		catch(FileNotFoundException e)
	 			{
	 				e.printStackTrace();
	 			}
	 		catch(IOException e)
	 			{
	 				e.printStackTrace();
	 			}
	}

	public static void Initialization() throws IOException
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Setup\\chrome90\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Selenium Setup\\Mozila\\geckodriver.exe" );
			  driver=new FirefoxDriver();
		}
		
		System.out.println("Driver "+ driver);
		
		System.out.println("Driver "+ driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
