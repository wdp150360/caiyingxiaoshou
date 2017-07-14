package com.cy.test;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.cy.commons.impl.DriversImpl;
import com.cy.commons.impl.LoginImpl;
import com.cy.service.impl.PurchaseManageImpl;

public class QueryPurchaseHistoryTest {
	public static void main(String[] args) throws SQLException{
		WebDriver dr = new DriversImpl().getIEDriver();
		dr = new LoginImpl().uiWebLogin(dr, "001", "123456");
		dr = new PurchaseManageImpl().queryPurchaseHistory(dr);
		dr.close();
	}
}
