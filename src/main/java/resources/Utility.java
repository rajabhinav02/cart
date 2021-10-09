package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Utility extends baseClass {
	
	public static ExtentReports ext;
	int k=0;
	int column;
	ArrayList<String>el= new ArrayList();

	public static void getScreenshot(String tcname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dst = System.getProperty("user.dir")+"//reports//"+ tcname +".png";
		FileUtils.copyFile(src, new File (dst));
	}
	
	public static ExtentReports getExtentReport() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Veg Cart");
		
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(reporter);
		return ext;
		
	}
	
	public ArrayList<String> inputdata(String sheetname,String tcname) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\SelTestData\\TestDatatwo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int Sheets=wb.getNumberOfSheets();
		
		for (int i=0; i<Sheets; i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			
			if (sheet.getSheetName().equalsIgnoreCase(sheetname)) {
				Iterator<Row>rows=sheet.rowIterator();
				Row fr = rows.next();
				Iterator<Cell> cells=fr.cellIterator();
				
				while (cells.hasNext()) {
					if (cells.next().getStringCellValue().equals("Test Name")) {
						column=k;
					}k++;
				}
				
				while (rows.hasNext()) {
					Row sr = rows.next();
					if (sr.getCell(column).getStringCellValue().equalsIgnoreCase(tcname)) {
						
						Iterator<Cell>ce=sr.cellIterator();
						
						while (ce.hasNext()) {
							Cell gh = ce.next();
							if (gh.getCellType()== CellType.STRING) {
								el.add(gh.getStringCellValue());
							}else {
								String a=NumberToTextConverter.toText(gh.getNumericCellValue());
								el.add(a);
							}
						}
					}
				}
			}
		}
		return el;
	}
}

