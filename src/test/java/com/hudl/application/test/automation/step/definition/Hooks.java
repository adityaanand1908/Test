package com.hudl.application.test.automation.step.definition;

import com.hudl.application.test.automation.utils.TestUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public static void beforeScenario(Scenario scenario) {
		System.out.println("Executing Scenario" + " " + scenario.getName());
	}
	
	@After
	public static void afterScenario(Scenario scenario) {
		TestUtil.tearDown();
	}

}
