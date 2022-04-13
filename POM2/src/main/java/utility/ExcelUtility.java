package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	@DataProvider(name = "courses testdata")
	public String[][] getCourseNameData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		return readtestData("courses",System.getProperty("user.dir")+"\\src\\test\\resources\\Excels\\Dashboard.xlsx");
	}
	
	@DataProvider(name = "languages testdata")
	public String[][] getlanguagesNameData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		return readtestData("languages",System.getProperty("user.dir")+"\\src\\test\\resources\\Excels\\Dashboard.xlsx");
	}
	
	@DataProvider(name = "AddUser testdata")
	public String[][] getAddUserData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		return readtestData("course",System.getProperty("user.dir")+"\\src\\test\\resources\\Excels\\courses.xlsx");
	}
	
	public String[][] readtestData(String sheetName,String filepath) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
      
		Sheet sheet=null;
		
		Workbook workbook=WorkbookFactory.create(fis); 
      
		sheet=workbook.getSheet(sheetName);
 	
		int rows=sheet.getLastRowNum()+1;  //getLastRowNum() return index based last row no
		int colums=sheet.getRow(0).getLastCellNum();  //getLastCellNum() return physical based actual last cell no

		String logindata[][]=new String[rows][colums];

		Cell cell;
		String content;

		for(int i=0;i<rows;i++) {

			for(int j=0;j<colums;j++) {

				cell=sheet.getRow(i).getCell(j);

				content=cell.getStringCellValue();

				logindata[i][j]=content;
				
			}
		}
		return logindata;
	
	}


}
