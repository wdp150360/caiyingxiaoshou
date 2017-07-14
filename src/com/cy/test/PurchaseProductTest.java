package com.cy.test;

import org.openqa.selenium.WebDriver;

import com.cy.commons.impl.DriversImpl;
import com.cy.commons.impl.LoginImpl;
import com.cy.service.impl.PurchaseManageImpl;

public class PurchaseProductTest {
	public static void main(String[] args){
		WebDriver dr = new DriversImpl().getIEDriver();
//		WebDriver dr = driver.IEDriver();
		dr = new LoginImpl().uiWebLogin(dr, "001", "123456");
		dr = new PurchaseManageImpl().purchaseProduct(dr);
		dr.close();
	}
}
