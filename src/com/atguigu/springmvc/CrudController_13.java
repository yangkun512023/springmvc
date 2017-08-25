package com.atguigu.springmvc;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.Employee;
import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;

/**
 * 
 * @title CrudController_13
 * @todo TODO ��ϰ crud ����
 * @param
 * @return 
 * @date Aug 24, 2017
 * @author yangk
 */
@Controller
public class CrudController_13 {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/emps")//��ȡ�б�
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)//��ȡ���ҳ��
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	@RequestMapping(value="/emp", method=RequestMethod.POST)//���Ա��
	public String save(@Valid Employee employee, Errors result, 
			Map<String, Object> map){
		System.out.println("save: " + employee);
		
		if(result.getErrorCount() > 0){
			System.out.println("������!");
			
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			
			//����֤����, ��ת���Ƶ�ҳ��
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)//ɾ��Ա��
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)//�޸�Ա��  ���Ա�
	public String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.PUT)//�޸�Ա��
	public String update(Employee employee){
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,//Ϊ�� lastname ��ʼ��
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	/**
	 * ��ʼ�� webdatabinder  ������ ʹ�� form�� Ī���Զ����󶨵������ �ȹ���
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
}
