package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class prac {
	int k=0;
	int column;
	ArrayList <String>al = new ArrayList();
	public void getss(String tcname) throws IOException {
	
	FileInputStream fi = new FileInputStream("");
	XSSFWorkbook wb = new XSSFWorkbook(fi);

	int Sheets=wb.getNumberOfSheets();
	
	for (int i=0; i<Sheets; i++) {
		XSSFSheet sheet=wb.getSheetAt(i);
		
		if (sheet.getSheetName().equalsIgnoreCase("Test Data")) {
		
		Iterator <Row> rows= sheet.rowIterator();
		Row fr=rows.next();
		Iterator<Cell>cells=fr.cellIterator();
		
		while (cells.hasNext()) {
			if (cells.next().getStringCellValue().equalsIgnoreCase("Test Case")) {
				column=k;
			}k++;
		}
		
		while (rows.hasNext()) {
			Row sr=rows.next();
			if(sr.getCell(column).getStringCellValue().equalsIgnoreCase(tcname)) {
				Iterator<Cell>vf=sr.cellIterator();
				while (vf.hasNext()) {
				if (vf.next().getCellType()==CellType.STRING) {
					al.add(vf.next().getStringCellValue());
				}else {
					String h=NumberToTextConverter.toText(vf.next().getNumericCellValue());
					al.add(h);
				}
			}}
		}
	}
	}
}}
