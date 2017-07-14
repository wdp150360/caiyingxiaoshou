package com.cy.service;

import org.openqa.selenium.WebDriver;

public interface SystemManage {

	public abstract WebDriver addDepartment(WebDriver dr,String dName);
	public abstract WebDriver deleteDepartment(WebDriver dr,String dName);
	public abstract WebDriver editDepartment(WebDriver dr,String dName,String updateName);
	
	public abstract WebDriver addRegion(WebDriver dr,String rName);
	public abstract WebDriver deleteRegion(WebDriver dr,String rName);
	public abstract WebDriver editRegion(WebDriver dr,String rName,String updateName);
	
	public abstract WebDriver addBusinessArea(WebDriver dr,String baName);
	public abstract WebDriver deleteBusinessArea(WebDriver dr,String baName);
	public abstract WebDriver editBusinessArea(WebDriver dr,String baName,String updateName);
	
	public abstract WebDriver addBusinessDepartment(WebDriver dr,String bdName);
	public abstract WebDriver deleteBusinessDepartment(WebDriver dr,String bdName);
	public abstract WebDriver editBusinessDepartment(WebDriver dr,String bdName,String updateName);
	
	public abstract WebDriver addTeam(WebDriver dr,String tName);
	public abstract WebDriver deleteTeam(WebDriver dr,String tName);
	public abstract WebDriver editTeam(WebDriver dr,String tName,String updateName);
	
	public abstract WebDriver addEmployee(WebDriver dr,String eName,String Staffid,String pwd,String hireDate);
	public abstract WebDriver deleteEmployee(WebDriver dr,String Staffid);
	public abstract WebDriver editEmployee(WebDriver dr,String Staffid,String updateName);
}
