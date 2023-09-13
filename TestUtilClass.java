package com.CRM.QA.Utile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.QA.Base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtilClass extends TestBase {
	
     
	public TestUtilClass() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}



	public static long PAGE_LOAD_TIMEOUT=100;
	public static long IMPLICITLY_TIMEOUT=10;
	 
	
	
	public void SwitchTpFrame() {
		driver.switchTo().frame("mainpanel");
	}
	 static Workbook book;
	 static  Sheet sheet;
	 public static String TESTDATA_SHEET_PATH="C:\\Users\\balar\\eclipse-workspace\\CRMdataAnalysis\\src"
	 		+ "\\main\\java\\com\\CRM\\QA\\TestData\\DealsData.xlsx";
	 public static String TESTDATA_SHEET_PAT="C:\\Users\\balar\\eclipse-workspace\\CRMdataAnalysis\\src"
		 		+ "\\main\\java\\com\\CRM\\QA\\TestData\\CRMdata.xlsx";
	
	public static Object[][] getTestData(String sheetName) throws Exception {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	 public static void takeScreenShotatendofTest() throws IOException {
		 File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		 
		 FileUtils.copyFile(srcfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() +".png"));
	 }
}
