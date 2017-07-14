package com.cy.service;

import org.openqa.selenium.WebDriver;

public interface DataReport {
	public abstract WebDriver performanceStatistics(WebDriver dr);
	public abstract WebDriver billDetails(WebDriver dr);
}
