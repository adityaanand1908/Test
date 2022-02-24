package com.hudl.application.test.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions 
				(
				features ={"classpath:features"},
				glue ={"com.hudl.application.test.automation.step.definition"},
				plugin = {"pretty", "html:target/cucumber/report.html"},
				
				tags = "@SendLatestHighlightsAT001",
				//tags = "@HudlValidLoginTestAT001",
				monochrome = true
				)


public class TestRunner {
}


