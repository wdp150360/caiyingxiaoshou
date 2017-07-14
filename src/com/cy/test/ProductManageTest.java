package com.cy.test;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.cy.commons.impl.DriversImpl;
import com.cy.commons.impl.LoginImpl;
import com.cy.service.impl.ProductManageImpl;

public class ProductManageTest {
	public static void main(String[] args) throws SQLException{
		WebDriver dr = new DriversImpl().getIEDriver();
		dr = new LoginImpl().uiWebLogin(dr, "001", "123456");
//		dr = new ProductManageImpl().addProduct(dr, "wwww", 10, 1);
		dr = new ProductManageImpl().queryProduct(dr, "哒哒");
//		dr = new ProductManageImpl().deleteProduct(dr, "wwww", 10, "已结束");
		dr.close();
	}
}
