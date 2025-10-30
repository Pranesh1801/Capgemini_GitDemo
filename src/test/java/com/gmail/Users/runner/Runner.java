package com.gmail.Users.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features=".\\src\\test\\java\\com\\gmail\\Users\\features\\login.feature",
			glue="com.gmail.Users.StepDef",
			tags= "@TC4",
			plugin= {"pretty", "html:Reports/çucumber-reports.html"}
			)
	 
	public class Runner {
		
	}
	