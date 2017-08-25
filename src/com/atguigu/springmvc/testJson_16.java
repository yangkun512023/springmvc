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
	 * @ResponseBody 原理
	 * 由于加入了 json jar包 ，所以在 dispatchservlet 的 messConverters 里面自动加入了  MappingJackson2HttpMessageConverter。
	 * debug 中参见 DispatcherServlet.doservice-->this-->handlerAdapters-->RequestMappingHandlerAdapter-->messageConverters
	 * 
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	/**
	 * 使用 HttpMessageConverter<T> 将请求信息转化并绑定到处理方法的入参中或将响应结果转为对应类型的响应信息，Spring 提供了两种途径
	 * 使用 @RequestBody / @ResponseBody – 对处理方法进行标注
	 * 使用 HttpEntity<T> / ResponseEntity<T> 作为处理方法的入参或返回值
	 * 
	 * 个人理解： 跟之前的 绑定参数入参  DataBinder (ConversionService Validator BindingResult 数据的格式化 转换 校验)同等地位，都是绑定入参一种方式
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
