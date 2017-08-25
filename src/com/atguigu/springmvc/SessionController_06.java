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
	 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е�������(ʵ����ʹ�õ��� value ����ֵ),
	 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ��� types ����ֵ)
	 * 
	 * ע��: ��ע��ֻ�ܷ����������. ���������ηŷ���. 
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
	 * @return   ���ᱻִ�� 
	 */
	@RequestMapping("/testString")
	public String testString(Map<String,Object> map){
		map.put("ff", "����String");
		return SUCCESS;
	}
}
