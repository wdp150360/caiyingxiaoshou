package com.cy.commons;

import org.openqa.selenium.WebDriver;

public interface Drivers {
	
	public abstract WebDriver getIEDriver();
	public abstract WebDriver getFirefoxDriver();
	public abstract WebDriver getChromeDriver();
}
