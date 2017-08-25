<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <a href="springmvc/testPdfView">TestPdfView</a>
  <br><br>
  
  <a href="springmvc/testExcelView">TestExcelView</a>
  <br><br>
  
  <a href="springmvc/testRedirect">Test Redirect</a>
	<br><br>

	<a href="springmvc/testView">Test View</a>
	<br><br>

	<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
	<br><br>
  <!--  
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
	<form action="springmvc/testModelAttribute" method="Post">
		<input type="hidden" name="id" value="1"/>
		username: <input type="text" name="username" value="Tom"/>
		<br>
		email: <input type="text" name="email" value="tom@atguigu.com"/>
		<br>
		age: <input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>
	
  <a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
	<br><br>

	<a href="springmvc/testMap">Test Map</a>
	<br><br>

	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br><br>
	
  <a href="springmvc/testServletAPI">Test ServletAPI</a>
	<br><br>
	
  <form action="testPojo" method="post">
		username: <input type="text" name="username"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		email: <input type="text" name="email"/>
		<br>
		age: <input type="text" name="age"/>
		<br>
		city: <input type="text" name="address.city"/>
		<br>
		province: <input type="text" name="address.province"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>
	
  <a href="springmvc/testCookieValue">Test CookieValue</a>
	<br><br>

	<a href="springmvc/testRequestHeader">Test RequestHeader</a>
	<br><br>
	
	<a href="springmvc/testRequestParam?username=atguigu&age=11">Test RequestParam</a>
	<br><br>
	
  	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>
	
    <form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>

	<a href="springmvc/testPathVariable/1">Test PathVariable</a>
	<br><br>

	<a href="springmvc/testAntPath/mnxyz/abc">Test AntPath</a>
	<br><br>

	<a href="springmvc/testParamsAndHeaders?username=atguigu&age=10">Test ParamsAndHeaders</a>
	<br><br>
	
	<form action="springmvc/testMethod" method="POST">
		<input type="submit" value="submit"/>
	</form>

	<br><br>
	<a href="springmvc/testMethod">Test Method</a>

	<br><br>
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	
	<br><br>
	<a href="springmvc/testRequestMapping">Hello World</a>
  </body>
</html>
