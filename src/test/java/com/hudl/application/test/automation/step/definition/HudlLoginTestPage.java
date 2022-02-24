package com.hudl.application.test.automation.step.definition;

import com.hudl.application.test.automation.utils.HudlHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HudlLoginTestPage extends HudlHomePage{
	
	public static void setup() throws Exception {
		getInitialContext();
		webDriverInitialization();
	}
	
	@Given("^Start chrome browser and launch hudl web application$")
	public void start_chrome_browser_and_launch_hudl_web_application() throws Exception {
		setup();
	}

	@Given("^Click on Login button after entering valid username and password to validate the displayed project name on the hudl homepage$")
	public void click_on_Login_button_after_entering_valid_username_and_password_to_validate_the_displayed_project_name_on_the_hudl_homepage() throws Exception {
		launchAndLoginHudlApp();
	}

	@Then("^Logout the loggedin user$")
	public void logout_the_loggedin_user() throws Exception {
		logOutHudlApp();
	}
}
