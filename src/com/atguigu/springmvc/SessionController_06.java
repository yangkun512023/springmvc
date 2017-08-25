package com.atguigu.springmvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atguigu.bean.User;

@Controller
@RequestMapping("/springmvc")
//@SessionAttributes(value={"user","school"})  
@SessionAttributes(value={"user"},types={String.class})
public class SessionController_06 {
	private static final String SUCCESS ="success";
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
	 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
	 * 
	 * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map){
		User user = new User("Tom", "123456", "tom@atguigu.com", 15);
		map.put("use", user);
		map.put("school", "atguigu");
		return SUCCESS;
	}
	
	/**
	 * 
	 * @param map
	 * @return   不会被执行 
	 */
	@RequestMapping("/testString")
	public String testString(Map<String,Object> map){
		map.put("ff", "测试String");
		return SUCCESS;
	}
}
