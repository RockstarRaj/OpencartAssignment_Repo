package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public static Object[][] ReadExcel(String FilePath, String Sheetname) throws IOException
	{
		
		File fil = new File(FilePath);
		FileInputStream fis = new FileInputStream(fil);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(0);
		Row Headerrow = sh.getRow(0);
		int colcount = row.getLastCellNum();
		Object[][] obj = new Object[rowcount][1];
		Hashtable<String,String> hash =null;
		for(int i=1;i<=rowcount;i++)
		{
			hash = new Hashtable<String,String>();
			row = sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String value = cell.getStringCellValue().toString();
				String key = Headerrow.getCell(j).getStringCellValue().toString();
				hash.put(key, value);
				
			}
			obj[i-1][0]= hash;
		}
		
		return obj;
		
	}
	
	@DataProvider(name="CreateAccount")
	public static Object[][] CreateAccount() throws IOException
	{
		String FilePath = "D:\\mavenProject\\AssignmentNew1\\DataSheet.xlsx";
		Object[][] obj = ReadExcel(FilePath,"CreateAccount");
		return obj;
	}
	
	 @DataProvider
	    public Object[][] getData(ITestContext context) {
	        String parameter = context.getCurrentXmlTest().getLocalParameters().get("mybrowser");
	        String[] names = parameter.split(",");
	        Object[][] returnValues = new Object[names.length][1];
	        int index = 0;
	        for (Object[] each : returnValues) {
	            each[0] = names[index++].trim();
	        }
	        return returnValues;
	    }

}
