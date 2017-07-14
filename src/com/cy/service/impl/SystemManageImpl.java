package com.cy.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cy.service.SystemManage;

public class SystemManageImpl implements SystemManage{

	@Override
	public WebDriver addDepartment(WebDriver dr, String dName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[1]/a[@href='listDeparts']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div/iframe[@src='listDeparts']"));
		dr.switchTo().frame(frame);
		//检查该部门名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			 List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			 for(int k = 2; k <= temp.size();k++){
				 String departmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(departmentName.equals(dName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在部门成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加部门
		 dr.findElement(By.xpath("//div[@class='staff_add']/button")).click();
		 dr.findElement(By.id("departName")).sendKeys(dName);
		 dr.findElement(By.id("departMemo")).sendKeys(dName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 String validateName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[2]/td[2]")).getText();
		 if(dName.equals(validateName)){
			 System.out.println("添加部门成功");
		 }else{
			 System.out.println("添加部门失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteDepartment(WebDriver dr, String dName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[1]/a[@href='listDeparts']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div/iframe[@src='listDeparts']"));
		dr.switchTo().frame(frame);
		//检查该部门名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		 for(int i = 1;i <= pagination;){
			 List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			 for(int k = 2; k <= temp.size();k++){
				 String departmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(departmentName.equals(dName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 System.out.println("删除部门成功！");
					 break ln;
				 }
			 }
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).click();
			 }else{
				 i++;
			 }
			  
		 }
		return dr;
	}

	@Override
	public WebDriver editDepartment(WebDriver dr, String dName,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[1]/a[@href='listDeparts']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div/iframe[@src='listDeparts']"));
		dr.switchTo().frame(frame);
		//检查该部门名称是否存在,如果存在就编辑，不存在不做操作
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		 for(int i = 1;i <= pagination;){
			 List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			 for(int k = 2; k <= temp.size();k++){
				 String departmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(departmentName.equals(dName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[1]")).click();
					 WebElement departName = dr.findElement(By.id("departName"));
					 departName.clear();
					 departName.sendKeys(updateName);
					 WebElement departMemo = dr.findElement(By.id("departMemo"));
					 departMemo.clear();
					 departMemo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String UdepartmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(UdepartmentName.equals(updateName)){
						 System.out.println("部门编辑成功！");
					 }
					 break ln;
				 }
			 }
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).click();
			 }else{
				 i++;
			 }
			  
		 }
		return dr;
	}

	@Override
	public WebDriver addRegion(WebDriver dr, String rName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[2]/a[@href='listAreas']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listAreas']"));
		dr.switchTo().frame(frame);
		//检查该大区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String RegionName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(RegionName.equals(rName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在大区成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加大区
		 dr.findElement(By.xpath("//div[@class='staff_add']/button")).click();
		 Select sel = new Select(dr.findElement(By.name("parentDepartId")));
		 sel.selectByValue("31");
		 dr.findElement(By.id("departName")).sendKeys(rName);
		 dr.findElement(By.id("departMemo")).sendKeys(rName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 String validateName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[2]/td[2]")).getText();
		 if(rName.equals(validateName)){
			 System.out.println("添加大区成功");
		 }else{
			 System.out.println("添加大区失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteRegion(WebDriver dr, String rName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[2]/a[@href='listAreas']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listAreas']"));
		dr.switchTo().frame(frame);
		//检查该大区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String RegionName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(RegionName.equals(rName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除大区成功！");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver editRegion(WebDriver dr, String rName,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[2]/a[@href='listAreas']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listAreas']"));
		dr.switchTo().frame(frame);
		//检查该大区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String RegionName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(RegionName.equals(rName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[1]")).click();
					 WebElement departName = dr.findElement(By.id("departName"));
					 departName.clear();
					 departName.sendKeys(updateName);
					 WebElement departMemo = dr.findElement(By.id("departMemo"));
					 departMemo.clear();
					 departMemo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String URegionName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(URegionName.equals(updateName)){
						System.out.print("大区编辑成功");
					 }
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver addBusinessArea(WebDriver dr, String baName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[3]/a[@href='listBusiness']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listBusiness']"));
		dr.switchTo().frame(frame);
		//检查该营业区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessAreaName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessAreaName.equals(baName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在营业区成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加营业区
		 dr.findElement(By.xpath("//div[@class='staff_add']/button")).click();
		 Select parentDepartId = new Select(dr.findElement(By.name("parentDepart")));
		 parentDepartId.selectByValue("31");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentAreasId = new Select(dr.findElement(By.id("parentAreasId")));
		 parentAreasId.selectByValue("229");
		 dr.findElement(By.id("departName")).sendKeys(baName);
		 dr.findElement(By.id("departMemo")).sendKeys(baName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 String validateName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[2]/td[2]")).getText();
		 if(baName.equals(validateName)){
			 System.out.println("添加营业区成功");
		 }else{
			 System.out.println("添加营业区失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteBusinessArea(WebDriver dr, String baName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[3]/a[@href='listBusiness']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listBusiness']"));
		dr.switchTo().frame(frame);
		//检查该营业区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessAreaName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessAreaName.equals(baName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在营业区成功！");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver editBusinessArea(WebDriver dr, String baName,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[3]/a[@href='listBusiness']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listBusiness']"));
		dr.switchTo().frame(frame);
		//检查该营业区名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessAreaName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessAreaName.equals(baName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[1]")).click();
					 WebElement departName = dr.findElement(By.id("departName"));
					 departName.clear();
					 departName.sendKeys(updateName);
					 WebElement departMemo = dr.findElement(By.id("departMemo"));
					 departMemo.clear();
					 departMemo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String UBusinessAreaName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(UBusinessAreaName.equals(updateName)){
						System.out.print("大区编辑成功");
					 }
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver addBusinessDepartment(WebDriver dr, String bdName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[4]/a[@href='listTransation']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTransation']"));
		dr.switchTo().frame(frame);
		//检查该业务部名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessDepartmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessDepartmentName.equals(bdName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在业务部成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加业务部
		 dr.findElement(By.xpath("//div[@class='staff_add']/button")).click();
		 Select parentDepartId = new Select(dr.findElement(By.name("parentDepart")));
		 parentDepartId.selectByValue("31");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentAreasId = new Select(dr.findElement(By.id("parentAreasId")));
		 parentAreasId.selectByValue("229");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentBusinessId = new Select(dr.findElement(By.id("parentBusinessId")));
		 parentBusinessId.selectByValue("231");
		 dr.findElement(By.id("departName")).sendKeys(bdName);
		 dr.findElement(By.id("departMemo")).sendKeys(bdName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 String validateName = dr.findElement(By.xpath("//div[@class='staff_list']/table[1]/tbody/tr[2]/td[2]")).getText();
		 if(bdName.equals(validateName)){
			 System.out.println("添加业务部成功");
		 }else{
			 System.out.println("添加业务部失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteBusinessDepartment(WebDriver dr, String bdName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[4]/a[@href='listTransation']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTransation']"));
		dr.switchTo().frame(frame);
		//检查该业务部名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessDepartmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessDepartmentName.equals(bdName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在业务部成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver editBusinessDepartment(WebDriver dr, String bdName,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[4]/a[@href='listTransation']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTransation']"));
		dr.switchTo().frame(frame);
		//检查该业务部名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[1]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String BusinessDepartmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(BusinessDepartmentName.equals(bdName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[1]")).click();
					 WebElement departName = dr.findElement(By.id("departName"));
					 departName.clear();
					 departName.sendKeys(updateName);
					 WebElement departMemo = dr.findElement(By.id("departMemo"));
					 departMemo.clear();
					 departMemo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String UBusinessDepartmentName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(UBusinessDepartmentName.equals(updateName)){
						System.out.print("大区编辑成功");
					 }
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver addTeam(WebDriver dr, String tName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[5]/a[@href='listTeams']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTeams']"));
		dr.switchTo().frame(frame);
		//检查该团队名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String TeamName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(TeamName.equals(tName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在团队成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加团队
		 dr.findElement(By.xpath("//div[@class='staff_add']/button")).click();
		 Select parentDepartId = new Select(dr.findElement(By.name("parentDepart")));
		 parentDepartId.selectByValue("31");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentAreasId = new Select(dr.findElement(By.id("parentAreasId")));
		 parentAreasId.selectByValue("229");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentBusinessId = new Select(dr.findElement(By.id("parentBusinessId")));
		 parentBusinessId.selectByValue("231");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentTransactionId = new Select(dr.findElement(By.id("parentTransactionId")));
		 parentTransactionId.selectByValue("235");
		 dr.findElement(By.id("departName")).sendKeys(tName);
		 dr.findElement(By.id("departMemo")).sendKeys(tName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 String validateName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[2]/td[2]")).getText();
		 if(tName.equals(validateName)){
			 System.out.println("添加团队成功");
		 }else{
			 System.out.println("添加团队失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteTeam(WebDriver dr, String tName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[5]/a[@href='listTeams']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTeams']"));
		dr.switchTo().frame(frame);
		//检查该团队名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String TeamName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(TeamName.equals(tName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在团队成功！");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver editTeam(WebDriver dr, String tName,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[5]/a[@href='listTeams']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='listTeams']"));
		dr.switchTo().frame(frame);
		//检查该团队名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String TeamName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(TeamName.equals(tName)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[4]/a[1]")).click();
					 WebElement departName = dr.findElement(By.id("departName"));
					 departName.clear();
					 departName.sendKeys(updateName);
					 WebElement departMemo = dr.findElement(By.id("departMemo"));
					 departMemo.clear();
					 departMemo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String UTeamName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(UTeamName.equals(updateName)){
						System.out.print("大区编辑成功");
					 }
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver addEmployee(WebDriver dr, String eName,String Staffid,String pwd,String hireDate) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[6]/a[@href='employeeList']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='employeeList']"));
		dr.switchTo().frame(frame);
		//检查该员工名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String EmployeeId = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(EmployeeId.equals(Staffid)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[9]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在员工成功！" + "----");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		 //添加员工
		 dr.findElement(By.xpath("//div[@class='search']/button[2]")).click();
		 dr.findElement(By.id("jobNum")).sendKeys(Staffid);
		 dr.findElement(By.id("name")).sendKeys(eName);
		 dr.findElement(By.id("loginPwd")).sendKeys(pwd);
		 Select parentDepartId = new Select(dr.findElement(By.id("parentDepartId")));
		 parentDepartId.selectByValue("31");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentAreasId = new Select(dr.findElement(By.id("parentAreasId")));
		 parentAreasId.selectByValue("229");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentBusinessId = new Select(dr.findElement(By.id("parentBusinessId")));
		 parentBusinessId.selectByValue("231");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentTransactionId = new Select(dr.findElement(By.id("parentTransactionId")));
		 parentTransactionId.selectByValue("235");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select parentTeamId = new Select(dr.findElement(By.id("parentTeamId")));
		 parentTeamId.selectByValue("243");
		 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Select roleId = new Select(dr.findElement(By.id("roleId")));
		 roleId.selectByValue("14");
		 dr.findElement(By.id("entryOfficeDate")).sendKeys(hireDate);
		 dr.findElement(By.id("memo")).sendKeys(eName);
		 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
		 String validateId = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[2]/td[2]")).getText();
		 if(Staffid.equals(validateId)){
			 System.out.println("添加员工成功");
		 }else{
			 System.out.println("添加员工失败");
		 }
		return dr;
	}

	@Override
	public WebDriver deleteEmployee(WebDriver dr, String Staffid) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[6]/a[@href='employeeList']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='employeeList']"));
		dr.switchTo().frame(frame);
		//检查该员工名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String EmployeeId = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(EmployeeId.equals(Staffid)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[9]/a[2]")).click();
					 dr.switchTo().alert().accept();
					 dr.switchTo().defaultContent();
					 dr.switchTo().frame(frame);
					 System.out.print("删除已存在员工成功！");
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

	@Override
	public WebDriver editEmployee(WebDriver dr, String Staffid,String updateName) {
		// TODO Auto-generated method stub
		dr.findElement(By.xpath("//li[@id='module3']/div[1]")).click();
		dr.findElement(By.xpath("//div[@id='J_3Tree']/ul/li/ul/li[6]/a[@href='employeeList']")).click();
		WebElement frame = dr.findElement(By.xpath("//div[@id='J_3Tab']/div/div[2]/div[2]/iframe[@src='employeeList']"));
		dr.switchTo().frame(frame);
		//检查该员工名称是否存在,如果存在删除
		int pagination = Integer.parseInt(dr.findElement(By.xpath("//div[@id='Pagination']/a[2]")).getText()); 
		ln:
		for(int i = 1;i <= pagination;){
			List<WebElement> temp = dr.findElements(By.xpath("//div[@class='staff_list']/table/tbody/tr"));
			for(int k = 2; k <= temp.size();k++){
				 String EmployeeId = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
				 if(EmployeeId.equals(Staffid)){
					 dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[9]/a[1]")).click();
					 WebElement name = dr.findElement(By.id("name"));
					 name.clear();
					 name.sendKeys(updateName);
					 WebElement memo = dr.findElement(By.id("memo"));
					 memo.clear();
					 memo.sendKeys(updateName);
					 dr.findElement(By.xpath("//div[@class='form_operator']/button[1]")).click();
					 String UEmployeeName = dr.findElement(By.xpath("//div[@class='staff_list']/table/tbody/tr[" + k + "]" + "/td[2]")).getText();
					 if(UEmployeeName.equals(updateName)){
						System.out.print("员工编辑成功");
					 }
					 break ln;
				 }
			 }
			 
			 if(i != pagination){
				 i++;
				 dr.findElement(By.xpath("//div[@id='Pagination']/a[3]")).click();
			 }else{
				 i++;
			 }
		 }
		return dr;
	}

}
