package com.atguigu.springmvc;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class testMapController_05 {
	private static final String SUCCESS="success";
	/**
	 * Ŀ�귽��������� Map ����(ʵ����Ҳ������ Model ���ͻ� ModelMap ����)�Ĳ���. 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map){
		System.out.println(map.getClass().getName());
		//map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return SUCCESS;
	}
}
