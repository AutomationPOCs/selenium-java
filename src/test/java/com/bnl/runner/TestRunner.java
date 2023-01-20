package com.bnl.runner;

import java.io.IOException;
import java.net.URISyntaxException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.bnl.common.BaseTest;
import com.bnl.common.ConfigBase;
import com.bnl.common.EmailConfig;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/com/bnl/features/Login.feature" }, 
glue = {"com.bnl.steps" },
plugin = {"pretty", "json:target/cucumber-reports/report2.json",
		"junit:target/cucumber-reports/cucumber.xml",
		"html:target/cucumber-reports/report.html"},
tags = "@web",
monochrome = true, publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	BaseTest baseTest = new BaseTest();
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException, ParseException, URISyntaxException, InterruptedException {	
		
		//local environment set 
		String osName = ConfigBase.initialiseProperty(ConfigBase.BrowserProperty,"OSName");
		String browserName = ConfigBase.initialiseProperty(ConfigBase.BrowserProperty,"BrowserName");
		String platformName = ConfigBase.initialiseProperty(ConfigBase.BrowserProperty,"PlatformName");
		baseTest.createDriver(osName, browserName, platformName);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		baseTest.teardown();
	}
	
}