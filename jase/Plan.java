package com.tj3.jase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.tianjian.jase.Browser;

public class Plan {

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

		// ��������
		Model.plan(B.driver);

		// �Զ��岼��
		Model.custom(B.driver);

	}

}
