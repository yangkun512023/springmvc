package com.atguigu.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.User;

@Controller
@RequestMapping("/springmvc")
public class BeanNameResolverController_09 {
	private static final String SUCCESS ="success";
	/**
	 * �Զ�����ͼ
	 * 1.��springmvc ���� ��ͼ������
			 * <!-- ������ͼ  BeanNameViewResolver ������: ʹ����ͼ��������������ͼ -->
			<!-- ͨ�� order ������������ͼ�����������ȼ�, order ֵԽС���ȼ�Խ�� -->
			<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
				<property name="order" value="100"></property>
			</bean>
		2.��д �Զ���� ��ͼ 
	 * 			��д���� ʵ�� view�ӿ�
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";//���ص� ������ �����������������ĸ��д ���ص��� ����ĸСд
							// ���� ���� HelloView ,�˴����� helloView
	}
	@RequestMapping("/testExcelView")
	public String testExcelView(Map<String,Object> map){
		User user = new User(1,"Tom", "123456", "tom@atguigu.com", 15);
		User uu = new User(2,"Tom2", "123456", "tom@atguigu.com", 15);
		List list=new ArrayList();
		list.add(user);
		list.add(uu);
		map.put("userList", list);
		return "excelView";
	}
	@RequestMapping("/testPdfView")
	public String testPdfView(Map<String,Object> map){
		User user = new User(1,"Tom", "123456", "tom@atguigu.com", 15);
		User uu = new User(2,"Tom2", "123456", "tom@atguigu.com", 15);
		List list=new ArrayList();
		list.add(user);
		list.add(uu);
		map.put("userList", list);
		return "pdfView";
	}
}
