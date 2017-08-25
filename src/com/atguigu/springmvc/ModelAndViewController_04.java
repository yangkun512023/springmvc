package com.atguigu.springmvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc")
public class ModelAndViewController_04 {
	private static final String SUCCESS="success";
	/**
	 * Ŀ�귽���ķ���ֵ������ ModelAndView ���͡� 
	 * ���п��԰�����ͼ��ģ����Ϣ
	 * SpringMVC ��� ModelAndView �� model �����ݷ��뵽 request �������. 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView mv=new ModelAndView(SUCCESS);
		mv.addObject("time",new Date());
		return mv;
	}
}
