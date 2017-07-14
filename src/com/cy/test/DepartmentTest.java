package com.cy.test;

import org.openqa.selenium.WebDriver;

import com.cy.commons.impl.DriversImpl;
import com.cy.commons.impl.LoginImpl;
import com.cy.service.impl.SystemManageImpl;

public class DepartmentTest {
	public static void main(String[] args){
		WebDriver dr = new DriversImpl().getIEDriver();
		dr = new LoginImpl().uiWebLogin(dr, "001", "123456");
//		dr = new SystemManageImpl().addDepartment(dr, "哒哒");
//		dr = new SystemManageImpl().editDepartment(dr, "哒哒", "哒哒1");
//		dr = new SystemManageImpl().deleteBusinessArea(dr, "哒哒");
		dr = new SystemManageImpl().addEmployee(dr, "哒哒", "150360", "123456", "2016/08/03");
		dr.close();
	}
}
