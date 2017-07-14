package com.cy.service;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

public interface PurchaseManage {
	public abstract WebDriver purchaseProduct(WebDriver dr);
	public abstract WebDriver queryPurchaseHistory(WebDriver dr) throws SQLException;
}
