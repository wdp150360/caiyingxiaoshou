package com.cy.service.impl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cy.service.DataReport;

public class DataReportImpl implements DataReport{

	@Override
	public WebDriver performanceStatistics(WebDriver dr) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//ul[@id='J_Nav']/li[5]/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_5Tree']/ul/li/ul/li[1]/a")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_5Tab']/div/div[2]/div/iframe[@src='showDetailPerformance']"));
		dr.switchTo().frame(frame);
		// 业务中心 查询
		Select centreId = new Select(dr.findElement(By.id("centreId")));
		centreId.selectByValue("31");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select districtId = new Select(dr.findElement(By.id("districtId")));
		districtId.selectByValue("229");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select businessDistrictId = new Select(dr.findElement(By.id("businessDistrictId")));
		businessDistrictId.selectByValue("231");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select businessDepartId = new Select(dr.findElement(By.id("businessDepartId")));
		businessDepartId.selectByValue("235");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select owendTeamId = new Select(dr.findElement(By.id("owendTeamId")));
		owendTeamId.selectByValue("243");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select employeeJobNum = new Select(dr.findElement(By.id("employeeJobNum")));
		employeeJobNum.selectByValue("111111");
		dr.findElement(By.xpath(""));
		return dr;
	}

	@Override
	public WebDriver billDetails(WebDriver dr) {
		// TODO Auto-generated method stub
		return dr;
	}

}
