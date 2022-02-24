package com.hudl.application.test.automation.step.definition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hudl.application.test.automation.beans.SendLatestHighlightsToCoachesConfigBeans;
import com.hudl.application.test.automation.utils.HudlHomePage;
import com.hudl.application.test.automation.utils.SendHighlightsToCoachesPage;
import com.hudl.application.test.automation.utils.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HudlShareHighlightsTestPage extends SendHighlightsToCoachesPage {
	
	public static void setup() throws Exception {
		getInitialContext();
		ApplicationContext context = new ClassPathXmlApplicationContext(configpagebeans);
		sendLatestHighlightsPageBean = context.getBean("sndHghlgts", SendLatestHighlightsToCoachesConfigBeans.class);
		System.out.println("Beans Initialized successfully");
		webDriverInitialization();
	}

	@Given("User Navigates to Highlights tab and selects the latest sport highlights to share")
	public void user_navigates_to_highlights_tab_and_selects_the_latest_sport_highlights_to_share() throws Exception {
	    setup();
	    launchAndLoginHudlApp();
	    getLatestHighlightsUrl();
	}

	@Then("User send the new message to the list of recipients to validate that message is been sent successfully to listed recipients and get the count of recipients viewed and not viewed the sent message")
	public void user_send_the_new_message_to_the_list_of_recipients_to_validate_that_message_is_been_sent_successfully_to_listed_recipients_and_get_the_count_of_recipients_viewed_and_not_viewed_the_sent_message() throws Exception{
		sendLatestHighlightsUrlToCoaches();
	}
}
