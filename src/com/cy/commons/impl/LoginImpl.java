package com.cy.commons.impl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cy.commons.Login;

public class LoginImpl implements Login{
	String url = "http://ssp-test.zbjf.com/ssp/logout";
	@Override
	public WebDriver uiWebLogin(WebDriver dr, String username, String password) {
		// TODO Auto-generated method stub
		dr.get(url);
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.findElement(By.id("loginName")).sendKeys(username);
		dr.findElement(By.id("loginPwd")).sendKeys(password);
		dr.findElement(By.xpath("//input[@class='button_blue' and @type='submit'and @value='登 录']")).click();
		String element = dr.findElement(By.xpath("//span[@class = 'dl-log-user']")).getText();
		if("001".equals(element)){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return dr;
	}

}
