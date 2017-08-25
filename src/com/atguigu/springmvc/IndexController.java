package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1. ʹ�� @RequestMapping ע����ӳ������� URL
 * 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ, ���� InternalResourceViewResolver ��ͼ������, �������µĽ���:
 * ͨ�� prefix + returnVal + ��׺ �����ķ�ʽ�õ�ʵ�ʵ�������ͼ, Ȼ����ת������
 * 
 * ��ʱ����url:
 * http://127.0.0.1/springmvc/springmvc/
 * 
 * @return
 */
@Controller
@RequestMapping("/springmvc")
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
