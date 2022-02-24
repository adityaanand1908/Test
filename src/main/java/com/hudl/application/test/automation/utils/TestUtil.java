package com.hudl.application.test.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestPropertySource;

import com.hudl.application.test.automation.beans.ConfigBeans;

/****
 Developer : Aditya
 Test Class Description : Contain common Java methods used across this Test Harness
*/ 


@TestPropertySource({"classpath:http.test.properties"})
public class TestUtil {
	
	public static WebDriver driver = null;
	public static String test_prop = "src/main/resources/test.properties";
	public static ConfigBeans configBean = null;
	public static String configpagebeans = "config-beans.xml";
	
	/*This method is created to load the common properties*/
	public static void getInitialContext() throws Exception{
		if (null == configBean) {
			ApplicationContext context = new ClassPathXmlApplicationContext(configpagebeans);
			configBean = context.getBean("conn", ConfigBeans.class);
			System.out.println("Successfully created objects to load common properties");
		}
	}
	
	public static void webDriverInitialization() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(configBean.getHudlLoginUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static WebElement findElementByXpath(final String elementXpath) {
		WebElement elementFetched = null;
		try {
			elementFetched = driver.findElement(By.xpath(elementXpath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementFetched;		
	}
	
	public static WebElement findElementById(final String elementId) {
		WebElement elementFetched = null;
		try {			
			elementFetched = driver.findElement(By.id(elementId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementFetched;
	}
	
	  public static void tearDown() {
		driver.close();
		driver.quit();
		driver = null;
	}
}
