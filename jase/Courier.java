package com.tj3.jase;

import java.util.concurrent.TimeUnit;

import com.tianjian.jase.Browser;

public class Courier {

	public static void main(String[] args) throws InterruptedException {

		Browser B = new Browser("http://tj.sunsharp.cn/");

		B.driver.manage().window().maximize();

		B.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Model.login(B.driver, "15000003", "1068");
	
		Model.courier(B.driver);
		

	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	

		
	
	
	
}
