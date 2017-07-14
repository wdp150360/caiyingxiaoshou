package com.cy.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriversTest {
	static String url = "http://ssp-test.zbjf.com/ssp/logout";

	public static void main(String[] args){
		String IEWebDriver = "D:\\软件\\selenium\\IEDriverServer32\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", IEWebDriver);
		WebDriver driver = new InternetExplorerDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("loginName")).sendKeys("001");
		driver.findElement(By.id("loginPwd")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@class='button_blue' and @type='submit'and @value='登 录']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
	}
}
