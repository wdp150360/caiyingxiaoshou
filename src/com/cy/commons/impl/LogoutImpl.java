package com.cy.commons.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cy.commons.Logout;

public class LogoutImpl implements Logout{

	@Override
	public WebDriver logout(WebDriver dr) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//div[@class='dl-log']/a")).click();
		return dr;
	}
	
}
