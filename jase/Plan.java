package com.tj3.jase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.tianjian.jase.Browser;

public class Plan {

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

		// 方案配置
		Model.plan(B.driver);

		// 自定义布局
		Model.custom(B.driver);

	}

}
