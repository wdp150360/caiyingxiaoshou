package com.cy.commons;

import org.openqa.selenium.WebDriver;

public interface Login {
	
	public abstract WebDriver uiWebLogin(WebDriver dr,String username,String password);
}
