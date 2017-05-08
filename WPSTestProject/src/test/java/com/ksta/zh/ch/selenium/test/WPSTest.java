package com.ksta.zh.ch.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ksta.zh.ch.selenium.DriverFactory;

@Test
public class WPSTest extends DriverFactory {

	private String appURL = System.getProperty("appURL");
	private String isiwebuserid = System.getProperty("isiwebuserid");
	private String isiwebpasswd = System.getProperty("isiwebpasswd");
	private String jpNumbers = System.getProperty("jpNumbers");
	private int timeout = Integer.parseInt(System.getProperty("timeout"));
	private WebDriver driver;

	@Test
	public void loopJPs(String data) throws Exception {
		System.out.println("nur ein Test");
	}


	@BeforeSuite
	private WebDriver login() throws Exception {
		this.driver = DriverFactory.getDriver();
		driver.get(appURL + "/c3-dialoge/?login");
		driver.findElement(By.name("isiwebuserid")).clear();
		driver.findElement(By.name("isiwebuserid")).sendKeys(isiwebuserid);
		driver.findElement(By.name("isiwebpasswd")).clear();
		driver.findElement(By.name("isiwebpasswd")).sendKeys(isiwebpasswd);
		driver.findElement(By.xpath("//div[@id='loginSubmitButton']/input")).click();
		clickWhenReady(By.xpath("//a[contains(text(),'Einfach JP')]"));
		return driver;
	}


	private WebElement getWhenVisible(By finder) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(finder));
		return element;
	}

	private void clickWhenReady(By finder) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(finder));
		element.click();
	}

}
