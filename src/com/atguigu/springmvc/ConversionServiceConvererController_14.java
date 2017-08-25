package com.atguigu.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.Employee;
import com.atguigu.springmvc.crud.dao.EmployeeDao;

/**
 * 
 * @title ConversionServiceConvererController_14
 * @todo TODO
 * @param1.  ��springmvc.xml ������ ת���� ��ע�ᵽ <mvc:annotation-driven></mvc:annotation-driven>	
		                  ������룺<mvc:default-servlet-handler/>

						<mvc:annotation-driven conversion-service="conversionService"></mvc:annotation-driven>	
						
						<!-- ���� ConversionService -->
						<bean id="conversionService"
							class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
							<property name="converters">
								<set>
									<ref bean="employeeConverter"/>
								</set>
							</property>	
						</bean>
 * @return 
 * @date Aug 25, 2017
 * @author yangk
 */
@Controller
public class ConversionServiceConvererController_14 {
	@Autowired
    private EmployeeDao employeeDao;
	@RequestMapping("/testConversionServiceConverer")
	public String testConversionServiceConverer(@RequestParam("employee") Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
