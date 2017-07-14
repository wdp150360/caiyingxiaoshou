package com.cy.commons.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cy.commons.Drivers;

public class DriversImpl implements Drivers {

	@Override
	public WebDriver getIEDriver() {
		// TODO Auto-generated method stub
		String IEWebDriver = "D:\\软件\\selenium\\IEDriverServer32\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", IEWebDriver);
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}

	@Override
	public WebDriver getFirefoxDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebDriver getChromeDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
