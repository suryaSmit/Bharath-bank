package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtility {
	Workbook book;
	Sheet sh;
	WritableWorkbook wbook;
	WritableSheet wsh;
	String folderPath;
	String fileName;
	
	public ExcelUtility(String folderPath) {
		this.folderPath = folderPath;
	}
	
	
	
	//set excel file to read data
	public void setExcel(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(folderPath+fileName);
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//read data
	public String readData(int r, int c) {
		return sh.getCell(c, r).getContents();
	}
	
	//number of rows
	public int getRowNumber() {
		return sh.getRows();
	}
	
	//number of columns
	public int getColumnNumber() {
		return sh.getColumns();
	}
	
	//set excel file to write data
	public void setExcelToWriteData(String ifileName, String ofileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(folderPath+ifileName);
			book = Workbook.getWorkbook(fis);
			FileOutputStream fos = new FileOutputStream(folderPath+ofileName);
			wbook = Workbook.createWorkbook(fos, book);
			wsh = wbook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//write data
	public void writeData(int r, int c, String data) {
		try {
			wsh.addCell(new Label(c, r, data));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//save workbook
	public void saveWorkbook() {
		try {
		wbook.write();
		wbook.close();
		book.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
