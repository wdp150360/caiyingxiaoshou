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
import org.openqa.selenium.support.ui.Select;

import com.cy.service.ProductManage;
import com.cy.utils.DBUtil;

public class ProductManageImpl implements ProductManage{
	
	@Override
	public WebDriver queryProduct(WebDriver dr,String pName) throws SQLException {
		// TODO Auto-generated method stub
		String queryByProductName = "select count(*) as totalRow from product p where p.productName =" + "'" + pName + "';";
		Connection con = new DBUtil().getCon();
		Statement stm = con.createStatement();
		ResultSet rsByProductName = stm.executeQuery(queryByProductName);
		rsByProductName.next();
		int queryResByProductName = rsByProductName.getInt("totalRow");
		dr.findElement(By.xpath("//li[@id='module2']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_2Tree']/ul/li/ul/li[1]/a[@href='viewPrivateProductTable']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_2Tab']/div/div[2]/div/iframe[@src='viewPrivateProductTable']"));
		dr.switchTo().frame(frame);
		//产品名称查询
		dr.findElement(By.id("productName")).sendKeys(pName);
		dr.findElement(By.xpath("//div[@class='search']/button")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		queryResult(dr,queryResByProductName,"产品名称");
		System.out.println(" ");
		dr.findElement(By.id("productName")).clear();
		//产品状态查询--全部
		String queryByProductStateAll = "select count(*) as Row from product";
		ResultSet rsByProductStateAll = stm.executeQuery(queryByProductStateAll);
		rsByProductStateAll.next();
		int queryResByProductStateAll = rsByProductStateAll.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[1]")).click();
		queryResult(dr,queryResByProductStateAll,"产品状态查询--全部");
		System.out.println(" ");
		//产品状态查询--预热（待签协议）
		String queryByProductState1 = "select count(*) as Row from product p where p.productState = '1'";
		ResultSet rsByProductState1 = stm.executeQuery(queryByProductState1);
		rsByProductState1.next();
		int queryResByProductState1 = rsByProductState1.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[2]")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		queryResult(dr,queryResByProductState1,"产品状态查询--预热（待签协议）");
		System.out.println(" ");
		//产品状态查询--预热（已签协议）
		String queryByProductState2 = "select count(*) as Row from product p where p.productState = '2'";
		ResultSet rsByProductState2 = stm.executeQuery(queryByProductState2);
		rsByProductState2.next();
		int queryResByProductState2 = rsByProductState2.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[3]")).click();
		queryResult(dr,queryResByProductState2,"产品状态查询--预热（已签协议）");
		System.out.println(" ");
		//产品状态查询--正在募集
		String queryByProductState3 = "select count(*) as Row from product p where p.productState = '3'";
		ResultSet rsByProductState3 = stm.executeQuery(queryByProductState3);
		rsByProductState3.next();
		int queryResByProductState3 = rsByProductState3.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[4]")).click();
		queryResult(dr,queryResByProductState3,"产品状态查询--正在募集");
		System.out.println(" ");
		//产品状态查询--已成立
		String queryByProductState4 = "select count(*) as Row from product p where p.productState = '4'";
		ResultSet rsByProductState4 = stm.executeQuery(queryByProductState4);
		rsByProductState4.next();
		int queryResByProductState4 = rsByProductState4.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[5]")).click();
		queryResult(dr,queryResByProductState4,"产品状态查询--已成立");
		System.out.println(" ");
		//产品状态查询--已结束
		String queryByProductState5 = "select count(*) as Row from product p where p.productState = '5'";
		ResultSet rsByProductState5 = stm.executeQuery(queryByProductState5);
		rsByProductState5.next();
		int queryResByProductState5 = rsByProductState5.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[6]")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		queryResult(dr,queryResByProductState5,"产品状态查询--已结束");
		System.out.println(" ");
		//产品状态查询--已下架
		String queryByProductState6 = "select count(*) as Row from product p where p.productState = '6'";
		ResultSet rsByProductState6 = stm.executeQuery(queryByProductState6);
		rsByProductState6.next();
		int queryResByProductState6 = rsByProductState6.getInt("Row");
		dr.findElement(By.xpath("//dl[@id='type']/dd[7]")).click();
		queryResult(dr,queryResByProductState6,"产品状态查询--已下架");
		System.out.println(" ");
		return dr;
	}

	@Override
	public WebDriver addProduct(WebDriver dr,String pName, int totalAmount, int lowestLimit) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module2']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_2Tree']/ul/li/ul/li[1]/a[@href='viewPrivateProductTable']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_2Tab']/div/div[2]/div/iframe[@src='viewPrivateProductTable']"));
		dr.switchTo().frame(frame);
		dr.findElement(By.xpath("//div[@id='operator']/button")).click();
		dr.findElement(By.name("productName")).sendKeys(pName);
		dr.findElement(By.name("manager")).sendKeys("UI测试");
		dr.findElement(By.name("productTime")).sendKeys("6");
		dr.findElement(By.name("dividendWay")).sendKeys("现金");
		Select productInvestSelect = new Select(dr.findElement(By.id("productInvestSelect")));
		dr.findElement(By.id("txt")).sendKeys(productInvestSelect.getOptions().get(1).getText());
		dr.findElement(By.name("totalAmount")).sendKeys(Integer.toString(totalAmount));
		dr.findElement(By.name("startAmount")).sendKeys(Integer.toString(lowestLimit));
		dr.findElement(By.id("markingFactor")).sendKeys("1");
		Select productStateSelect = new Select(dr.findElement(By.id("productStateSelect")));
		productStateSelect.selectByValue("5");
		dr.findElement(By.xpath("//div[@class='footer']/button")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String name = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[1]/td[2]")).getText();
		String TAmount = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[1]/td[8]")).getText();
		if(name.equals(pName) && TAmount.equals(Integer.toString(totalAmount))){
			System.out.println("添加产品成功！");
		}else{
			System.out.println("添加产品失败！");
		}
		return dr;
	}

	@Override
	public WebDriver editProduct(WebDriver dr,String pName, String updatePName, int totalAmount, int updateTotalAmount) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) as Row from product p where p.productName= " + "'" + pName + "'";
		dr.findElement(By.xpath("//li[@id='module2']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_2Tree']/ul/li/ul/li[1]/a[@href='viewPrivateProductTable']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_2Tab']/div/div[2]/div/iframe[@src='viewPrivateProductTable']"));
		dr.switchTo().frame(frame);
		dr.findElement(By.id("productName")).sendKeys(pName);
		dr.findElement(By.xpath("//div[@class='search']/button")).click();
		Connection con = new DBUtil().getCon();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		rs.next();
		int  queryProductRes = rs.getInt("Row");
		int pagination = 0;
		int a = 0;
		if(queryProductRes == 0){
			String msg = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr/td")).getText();
			if("没 有 查 询 结 果".equals(msg)){
				System.out.print("无该产品记录！");
			}else{
				System.out.print("查询失败");
			}
		}else if(queryProductRes > 30){
			pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText());
			a = 3;
		}else if (queryProductRes > 0 && queryProductRes <= 30){
			pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText());
			a = 2;
		}
		ln:
			for(int i = 1;i <= pagination;){
				List<WebElement> temp = dr.findElements(By.xpath("//tbody[@id='tbody-productQueryRes']/tr"));
				for(int k = 1; k <= temp.size();k++){
					 String name = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[2]")).getText();
					 String TAmount = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[8]")).getText();
					 if(name.equals(pName) && TAmount.equals(Integer.toString(totalAmount))){
						 dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[12]/a")).click();
						 WebElement Ename = dr.findElement(By.name("productName"));
						 Ename.clear();
						 Ename.sendKeys(updatePName);
						 WebElement eTotalAmount = dr.findElement(By.name("totalAmount"));
						 eTotalAmount.clear();
						 eTotalAmount.sendKeys(Integer.toString(updateTotalAmount));
						 dr.findElement(By.xpath("//div[@class='footer']/button")).click();
						 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						 String Uname = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[1]/td[2]")).getText();
						 String UTAmount = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[1]/td[8]")).getText();
						 if(Uname.equals(updatePName) && UTAmount.equals(Integer.toString(updateTotalAmount))){
							 System.out.println("编辑产品成功！");
						 }else{
							 System.out.println("编辑产品失败！");
						 }
						 break ln;
					 }else{
						 System.out.println("无该产品记录！");
					 }
				 }
				 if(i != pagination){
					 i++;
					 dr.findElement(By.xpath("//div[@id='Pagination']/a[" + a +"]")).click();
				 }else{
					 i++;
				 }
			 }
		return dr;
	}
	
	//只有已结束、已下架产品能够删除
	@Override
	public WebDriver deleteProduct(WebDriver dr,String pName, int totalAmount,String productState) throws SQLException {
		// TODO Auto-generated method stub
		String sql = null;
		dr.findElement(By.xpath("//li[@id='module2']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_2Tree']/ul/li/ul/li[1]/a[@href='viewPrivateProductTable']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_2Tab']/div/div[2]/div/iframe[@src='viewPrivateProductTable']"));
		dr.switchTo().frame(frame);
		if("已结束".equals(productState)){
			sql = "select count(*) as Row from product p where p.productName= " + "'" + pName + "'" + " and p.productState='5'";
			dr.findElement(By.xpath("//dl[@id='type']/dd[6]")).click();
		}else if("已下架".equals(productState)){
			sql = "select count(*) as Row from product p where p.productName= " + "'" + pName + "'" + " and p.productState='6'";
			dr.findElement(By.xpath("//dl[@id='type']/dd[7]")).click();
		}
		dr.findElement(By.id("productName")).sendKeys(pName);
		dr.findElement(By.xpath("//div[@class='search']/button")).click();
		Connection con = new DBUtil().getCon();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		rs.next();
		int  queryProductRes = rs.getInt("Row");
		int pagination = 0;
		int a = 0;
		if(queryProductRes == 0){
			String msg = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr/td")).getText();
			if("没 有 查 询 结 果".equals(msg)){
				System.out.print("无该产品记录！");
			}else{
				System.out.print("查询失败");
			}
		}else if(queryProductRes > 30){
			pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText());
			a = 3;
		}else if (queryProductRes > 15 && queryProductRes <= 30){
			pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText());
			a = 2;
		}else if(queryProductRes > 0 && queryProductRes <= 15){
			pagination = 1;
		}
		ln:
			for(int i = 1;i <= pagination;){
				List<WebElement> temp = dr.findElements(By.xpath("//tbody[@id='tbody-productQueryRes']/tr"));
				for(int k = 1; k <= temp.size();k++){
					 String name = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[2]")).getText();
					 String TAmount = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[8]")).getText();
					 if(name.equals(pName) && TAmount.equals(Integer.toString(totalAmount))){
						 dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr[" + k + "]" + "/td[12]/a[2]")).click();
						 dr.switchTo().alert().accept();
						 dr.switchTo().defaultContent();
						 dr.switchTo().frame(frame);
						 System.out.print("删除产品成功!");
						 break ln;
					 }else{
						 System.out.println("无该产品记录！");
					 }
				 }
				 if(i != pagination){
					 i++;
					 dr.findElement(By.xpath("//div[@id='Pagination']/a[" + a +"]")).click();
				 }else{
					 i++;
				 }
			 }
		return dr;
	}
	
	public WebDriver queryResult(WebDriver dr,int sqlQueryResult,String queryMethod){
		List<WebElement> productList = null;
		int queryProductRes = 0;
		if(sqlQueryResult == 0){
			String msg = dr.findElement(By.xpath("//tbody[@id='tbody-productQueryRes']/tr/td")).getText();
			if("没 有 查 询 结 果".equals(msg)){
				System.out.print(queryMethod + "-查询成功！");
			}else{
				System.out.print(queryMethod + "-查询失败");
			}
		}else if(sqlQueryResult > 30){
			int Pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText());
			dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).click();
			productList = dr.findElements(By.xpath("//tbody[@id='tbody-productQueryRes']/tr"));
			queryProductRes = 15*(Pagination-1) + productList.size();
			if(sqlQueryResult == queryProductRes){
				System.out.print(queryMethod + "-查询成功！");
			}else{
				System.out.print(queryMethod + "-查询失败");
			}
		}else if(15 < sqlQueryResult && sqlQueryResult <=30){
			dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).click();
			productList = dr.findElements(By.xpath("//tbody[@id='tbody-productQueryRes']/tr"));
			queryProductRes = 15 + productList.size();
			if(sqlQueryResult == queryProductRes){
				System.out.print(queryMethod + "-查询成功！");
			}else{
				System.out.print(queryMethod + "-查询失败");
			}
		}else if(0 < sqlQueryResult && sqlQueryResult <= 15){
			productList = dr.findElements(By.xpath("//tbody[@id='tbody-productQueryRes']/tr"));
			queryProductRes = productList.size();
			if(sqlQueryResult == queryProductRes){
				System.out.print(queryMethod + "-查询成功！");
			}else{
				System.out.print(queryMethod + "-查询失败");
			}
		}
		System.out.print(sqlQueryResult);
		System.out.print("----" + queryProductRes);
		return dr;
	}
}
