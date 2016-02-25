/*---------------------------------------------------------------------------------------------------------------------
<copyright file="ExcelUtils.java" company="Astegic Infosoultions" Product= "MForms">
Copyright 2015
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static Sheet sh;
	private static Workbook wb;
	private static Cell Cell;
	private static Row Row;
	
	
	/*public static Object[][] getTableArray(String FilePath, String SheetName)  {   
		try {
			FileInputStream	ExcelFile = new FileInputStream(FilePath);
			wb = WorkbookFactory.create(ExcelFile);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		} 
		sh = wb.getSheet(SheetName);
		int startRow = 1;
		int startCol = 0;
		int celli, cellj;
		int totalRows = sh.getLastRowNum();
		int totalCols = 2;
		String[][] Array=new String[totalRows][totalCols];
		celli=0;
		for (int i=startRow;i<=totalRows;i++,celli++){               
			cellj=0;
			for (int j=startCol;j<=totalCols;j++, cellj++) {
				try {
					Array[celli][cellj]=getCellData(i,j);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Array[celli][cellj]);  
			}
		}
		return(Array);
	}*/
	
	//This method is to set the File path and to open the Excel file, Pass Excel excel file name with it's Path and Sheet name as Arguments to this method
    public static void setExcelFile(String excelfilename,String SheetName) throws Exception {
           try {
               // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(excelfilename);
            // Access the required test data sheet
            wb = WorkbookFactory.create(ExcelFile);
            sh = wb.getSheet(SheetName);
            Log.info("Excel sheet opened");
            } catch (Exception e){
                throw (e);
            }
    }
		
  //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int RowNum, int ColNum) throws Exception{
           try{
        	   Cell = sh.getRow(RowNum).getCell(ColNum);
              String CellData = Cell.getStringCellValue();
              return CellData;
              }catch (Exception e){
                return"";
              }
    }
	   
    
    //This method is to write in the Excel cell, Row num and Col num are the parameters
    @SuppressWarnings("static-access")
    public static void setCellData(String Result, int RowNum, int ColNum, String excelfilename) throws Exception    {
    	try{
    		Row  = sh.getRow(RowNum);
    		Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
    		if (Cell == null) {
    			Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
    		} else {
    			Cell.setCellValue(Result);
    		}
    		// Constant variables Test Data path and Test Data file name
    		FileOutputStream fileOut = new FileOutputStream(excelfilename);
    		wb.write(fileOut);
    		fileOut.flush();
    		fileOut.close();
    	}catch(Exception e){
    		throw (e);
    	}
    }
		 
    public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
    	int i;
    	try {
    		int rowCount = ExcelUtils.getRowUsed();
    		for ( i=0 ; i<rowCount; i++){
    			if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
    				break;
    			}
    		}
    		return i;
    	}catch (Exception e){
    		Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
    		throw(e);
    	}
    }
     	
    
    // This method is get to the last row number from the excel sheet to check how much data is there in form of number of rows
    public static int getRowUsed() throws IOException {
    	try{
    		int RowCount = sh.getLastRowNum();
    		Log.info("Total number of Row used return as < " + RowCount + " >.");		
    		return RowCount;
    	}catch (Exception e){
    		Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
    		System.out.println(e.getMessage());
    		throw (e);
    	}
    }
}
