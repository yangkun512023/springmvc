package com.atguigu.springmvc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class guojihua_17 {
	@Autowired
	private ResourceBundleMessageSource messageSource;
//	1.在 springmvc.xml 配置 
//
//	<!-- 配置国际化资源文件 -->
//		<bean id="messageSource"
//			class="org.springframework.context.support.ResourceBundleMessageSource">
//			<property name="basename" value="i18n"></property>	
//		</bean>
//		
//		
//		2.在src下 创建 资源文件 i18n.properties
//		
//		3.在 success。jsp中 引用标签并且测试
//		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
//		
//		<fmt:message key="i18n.username"></fmt:message>
//		<br><br>
//		
//		
//		如上 需要页面手动切换 编码才能实现 中英文，如何自动呢？
//		
//		1.在springmvc.xml 中配置 SessionLocalResolver  以及 配置 LocaleChanceInterceptor  （具体原因 查看 pdf 113 ）代码如下：
//		
//		<!-- 配置 SessionLocalResolver -->
//		<bean id="localeResolver"
//			class="org.springframework.web.servlet.i18n.SessionLocaleResolver"></bean>
//			
//		<mvc:interceptors>
//			<!-- 配置 LocaleChanceInterceptor -->
//			<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"></bean>
//		</mvc:interceptors>
//		
//		2.在页面调用的时候  加上 locale字段 
//		<a href="i18n?locale=zh_CH">中文</a>
	
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
		String ll= messageSource.getMessage("i18n.username", null,locale);
		System.out.println(ll);
		return "i18n";
	}
}
