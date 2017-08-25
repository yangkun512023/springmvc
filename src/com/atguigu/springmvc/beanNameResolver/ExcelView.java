package com.atguigu.springmvc.beanNameResolver;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.atguigu.bean.User;

@Component
public class ExcelView  extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		String fileName = "�û��б�excel.xls";  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/ms-excel");  
        response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes(),"iso8859-1")); 
        //Ҫֱ������  Content-Disposition  attachment;filename=xxx.xls
        OutputStream outputStream = response.getOutputStream();
        
        List<User> userList = (List<User>) model.get("userList");
        // ����Excel��ͷ
        HSSFSheet sheet = workbook.createSheet("������Ϣ");
        HSSFRow header = sheet.createRow(0);
        // ����������
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("����");
        header.createCell(2).setCellValue("����");
        header.createCell(3).setCellValue("����");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        int rowNumber = 1;
        for (User user : userList) {
            HSSFRow row = sheet.createRow(rowNumber++);
            // ����������
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getUsername());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(3).setCellValue(user.getPassword());
        }
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
		
	}



