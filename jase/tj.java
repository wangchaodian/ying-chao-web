package com.tj3.jase;

import java.util.concurrent.TimeUnit;

import com.tianjian.jase.Browser;

public class tj {
	
	public static void main(String [] args) throws InterruptedException{
		
		Browser B =new Browser("http://192.168.1.222:8091/tj3.0/");
//		��󻯴���
		B.driver.manage().window().maximize();
//		���ö�λԪ�س�ʱ8S�״�
		B.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		Model.login(B.driver, "test2", "1");
      

		
	}
		

}
