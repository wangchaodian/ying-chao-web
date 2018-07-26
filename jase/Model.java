package com.tj3.jase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tianjian.jase.tianjiModel;

public class Model {

	private static Scanner sc;
	public static String Ndate;

	// 前端登录
	public static void login(WebDriver driver, String username, String password)
			throws InterruptedException {

		Thread.sleep(1000 * 3);
		driver.findElement(By.className("login-toggle")).click();
		Thread.sleep(1000 * 2);
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div/div[2]/label[1]/input"))
				.sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div/div[2]/label[2]/input"))
				.sendKeys(password);
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div/div[2]/label[2]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000 * 5);

	}

	// 后台登录
	public static void backLogin(WebDriver driver, String name, String password)
			throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		// 输入验证码
		sc = new Scanner(System.in);
		System.out.println("请验证码 ： ");
		String code = sc.nextLine();
		driver.findElement(By.id("code")).sendKeys(code);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='loginform']/form/div[5]/div/input[1]"))
				.click();

	}

	// 新增用户
	public static void addUser(WebDriver driver, String pwd)
			throws InterruptedException {

		Thread.sleep(1000 * 2);
		driver.findElement(By.xpath("/html/body/aside/div/dl[1]/dt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/aside/div/dl[1]/dd/ul/li[1]/a"))
				.click();

		// 进入iframe表单
		Thread.sleep(1000);
		WebElement iframe = driver.findElement(By
				.xpath("//*[@id='iframe_box']/div[2]/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		driver.findElement(By.id("addUser")).click();
		Thread.sleep(1000);
		// 获得当前日期
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH.mm.ss");// 设置日期格式("yyyy-MM-dd HH:mm:ss")
		Ndate = df.format(date);
		// System.out.println("当天日期 ： "+Ndate);
		driver.findElement(By.id("username")).sendKeys(Ndate);
		driver.findElement(By.id("userpwd")).sendKeys(pwd);
		driver.findElement(By.name("name")).sendKeys("test");
		Thread.sleep(1000);
		// 设置用户类型
		driver.findElement(By.xpath("//*[@id='userType']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='userType']/option[2]")).click();// 选择前端用户
		// 设置用户是否有效
		driver.findElement(By.xpath("//*[@id='enbale']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='enbale']/option[2]")).click();
		// 设置服务开始时间
		driver.findElement(By.id("startTime")).sendKeys("2016-07-08 00:00:00");
		// 设置服务结束时间
		driver.findElement(By.id("endTime")).sendKeys("2020-07-08 00:00:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='submitForm']/div[8]/div/input"))
				.click();

	}

	// 设置关联地域
	public static void set(WebDriver driver) throws InterruptedException {

		// 设置关联地域
		Thread.sleep(1000 * 2);
		driver.findElement(
				By.xpath("//*[@id='main']/tbody/tr[1]/td[12]/a[3]/i")).click();
		Thread.sleep(1000 * 1);
		driver.findElement(By.xpath("//*[@id='addAreaToUser']/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("area_tree_show_1_switch")).click();
		Thread.sleep(1000);
		// 选择内蒙古
		driver.findElement(By.xpath("//*[@id='area_tree_show_6_check']"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='addAreaToUser']/a[2]")).click();
	}

	// 设置关联方案配置
	public static void set1(WebDriver driver) throws InterruptedException {

		Thread.sleep(1000 * 2);
		driver.findElement(
				By.xpath("//*[@id='main']/tbody/tr[1]/td[12]/a[4]/i")).click();
		Thread.sleep(1000);
		WebElement area = driver.findElement(By
				.xpath("//*[@id='user-area-show-div']/button"));
		String areaText = area.getText();
		if (areaText.equals("内蒙古")) {
			area.click();
		}
		// 找到标准方案的数量
		Thread.sleep(1000 * 2);
		List<WebElement> level1 = driver.findElements(By
				.cssSelector("#planTree_1_ul>li"));
		// System.out.println(level1.size());

		for (int i = 2; i < level1.size() + 2; i++) {

			WebElement plans = driver.findElement(By.id("planTree_" + i
					+ "_check"));
			String text1 = driver.findElement(By.id("planTree_" + i + "_a"))
					.getText();
			if (text1.equals("省级test")) {

				plans.click();

			}

		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='addPlanToUserArea']/a")).click();
		Thread.sleep(1000 * 2);
		// 关闭
		driver.findElement(By.className("layui-layer-setwin")).click();
	}

	// 设置数据有效时间
	public static void set2(WebDriver driver) throws InterruptedException {

		Thread.sleep(1000 * 2);
		driver.findElement(
				By.xpath("//*[@id='main']/tbody/tr[1]/td[12]/a[5]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='user-area-show-div']/button"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='dataStartTime']")).sendKeys(
				"2016-07-08 00:00:00");
		Thread.sleep(1000);
		driver.findElement(By.id("dataEndTime"))
				.sendKeys("2020-07-08 00:00:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='time-config-form']/div[3]/a"))
				.click();
		Thread.sleep(1000 * 2);
		driver.findElement(By.className("layui-layer-ico")).click();

	}

	// 切换窗口
	public static void qieh(WebDriver driver) throws InterruptedException {

		// 切换到新的弹窗
		Set<String> winHandels = driver.getWindowHandles(); // 得到当前窗口的set集合
		List<String> it = new ArrayList<String>(winHandels); // 将set集合存入list对象
		driver.switchTo().window(it.get(1)); // 切换到弹出的新窗口
		Thread.sleep(1000);
		String url = driver.getCurrentUrl(); // 获取新窗口的url
		System.out.println(url);
		// driver.switchTo().window(it.get(0)); // 返回至原页面

	}

	// 配置方案
	public static void plan(WebDriver driver) throws InterruptedException {

		// 新增方案
		Thread.sleep(1000 * 2);
		driver.findElement(By.xpath("/html/body/aside/div/dl[1]/dt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/aside/div/dl[1]/dd/ul/li[2]/a"))
				.click();
		Thread.sleep(1000 * 1);
		// 进入iframe表单
		WebElement iframe = driver.findElement(By
				.xpath("//*[@id='iframe_box']/div[2]/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		driver.findElement(By.id("addPlan")).click();
		Thread.sleep(1000 * 2);
		driver.findElement(By.id("name")).sendKeys("test");
		driver.findElement(By.id("des")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();

		// 关联模块
		Thread.sleep(1000 * 2);
		driver.findElement(By.className("getModuleList")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("planModuleTree_1_check")).click();

		Thread.sleep(1000 * 2);
		List<WebElement> li = driver.findElements(By
				.cssSelector("#planModuleTree_1_ul>li"));
		System.out.println(li.size());
		driver.findElement(
				By.cssSelector("#planModuleTreeDiv > input.btn.btn-primary.radius.updatePlan"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.className("layui-layer-setwin")).click();

	}

	// 截取元素图片

	// 自定义布局
	public static void custom(WebDriver driver) throws InterruptedException,
			IOException {

		// 模块布局管理
		Thread.sleep(1000 * 2);
		driver.findElement(By.className("getPlanScreenPage")).click();
		Thread.sleep(1000 * 2);
		tianjiModel.jietu(driver, "自定义");
		driver.findElement(By.linkText("网络零售曲线")).click();
		Thread.sleep(1000 * 2);
		driver.findElement(By.cssSelector("#sizeDiv > input:nth-child(1)"))
				.click();
		Thread.sleep(1000);
		WebElement mc1 = driver.findElement(By
				.xpath("//*[@id='gridster']/ul/li"));
		Thread.sleep(1000 * 2);
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(mc1, 1200, 500).release(mc1).perform();

	}

	// 快递网点总数正确性判断
	public static void courier(WebDriver driver) throws InterruptedException {

		// 进入快递网点
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[10]/div/div/div[2]/div[2]"))
				.click();
		String sum = driver.findElement(By.className("num")).getText();
		System.out.println("快递网点页面显示总数： " + sum);

		// 查看一共有多少页
		Thread.sleep(1000 * 2);
		String page_all = driver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[2]"))
				.getText();
		int b = Integer.parseInt(page_all.substring(2));
		// System.out.println(b);

		// 跳转到最后一页
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[1]/input"))
				.clear();
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[1]/input"))
				.sendKeys(page_all.substring(2));
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[2]"))
				.click();

		// 统计最后一页的快递网点个数
		Thread.sleep(1000 * 2);
		List<WebElement> contentBox = driver.findElements(By.className("row"));
		// for (int i = 0; i < contentBox.size(); i++) {
		//
		// System.out.println(contentBox.get(i).getText());
		//
		// }
		System.out.println("快递网点计算总数： " + contentBox.size());

		// 计算出 快递网点的数量并转成String型
		int j = (b - 1) * 15 + (contentBox.size() - 10);
		System.out.println(j);
		String str = String.valueOf(j);
		System.out.println("网商总数量是否相等 ： " + sum.equals(str));
		
		// 进入物流网点
		Thread.sleep(1000 * 2);
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[1]"))
				.click();
		
		String sum1 = driver.findElement(By.className("num")).getText();
		System.out.println("物流网点页面显示总数： " + sum1);

		// 查看一共有多少页
		Thread.sleep(1000 * 2);
		String page_all1 = driver
				.findElement(
						By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[2]"))
				.getText();
		int b1 = Integer.parseInt(page_all1.substring(2));
		// System.out.println(b1);

		// 跳转到最后一页
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[1]/input"))
				.clear();
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[1]/input"))
				.sendKeys(page_all1.substring(2));
		driver.findElement(
				By.xpath("//*[@id='app']/div/div[2]/div/div[3]/div[2]/div/div/div[11]/div/div/div/div[2]/div/div/div[2]/ul/li[17]/div[3]/div/div[2]/div[2]"))
				.click();

		// 统计最后一页的快递网点个数
		Thread.sleep(1000 * 2);
		List<WebElement> contentBox1 = driver.findElements(By.className("row"));
		// for (int i = 0; i < contentBox.size(); i++) {
		//
		// System.out.println(contentBox.get(i).getText());
		//
		// }
		System.out.println("快递网点计算总数： " + contentBox1.size());

		// 计算出 快递网点的数量并转成String型
		int j1 = (b1 - 1) * 15 + (contentBox1.size() - 10);
		System.out.println(j);
		String str1 = String.valueOf(j1);
		System.out.println("网商总数量是否相等 ： " + sum.equals(str1));


	}

}
