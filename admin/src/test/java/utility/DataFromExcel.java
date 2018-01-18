package utility;

import org.testng.annotations.DataProvider;

public class DataFromExcel {
	
	public static String[][] getExcelData(String fileName, String sheetName) {
		
		ExcelUtility excel = new ExcelUtility(".//resources/");
		excel.setExcel(fileName, sheetName);
		int nor = excel.getRowNumber();
		int noc = excel.getColumnNumber();
		String[][] data = new String[nor-1][noc];
		for(int r = 1; r<nor;r++) {
			for(int c =0; c<noc;c++) {
				data[r-1][c] = excel.readData(r, c);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="branchData")
	public Object[][] branchData(){
		return DataFromExcel.getExcelData("kexim data.xls", "branches");
	}
	
	@DataProvider(name="roleData")
	public Object[][] roleData(){
		return DataFromExcel.getExcelData("kexim data.xls", "roles");
	}
	
	

}
