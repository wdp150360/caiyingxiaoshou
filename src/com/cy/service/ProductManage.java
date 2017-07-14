package com.cy.service;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

public interface ProductManage {
	
	public abstract WebDriver queryProduct(WebDriver dr,String pName) throws SQLException;
	public abstract WebDriver addProduct(WebDriver dr,String pName,int totalAmount,int lowestLimit);
	public abstract WebDriver editProduct(WebDriver dr,String pName,String updatePName,int totalAmount,int updateTotalAmount) throws SQLException;
	public abstract WebDriver deleteProduct(WebDriver dr,String pName,int totalAmount,String productState) throws SQLException;
	
}
