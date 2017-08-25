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
//	1.�� springmvc.xml ���� 
//
//	<!-- ���ù��ʻ���Դ�ļ� -->
//		<bean id="messageSource"
//			class="org.springframework.context.support.ResourceBundleMessageSource">
//			<property name="basename" value="i18n"></property>	
//		</bean>
//		
//		
//		2.��src�� ���� ��Դ�ļ� i18n.properties
//		
//		3.�� success��jsp�� ���ñ�ǩ���Ҳ���
//		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
//		
//		<fmt:message key="i18n.username"></fmt:message>
//		<br><br>
//		
//		
//		���� ��Ҫҳ���ֶ��л� �������ʵ�� ��Ӣ�ģ�����Զ��أ�
//		
//		1.��springmvc.xml ������ SessionLocalResolver  �Լ� ���� LocaleChanceInterceptor  ������ԭ�� �鿴 pdf 113 ���������£�
//		
//		<!-- ���� SessionLocalResolver -->
//		<bean id="localeResolver"
//			class="org.springframework.web.servlet.i18n.SessionLocaleResolver"></bean>
//			
//		<mvc:interceptors>
//			<!-- ���� LocaleChanceInterceptor -->
//			<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"></bean>
//		</mvc:interceptors>
//		
//		2.��ҳ����õ�ʱ��  ���� locale�ֶ� 
//		<a href="i18n?locale=zh_CH">����</a>
	
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
		String ll= messageSource.getMessage("i18n.username", null,locale);
		System.out.println(ll);
		return "i18n";
	}
}
