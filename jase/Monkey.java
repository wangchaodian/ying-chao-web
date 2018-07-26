package com.tj3.jase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tianjian.jase.*;

public class Monkey {

	public static void main(String[] args) throws InterruptedException {

		// 导入浏览器驱动
		Browser B = new Browser("http://192.168.1.222:8091/tj3.0/");
		// 浏览器最大化
		B.driver.manage().window().maximize();
		// 设置定位元素超时10S抛错
		B.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Model.login(B.driver, "test2", "1");
		// 切换地域
		Thread.sleep(1000 * 5);
		WebElement head = B.driver.findElement(By
				.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[1]/div"));
		Actions action = new Actions(B.driver);
		action.moveToElement(head, 500, 1).doubleClick().perform();
		Thread.sleep(1000);
		B.driver.findElement(By.className("selector-box")).click();
		Thread.sleep(1000);
		// 内蒙古
		B.driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/ul/li[10]"))
				.click();
		Thread.sleep(1000 * 5);
		for (int i = 0; i < 1000; i++) {
			// 进入快递网点分布
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[5]/div/div/div[2]/div[2]"))
					.click();
			Thread.sleep(1000 * 1);
			String page = B.driver
					.findElement(
							By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[2]"))
					.getText();
			int a = Integer.parseInt(page.substring(2));
//			 翻页
			 for (int i1 = 0; i1 < a; i1++) {
			
			 B.driver.findElement(
			 By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[1]/div[2]"))
			 .click();
			 Thread.sleep(300);
			
			 }
//			 返回
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div[2]/header/div[1]/div"))
					.click();
			// 进入网商监控
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[8]/div/div/div/div[2]"))
					.click();
			// 返回
			Thread.sleep(1000);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div/header/div[1]/div"))
					.click();
			// 进入天玑榜
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[6]/div/div/div/div[2]"))
					.click();
			// 返回
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div/header/div[1]/div"))
					.click();
			// 进入行业细分
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[1]/div/div/div/div[2]"))
					.click();
			// 返回
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div/header/div[1]/div"))
					.click();
			// 进入网络零售闪点
			Thread.sleep(1000);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[3]/div/div/div/div[2]"))
					.click();
			// 返回
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div/header/div[1]/div"))
					.click();
			// 进入网商监控
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[4]/div/div/div/div[2]"))
					.click();
			// 返回
			Thread.sleep(1000 * 2);
			B.driver.findElement(
					By.xpath("//*[@id='app']/div/div/div[3]/div[2]/div/div/div[10]/div/div/div/div/header/div[1]/div"))
					.click();

		}

	}
}
