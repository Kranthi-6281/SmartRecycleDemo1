package com.Smartrecycle.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utiliteis {
	
	public static final int IMPLICIT_Wait=10;
	public static final int Page_Load=10;

	public static void supplyDataExcel(String Sheet) {
		XSSFWorkbook wb=null;
		try {
		FileInputStream fisexcel=new FileInputStream("./src/main/java/com/Sr/testdata/Testcase.xlsx");
		 wb=new XSSFWorkbook(fisexcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet Sheetname = wb.getSheet(Sheet);
		int rows=Sheetname.getLastRowNum();
		int cols=Sheetname.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][cols];
		
	}

}
