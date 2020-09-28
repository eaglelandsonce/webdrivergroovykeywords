package com.webdriver

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.*
import org.openqa.selenium.support.events.AbstractWebDriverEventListener
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select


import internal.GlobalVariable

public class webdriver01 {

	private WebDriver webDriver


	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}


	@Keyword
	def setUp(){
		KeywordUtil.logInfo("Open Page - WebDriver Chapter 2")

		webDriver = DriverFactory.getWebDriver()

		/*  Don't need when when using Open Browser in test case
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe")
		 driver = new ChromeDriver();
		 */

		webDriver.get(GlobalVariable.TestSiteURL);
		webDriver.manage().window().maximize();

		// driver.manage().window().fullscreen();
		// driver.manage().window().setSize(new Dimension(375, 812));

		System.out.println(webDriver.getTitle());

		//webDriver.quit();
	}

	@Keyword
	def clickElement(){

		KeywordUtil.logInfo("Open Page - WebDriver Chapter 3 Find and Click")

		webDriver = DriverFactory.getWebDriver();
		//webDriver.get(GlobalVariable.TestSiteURL);
		//webDriver.manage().window().maximize();

		List<WebElement> links = webDriver.findElements(By.tagName("a"));
		System.out.println(links.size());

		WebElement inputsLink = webDriver.findElement((By.xpath("//a[contains(text(),'Inputs')]")));
		inputsLink.click();

		//webDriver.quit();

	}

	@Keyword
	def formFill(){

		KeywordUtil.logInfo("Open Page - WebDriver Chapter 4 Input and Click")

		def usernameField = By.id("username");
		def passwordField = By.id("password");
		def loginButton = By.cssSelector("#login button");

		webDriver = DriverFactory.getWebDriver();

		//Happy Path

		webDriver.findElement((By.xpath("//a[contains(text(),'Form Authentication')]"))).click();

		webDriver.findElement(usernameField).sendKeys(GlobalVariable.username);

		webDriver.findElement(passwordField).sendKeys(GlobalVariable.password);

		webDriver.findElement(loginButton).click();
	}

	@Keyword
	def useDropDown(){

		KeywordUtil.logInfo("Open Page - WebDriver Chapter 4 DropDown")

		def dropdown = By.id("dropdown");

		webDriver = DriverFactory.getWebDriver();
		webDriver.findElement((By.xpath("//a[contains(text(),'"+GlobalVariable.dropDownLoacator+"')]"))).click();
		Select dropDownElement = new Select(webDriver.findElement(dropdown));
		dropDownElement.selectByVisibleText("Option 1");

		def sizeSelected = dropDownElement.getAllSelectedOptions().size();
		def nameSelected = dropDownElement.getFirstSelectedOption().getText();


		println("&&&&&&& -> "+ nameSelected)

		WebUI.verifyEqual(sizeSelected, 1);
		WebUI.verifyEqual(nameSelected, "Option 1");
	}
}

