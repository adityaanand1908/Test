package com.hudl.application.test.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hudl.application.test.automation.beans.SendLatestHighlightsToCoachesConfigBeans;

public class SendHighlightsToCoachesPage extends HudlHomePage {
	
	public static String test_data = "src/main/resources/test.properties";
	public static SendLatestHighlightsToCoachesConfigBeans sendLatestHighlightsPageBean;	
	
	public static void getLatestHighlightsUrl() throws Exception {
		findElementByXpath(sendLatestHighlightsPageBean.getClickHighlightsTab()).click();
		Thread.sleep(2000);
		findElementByXpath(sendLatestHighlightsPageBean.getFilterByNewestOption()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getClickShareButton()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getClickCopyUrlLink()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getCloseShareHighlightDialogBox()).click();
	}
	
	public static void sendLatestHighlightsUrlToCoaches() throws Exception {
		FileInputStream file = new FileInputStream(new File(test_data));
		Properties prop = new Properties();
		prop.load(file);		
		findElementByXpath(sendLatestHighlightsPageBean.getClickSendMessageIcon()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getClickSendANewMessageButton()).click();
		Thread.sleep(2000);
		findElementByXpath(sendLatestHighlightsPageBean.getEnterMessage()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getEnterMessage()).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(3000);
		findElementByXpath(sendLatestHighlightsPageBean.getEnterToDetails()).sendKeys(prop.getProperty("messageToRecipients"));
		findElementByXpath(sendLatestHighlightsPageBean.getSelectRecipientsFromList()).click();
		findElementByXpath(sendLatestHighlightsPageBean.getClickSendButton()).click();		
		findElementByXpath(sendLatestHighlightsPageBean.getClickLastSentMessageButton()).click();
		Assert.assertEquals("Message from You", findElementByXpath(sendLatestHighlightsPageBean.getGetTextAfterMessageBeenSent()).getText());
		System.out.println(findElementByXpath(sendLatestHighlightsPageBean.getGetNotifiedUserCount()).getText());
		System.out.println(findElementByXpath(sendLatestHighlightsPageBean.getGetNotNotifiedUserCount()).getText());
	}
}
