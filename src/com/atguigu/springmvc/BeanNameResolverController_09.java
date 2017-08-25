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
	 * 自定义视图
	 * 1.在springmvc 定义 视图解析器
			 * <!-- 配置视图  BeanNameViewResolver 解析器: 使用视图的名字来解析视图 -->
			<!-- 通过 order 属性来定义视图解析器的优先级, order 值越小优先级越高 -->
			<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
				<property name="order" value="100"></property>
			</bean>
		2.编写 自定义的 视图 
	 * 			编写的类 实现 view接口
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";//返回的 名字是 类名，如果类名首字母大写 返回的是 首字母小写
							// 比如 类名 HelloView ,此处返回 helloView
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
