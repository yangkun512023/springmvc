package com.atguigu.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.exception.UserNameNotMatchPasswordException;

@Controller
public class ExceptionController_20 {
//	�쳣�ܽ᣺ 3�ַ�ʽ��
//			1.Ѱ�ұ���� @ExceptionHandler ��Ѱ������ģ���Ȼ�� @ControllerAdvice ��ǵ����в��� @ExceptionHandler ��ǵķ����������쳣
//			2.�Զ����쳣 �� @ResponseStatus 
//			3.springmvc.xml ���� ����ʹ�� SimpleMappingExceptionResolver ��ӳ���쳣,�������쳣ͳһ����
//			<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
//			<property name="exceptionAttribute" value="ex"></property>
//			<property name="exceptionMappings">
//				<props>
//					<prop key="java.lang.ArrayIndexOutOfBoundsException">error</prop>
//				</props>
//			</property>
//		</bean>	


	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
		//String [] vals = new String[10];
		//System.out.println(vals[i]);
		System.out.println("result: " + (10 / i));
		return "success";
	}
	
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		return "success";
	}
	
	@ResponseStatus(reason="����",value=HttpStatus.NOT_FOUND)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i == 13){
			throw new UserNameNotMatchPasswordException();
		}
		System.out.println("testResponseStatusExceptionResolver...");
		
		return "success";
	}
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleArithmeticException2(Exception ex){
//		System.out.println("[���쳣��]: " + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	/**
	 * 1. �� @ExceptionHandler ����������п��Լ��� Exception ���͵Ĳ���, �ò�������Ӧ�������쳣����
	 * 2. @ExceptionHandler ����������в��ܴ��� Map. ��ϣ�����쳣��Ϣ����ҳ����, ��Ҫʹ�� ModelAndView ��Ϊ����ֵ
	 * 3. @ExceptionHandler ������ǵ��쳣�����ȼ�������. 
	 * 4. @ControllerAdvice: ����ڵ�ǰ Handler ���Ҳ��� @ExceptionHandler ������������ǰ�������ֵ��쳣, 
	 * ��ȥ @ControllerAdvice ��ǵ����в��� @ExceptionHandler ��ǵķ����������쳣. 
	 */
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex){
//		System.out.println("���쳣��: " + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
		System.out.println("result: " + (10 / i));
		return "success";
	}
}
