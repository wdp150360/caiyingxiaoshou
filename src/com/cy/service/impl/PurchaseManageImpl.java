package com.cy.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cy.service.PurchaseManage;
import com.cy.utils.DBUtil;

public class PurchaseManageImpl implements PurchaseManage{

	@Override
	public WebDriver purchaseProduct(WebDriver dr) {
		// TODO Auto-generated method stub
		String customerName = "丁玲123";	
		
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_1Tab']/div/div[2]/div/iframe[@src='viewProduct']"));
		dr.switchTo().frame(frame);
		dr.findElement(By.xpath("//*[@id='type']/dd[4]/label")).click();
		dr.findElement(By.xpath("//*[@id='tbody-productQueryRes']/tr[1]/td[12]/a")).click();
//		String href = "productId=" + id;//id数据库取
//		dr.findElement(By.xpath("//a[contains(@href,'href')]")).click();
		dr.findElement(By.xpath("//span[@class='l-btn-icon icon-search']")).click();
		dr.findElement(By.id("name")).sendKeys(customerName);
		dr.findElement(By.xpath("//form[@name='employeeBaseInfosForm']/div/div/button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@onclick='javascript:chooseCustomer(this,243)']")).click();
		dr.findElement(By.id("chargeDate")).sendKeys("2016/08/20");
		dr.findElement(By.id("planInvestAmount")).sendKeys("10000");
		dr.findElement(By.id("contractNo")).sendKeys("123456");
		dr.findElement(By.id("contractAmount")).sendKeys("20000");
		dr.findElement(By.id("chargeAmount")).sendKeys("30000");
		dr.findElement(By.id("periodNumber")).sendKeys("6");
		dr.findElement(By.id("paymentType")).sendKeys("现金");
		dr.findElement(By.id("billDate")).sendKeys("2016/08/21");
		dr.findElement(By.id("billCapital")).sendKeys("20000");
		dr.findElement(By.id("billInterest")).sendKeys("2000");
		dr.findElement(By.id("submit")).click();
		String message = dr.findElement(By.xpath("//div[contains(text(),'添加成功')]")).getText();
		if("添加成功".equals(message)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		dr.findElement(By.xpath("//div[@class='messager-button']/a/span/span[@class='l-btn-text']")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();
//		dr.findElement(By.xpath("//ul[@class='tab-nav-list']/li[2]")).click();
		
		WebElement frame1 = dr.findElement(By.xpath("//div[@id='J_1Tab']/div/div[2]/div[2]/iframe[@src='getcustomerpurchaselist']"));
		dr.switchTo().frame(frame1);
		
		String message1 = dr.findElement(By.xpath("//form[@id='customerpurchaseform']/table/tbody/tr[1]/td[2]")).getText();
		if(message1.equals(customerName)){
			System.out.println("购买记录生成成功");
		}else{
			System.out.println("购买记录生成失败");
		}
		return dr;
	}

	@Override
	public WebDriver queryPurchaseHistory(WebDriver dr) throws SQLException {
		// TODO Auto-generated method stub
		String customerName = "丁玲123";
		String sql = "select count(*) as HRow from customerProduct  where customerBaseInfoId = '159'";
		dr.findElement(By.xpath("//ul[@id='J_NavContent']/li[1]/div[1]/div[1]/ul/li/ul/li[2]/a")).click();
//		dr.findElement(By.xpath("//*[text()='购买记录']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_1Tab']/div/div[2]/div[2]/iframe[@src='getcustomerpurchaselist']"));
		dr.switchTo().frame(frame);
		dr.findElement(By.id("customerName")).sendKeys(customerName);
		dr.findElement(By.xpath("//form[@id='customerpurchaseform']/div[1]/button[@type='button']")).click();
		List<WebElement> historyList = dr.findElements(By.xpath("//form[@id='customerpurchaseform']/table/tbody/input"));
		//查询数据库记录数
		Connection con = new DBUtil().getCon();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int nRow = rs.getInt("HRow");
		if(historyList.size() == nRow){
			System.out.println("查询成功");
		}else{
			System.out.println(historyList.size());
			System.out.println(nRow);
			System.out.println("查询失败");
		}
		return dr;
	}

}
