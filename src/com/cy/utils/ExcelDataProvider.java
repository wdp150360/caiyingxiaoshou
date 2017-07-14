package com.cy.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;

import jxl.*;

/**
 * Excel放在dataSource文件夹下
 * Excel命名方式：测试类名.xls
 * Excel的sheet命名方式：测试方法名
 * Excel第一行为Map键值
 * 
 * @ClassName: ExcelDataProvider
 * @Description: TODO(读取Excel数据)
 * 
 */
public class ExcelDataProvider implements Iterator<Object[]>{
	
	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;
	private int currentRowNo = 0;
	private int columnNum = 0;
	private String[] columnName;
	
	public ExcelDataProvider(String className,String methodName){
		try{
			int dotNum = className.indexOf(".");
			if(dotNum > 0 ){
				className = className.substring(className.lastIndexOf(".") + 1,className.length());
			}
			 //从/dataSource文件夹下读取以类名命名的excel文件
			String path = "src/dataSource/" + className + ".xls";
			InputStream inputStream = new FileInputStream(path);
			book = Workbook.getWorkbook(inputStream);
			//取sheet
			sheet = book.getSheet(methodName);
			rowNum = sheet.getRows();
			Cell[] cell = sheet.getRow(0);
			columnNum = cell.length;
			columnName = new String[columnNum];
			
			for(int i = 0; i < columnNum;i++){
				columnName[i] = cell[i].getContents().toString();
			}
			currentRowNo++;
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("unable to read excel data");
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(this.rowNum == 0 || this.currentRowNo >= this.rowNum){
			try{
				book.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}else{
			// sheet下一行内容为空判定结束
			if(sheet.getRow(currentRowNo)[0].getContents().equals(""))
				return false;
			return true;
		}
	}

	@Override
	public Object[] next() {
		// TODO Auto-generated method stub
		Cell[] c = sheet.getRow(this.currentRowNo);
		Map<String,String> data = new HashMap<String,String>();
		
		for(int i = 0;i < this.columnNum;i++){
			String temp = "";
			try{
				temp = c[i].getContents().toString();
			}catch(ArrayIndexOutOfBoundsException e){
				temp = "";
			}
			data.put(this.columnName[i], temp);
		}
		Object object[] = new Object[1];
		object[0] = data;
		this.currentRowNo++;
		return object;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("remove unsupported");
	}

}
