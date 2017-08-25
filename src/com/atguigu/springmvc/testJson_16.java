package com.atguigu.springmvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Employee;
import com.atguigu.springmvc.crud.dao.EmployeeDao;

@Controller
public class testJson_16 {
	@Autowired
	private EmployeeDao employeeDao;
	/**
	 * 
	 * @ResponseBody ԭ��
	 * ���ڼ����� json jar�� �������� dispatchservlet �� messConverters �����Զ�������  MappingJackson2HttpMessageConverter��
	 * debug �вμ� DispatcherServlet.doservice-->this-->handlerAdapters-->RequestMappingHandlerAdapter-->messageConverters
	 * 
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	/**
	 * ʹ�� HttpMessageConverter<T> ��������Ϣת�����󶨵�������������л���Ӧ���תΪ��Ӧ���͵���Ӧ��Ϣ��Spring �ṩ������;��
	 * ʹ�� @RequestBody / @ResponseBody �C �Դ��������б�ע
	 * ʹ�� HttpEntity<T> / ResponseEntity<T> ��Ϊ����������λ򷵻�ֵ
	 * 
	 * ������⣺ ��֮ǰ�� �󶨲������  DataBinder (ConversionService Validator BindingResult ���ݵĸ�ʽ�� ת�� У��)ͬ�ȵ�λ�����ǰ����һ�ַ�ʽ
	 */
	@ResponseBody
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body){
		System.out.println(body);
		return "helloworld! " + new Date();
	}
	@ResponseBody
	@RequestMapping("/testHttpHttpEntity")
	public String testHttpMessageConverter(HttpEntity<String> httpEntity){
		System.out.println(httpEntity);
		return "helloworld! " + new Date();
	}
	
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte [] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
}
