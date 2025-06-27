package com.inputs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class ExcelDatas {
	
     	@DataProvider(name="LoginData")
		public Object[][] tc1() throws IOException {
			
		    File f=new File("C:\\Users\\ADMIN\\Documents\\Custom Office Templates\\Book1.xlsx");
			
			FileInputStream file=new FileInputStream(f);
			
			Workbook w=new XSSFWorkbook(file);
			
			Sheet sheet = w.getSheet("Sheet1");
			int num = sheet.getLastRowNum();
			
			Object[][] data=new Object[num][2];
			
			for(int i=0;i<num;i++) {
				
					
		          	Row row = sheet.getRow(i);
			
			        Cell cell = row.getCell(0);
			        Cell cell2 = row.getCell(1);
			        
			        data[i][0] = cell.getStringCellValue();
			        data[i][1] = cell2.getStringCellValue();
			       
			        
		}
			
	     	w.close();
			return data;
		}
	}


