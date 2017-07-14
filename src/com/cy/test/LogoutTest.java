package com.cy.test;

import org.openqa.selenium.WebDriver;

import com.cy.commons.impl.DriversImpl;
import com.cy.commons.impl.LoginImpl;
import com.cy.commons.impl.LogoutImpl;

public class LogoutTest {
	public static void main(String[] args){
		WebDriver dr = new DriversImpl().getIEDriver();
		dr = new LoginImpl().uiWebLogin(dr, "001", "123456");
		dr = new LogoutImpl().logout(dr);
	}
}
