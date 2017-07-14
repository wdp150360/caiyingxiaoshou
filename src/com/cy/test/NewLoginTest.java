package com.cy.test;

import org.testng.annotations.Test;

import com.cy.commons.impl.DriversImpl;
import com.cy.utils.ExcelDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NewLoginTest {
	WebDriver dr;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		String url = "http://ssp-test.zbjf.com/ssp/logout";
		dr = new DriversImpl().getIEDriver();
		dr.get(url);
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.manage().window().maximize();
	}
 
	@Test(enabled = true,dataProvider = "loginTest",description = "登陆")
	public void login(Map<String,String> dataDriven) {
		System.out.println(dataDriven.get("comment"));
		dr.findElement(By.id("loginName")).clear();
		dr.findElement(By.id("loginName")).sendKeys(dataDriven.get("username"));
		dr.findElement(By.id("loginPwd")).sendKeys(dataDriven.get("password"));
		dr.findElement(By.xpath("//input[@class='button_blue' and @type='submit'and @value='登 录']")).click();
		String element = dr.findElement(By.xpath("//span[@class = 'dl-log-user']")).getText();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if("001".equals(element)){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
		dr.findElement(By.xpath("//div[@class='dl-log']/a")).click();
		
	}

	@DataProvider(name = "loginTest")
	public Iterator<Object[]> data2test() {
		return new ExcelDataProvider(this.getClass().getName(),"login");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		dr.close();
	}

}
