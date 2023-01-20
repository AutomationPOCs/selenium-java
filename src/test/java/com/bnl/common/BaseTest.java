package com.bnl.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.google.common.collect.ImmutableMap;
import com.bnl.common.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static String BS_Username;
	public static String BS_AutomateKey;
	public static String URL;
	public static WebDriver driver;
	public static RemoteWebDriver rm_driver;
	public static AppiumDriver appium_driver;
	public static String applicationUrl;
	
	@BeforeMethod
	public void createDriver(String OS, String Browser, String env) throws MalformedURLException, IOException {
		applicationUrl = ConfigBase.initialiseProperty(ConfigBase.ConfigProperty,"Staging_URL");
		
		if (env.equalsIgnoreCase("local")) {
			if (OS.equalsIgnoreCase("windows") && Browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (OS.equalsIgnoreCase("windows") && Browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (OS.equalsIgnoreCase("windows") && Browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (OS.equalsIgnoreCase("mac") && Browser.equalsIgnoreCase("Safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();

			}
			driver.get(applicationUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}