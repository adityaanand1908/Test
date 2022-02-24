package com.hudl.application.test.automation.utils;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;


/****
Developer : Aditya
Test Class Description : Contain test methods to login to Hudl homepage, verify the project name and log out the logged in user.  
*/

public class HudlHomePage extends TestUtil {	

	public static void launchAndLoginHudlApp() throws Exception {
		findElementByXpath(configBean.getHudlLoginUsernameField()).clear();
		findElementByXpath(configBean.getHudlLoginUsernameField()).sendKeys(configBean.getHudlUsername());
		findElementByXpath(configBean.getHudlLoginPasswordField()).sendKeys(configBean.getHudlPassword());
		findElementByXpath(configBean.getHudlLogInButton()).click();
		Thread.sleep(2000);
		String projectName = findElementByXpath(configBean.getHudlProjectName()).getText();
		System.out.println(projectName);
		Assert.assertEquals("MyProjectsample5", projectName);
		System.out.println("Welcome to Hudl Homepage");
	}
	
	public static void logOutHudlApp() throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(findElementByXpath(configBean.getHudlMouseHoverLoggedInUser())).build().perform();
		Thread.sleep(1000);
		act.moveToElement(findElementByXpath(configBean.getHudlLogOutButton())).click().build().perform();
		System.out.println("Current User is Successfully Logged Out!!");
	}
}
