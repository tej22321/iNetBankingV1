package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	String ExcelFilePath = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData";
	String ExcelFileName= "freeCRMTestData.xlsx";

	public XLUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public Object[][] readExcel(String SheetName) {
		
		File  f = new File(ExcelFilePath+"/"+ExcelFileName);
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook guru99LoginWorkBook = null;
		
	String ExcelFileExtension =	ExcelFileName.substring(ExcelFileName.indexOf(".xlsx"));
		
		if(ExcelFileExtension.endsWith(".xlsx")) {
			try {
				guru99LoginWorkBook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ExcelFileExtension.endsWith(".xlx")) {
			guru99LoginWorkBook = new HSSFWorkbook();
		}
		
		
Sheet Guru99LoginSheetName = guru99LoginWorkBook.getSheet(SheetName);

int totalNoOfRows  = Guru99LoginSheetName.getLastRowNum();
System.out.println("totalNoOfRows---"+ totalNoOfRows);
int totalNoOfColumns = Guru99LoginSheetName.getRow(0).getLastCellNum();
System.out.println("totalNoOfColumns--" + totalNoOfColumns);

Object obj[][] = new Object[totalNoOfRows][totalNoOfColumns];

 
for(int i =0; i<totalNoOfRows;i++) {
	for(int j =0;j<totalNoOfColumns; j++) {
 obj[i][j] = Guru99LoginSheetName.getRow(i+1).getCell(j).getStringCellValue();
 System.out.println(obj[i][j]);
	}
	
	
}
return obj;

	}

}
