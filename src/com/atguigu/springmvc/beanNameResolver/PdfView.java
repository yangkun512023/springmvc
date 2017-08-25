package com.atguigu.springmvc.beanNameResolver;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.atguigu.bean.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class PdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 String fileName = "�û���Ϣ.pdf"; // ����response��ʽ,ʹִ�д�controllerʱ���Զ���������ҳ��,����ֱ��ʹ��excel��
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition",
	                "attachment; filename=" + new String(fileName.getBytes(), "iso8859-1"));
	        List<User> userList = (List<User>) model.get("userList");
	        BaseFont bfChinese = BaseFont.createFont("C://Windows//Fonts//simfang.ttf", BaseFont.IDENTITY_H,
	                BaseFont.NOT_EMBEDDED);

	        com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);

	        for (int i = 0; i < userList.size(); i++) {
	            User user = userList.get(i);
	            String value = "ID: " + user.getId() + "����: " + user.getUsername() + ",����: " + user.getEmail() + ",����: "
	                    + user.getPassword();
	            document.add(new Paragraph(value, FontChinese));
	        }
	}

}
