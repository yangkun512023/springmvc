package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.User;

@Controller
public class BeanController_02 {
	private static final String INDEX ="index";
	/**
	 * Spring MVC �ᰴ����������� POJO �����������Զ�ƥ�䣬 �Զ�Ϊ�ö����������ֵ��֧�ּ������ԡ�
	 * �磺dept.deptId��dept.address.tel ��
	 */
	@RequestMapping("/testPojo")
	public String testPoji(User user){
		System.out.println("testPojo:"+user);
		return INDEX;
	}
}
