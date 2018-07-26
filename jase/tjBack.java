package com.tj3.jase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import com.tianjian.jase.*;

public class tjBack {

	public static void main(String[] args) throws InterruptedException,
			IOException {

		// 导入浏览器驱动
		Browser B = new Browser("http://192.168.1.222:8099/tianjiBack/login");
		// 最大化
		B.driver.manage().window().maximize();
		// 10s定位对象时间，10s内未找到对象就抛出异常
		B.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 后台登录
		Model.backLogin(B.driver, "wangchao", "1");
		// 新增用户
		Model.addUser(B.driver, "1");
		// 开始设置
		// 设置关联地域
		Model.set(B.driver);
		// 设置关联方案配置
		Model.set1(B.driver);
		// 设置数据有效时间
		Model.set2(B.driver);

		// 打开新窗口(前端登录)
		// 打开前端浏览器
		JavascriptExecutor oJavaScriptExecutor = (JavascriptExecutor) B.driver;
		oJavaScriptExecutor
				.executeScript("window.open('http://192.168.1.222:8091/tj3.0/');");
		// 切换句柄
		Model.qieh(B.driver);
		// 登录
		Model.login(B.driver, Model.Ndate, "1");
		Thread.sleep(1000 * 3);
		tianjiModel.jietu(B.driver, "内蒙古");

	}
}
