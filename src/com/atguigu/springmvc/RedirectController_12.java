package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class RedirectController_12 {
	private static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		//return "redirect:/index.jsp";//�ض���  url �����ı�
		return "forward:/WEB-INF/views/index.jsp";  //ת�� url ����
	}
	
}
