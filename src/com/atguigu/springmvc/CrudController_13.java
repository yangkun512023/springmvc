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
 * @todo TODO 练习 crud 操作
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
	
	@RequestMapping("/emps")//获取列表
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)//获取添加页面
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	@RequestMapping(value="/emp", method=RequestMethod.POST)//添加员工
	public String save(@Valid Employee employee, Errors result, 
			Map<String, Object> map){
		System.out.println("save: " + employee);
		
		if(result.getErrorCount() > 0){
			System.out.println("出错了!");
			
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			
			//若验证出错, 则转向定制的页面
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)//删除员工
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)//修改员工  回显表单
	public String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.PUT)//修改员工
	public String update(Employee employee){
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,//为了 lastname 初始化
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	/**
	 * 初始化 webdatabinder  ，可以 使得 form表单 莫个自动不绑定到入参中 等功能
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
}
