package org.sample;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LaunchBrowser extends BaseClass {
	
	@Test
	public void tc1() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");
		
		WebElement emailTxt = driver.findElement(By.id("email"));
		emailTxt.sendKeys("Java");
		String att = emailTxt.getAttribute("value");
		
		
	}
	
	
	
}
