package com.atguigu.springmvc;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class ServletAPIController_03 {
	private static final String INDEX ="index";
	/**
	 * ����ʹ�� Serlvet ԭ���� API ��ΪĿ�귽���Ĳ��� ����֧����������
	 * 
	 * HttpServletRequest 
	 * HttpServletResponse 
	 * HttpSession
	 * java.security.Principal 
	 * Locale InputStream 
	 * OutputStream 
	 * Reader 
	 * Writer
	 * @throws IOException 
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request,
			HttpServletResponse response, Writer out) throws IOException {
		//System.out.println("testServletAPI, " + request + ", " + response);
		out.write("hello springmvc");
		return INDEX;
	}
}
