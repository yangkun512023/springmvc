package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc")
public class RequestMapping_01 {
	private static final String INDEX ="index";
	/**
	 * 1. @RequestMapping �������η���, ������������ 2. 1). �ඨ�崦: �ṩ����������ӳ����Ϣ������� WEB Ӧ�õĸ�Ŀ¼
	 * 2). ������: �ṩ��һ����ϸ��ӳ����Ϣ�� ������ඨ�崦�� URL�����ඨ�崦δ��ע @RequestMapping���򷽷�����ǵ� URL
	 * ����� WEB Ӧ�õĸ�Ŀ¼
	 * 
	 * ��ʱurl Ϊ��  http://127.0.0.1/springmvc/springmvc/testRequestMapping
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		return INDEX;
	}
	/**
	 * ����: ʹ�� method ������ָ������ʽ
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.GET)
	public  String testMethod(){
		return INDEX;
	}
	/**
	 * �˽�: ����ʹ�� params �� headers �����Ӿ�ȷ��ӳ������. params �� headers ֧�ּ򵥵ı��ʽ.
	 * 
	 * @return
	 */
	@RequestMapping(value="testParamsAndHeaders",params={"username","age!=10"},headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParamsAndHeaders(){
		return INDEX;
	}
	/**
	 * ֧�� ant ���url
	 */
	@RequestMapping("/testAntPath/**/abc")
	public String testAntPath(){
		return INDEX;
	}
	/**
	 * @PathVariable ������ӳ�� URL �е�ռλ����Ŀ�귽���Ĳ�����.
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable int id){
		System.out.println(id);
		return INDEX;
	}
	/**
	 * Rest ���� URL. �� CRUD Ϊ��: ����: /order POST �޸�: /order/1 PUT update?id=1 ��ȡ:
	 * /order/1 GET get?id=1 ɾ��: /order/1 DELETE delete?id=1
	 * 
	 * ��η��� PUT ����� DELETE ������ ? 1. web.xml��Ҫ���� HiddenHttpMethodFilter 2. ��Ҫ���� POST ����
	 * 3. ��Ҫ�ڷ��� POST ����ʱЯ��һ�� name="_method" ��������, ֵΪ DELETE �� PUT
	 * 
	 * �� SpringMVC ��Ŀ�귽������εõ� id ��? ʹ�� @PathVariable ע��
	 * 
	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest Put: " + id);
		return INDEX;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id) {
		System.out.println("testRest Delete: " + id);
		return INDEX;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST");
		return INDEX;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable Integer id) {
		System.out.println("testRest GET: " + id);
		return INDEX;
	}
	/**
	 * @RequestParam ��ӳ���������. value ֵ����������Ĳ����� required �ò����Ƿ����. Ĭ��Ϊ true
	 *               defaultValue ���������Ĭ��ֵ
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String name,@RequestParam(value="age",defaultValue="0",required=false) int age){
		System.out.println("testRequestParam, username: " + name + ", age: "
				+ age);
		return INDEX;
	}
	/**
	 * �˽�: ӳ������ͷ��Ϣ �÷�ͬ @RequestParam
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(
			@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("testRequestHeader, Accept-Language: " + al);
		return INDEX;
	}
	/**
	 * �˽�:
	 * 
	 * @CookieValue: ӳ��һ�� Cookie ֵ. ����ͬ @RequestParam
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue: sessionId: " + sessionId);
		return INDEX;
	}
}
