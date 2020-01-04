package com.closure;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AmazonTesting {

	

	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Oneplus");
		capabilities.setCapability("udid","b83e712b");  //simar
		//capabilities.setCapability("udid","02157df2b89c551d"); //garima
		//capabilities.setCapability("udid","bdc9cd63");  //aanchal
		//capabilities.setCapability("udid","ZY32294NW7");  //mom
		capabilities.setCapability("platformName","Android");
		 capabilities.setCapability("app", "C:\\Users\\Simarjeet Singh\\Downloads\\Amazon Shopping Search Fast Browse Deals Easy_v18.21.2.100_apkpure.com.apk");
		capabilities.setCapability("platformVersion","9.0");

		capabilities.setCapability("noReset","true");
	  capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity"); // This is Launcher activity of your app (you can get it from apk info app)
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		System.out.println("Application Started.....");
	}

	@Test
	public void testCal() throws Exception {

		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")).click(); //click the 3 lines 
	    
		//driver.findElement(By.xpath("//android.widget.LinearLayout[@index = '0']")).click(); //shop by category
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Shop by Category']")).click();
		driver.findElement(By.xpath("//android.view.View[@text = 'TV, Appliances, Electronics']")).click();  //category select
		//driver.findElement(By.xpath("//android.view.View[@index = '3']")).click(); //select televisoons
		driver.findElement(By.xpath("//android.view.View[@text = 'Televisions']")).click();
		//driver.findElement(By.id("in.amazon.mShop.android.shopping:id/2a491134-9a94-4592-9d7f-b52fb483a809")).click();
		       
		driver.findElement(By.xpath("//android.view.View[@text = 'Samsung TVs']")).click();
		driver.findElement(By.xpath("//android.view.View[@index = '11']")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Add to Cart']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Cart']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Delete']")).click();



	}
	
	

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}


