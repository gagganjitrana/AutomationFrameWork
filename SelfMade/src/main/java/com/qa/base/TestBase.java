package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	// Create static variables  - driver, properties   - Why these global variables are static

	public  static WebDriver driver;
	public  static Properties prop;
	
	// We need driver and prop variable as static as in the page classes we don't want to create separte instance of webdriver . so by making
	// this driver and prop as static here, we can use them in other static methods

	// create constructor of test base 

	public TestBase() {

		try {
			prop=new Properties();
			FileInputStream poprFile = new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
			prop.load(poprFile); // Need to load properties file to read it.
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Create an method for selecting browser

	public static void selectBrowser()
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Browser Selected : " + browserName);

		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else
			if(browserName.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
			else
			{
				System.out.println("Invalid Browser Selected");
			}


		String url = prop.getProperty("url");
		System.out.println("Launch URL : "+url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(url);

	}
	
	public static void closeBrowser()
	{
		driver.close();
		driver.quit();
	}




}
