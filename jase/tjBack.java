package com.tj3.jase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import com.tianjian.jase.*;

public class tjBack {

	public static void main(String[] args) throws InterruptedException,
			IOException {

		// �������������
		Browser B = new Browser("http://192.168.1.222:8099/tianjiBack/login");
		// ���
		B.driver.manage().window().maximize();
		// 10s��λ����ʱ�䣬10s��δ�ҵ�������׳��쳣
		B.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ��̨��¼
		Model.backLogin(B.driver, "wangchao", "1");
		// �����û�
		Model.addUser(B.driver, "1");
		// ��ʼ����
		// ���ù�������
		Model.set(B.driver);
		// ���ù�����������
		Model.set1(B.driver);
		// ����������Чʱ��
		Model.set2(B.driver);

		// ���´���(ǰ�˵�¼)
		// ��ǰ�������
		JavascriptExecutor oJavaScriptExecutor = (JavascriptExecutor) B.driver;
		oJavaScriptExecutor
				.executeScript("window.open('http://192.168.1.222:8091/tj3.0/');");
		// �л����
		Model.qieh(B.driver);
		// ��¼
		Model.login(B.driver, Model.Ndate, "1");
		Thread.sleep(1000 * 3);
		tianjiModel.jietu(B.driver, "���ɹ�");

	}
}
