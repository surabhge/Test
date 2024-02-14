package dataproviderdemo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    //HSSFWorkbook,HSSFSheet,HSSFCell,HSSFRow
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    //Workbook wbs;

    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheetname as Arguments to this method
    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e) {
            throw (e);
        }
    }

    public  Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            setExcelFile(FilePath, SheetName);
            //temp variables
            int ci, cj;
            // Total number of rows
            int totalRows = ExcelWSheet.getLastRowNum();
            // From the rows how many columns/cells
            int noOfColumns = ExcelWSheet.getRow(totalRows).getLastCellNum();
            int col = noOfColumns - 1;
            tabArray = new String[totalRows][col];
            ci = 0;
            // Row values
            for (int i = 1; i <= totalRows; i++, ci++) {
                cj = 0;
                // Column values
                for (int j = 1; j <= col; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);// data from the excel
                    System.out.println("The values for i and j : " + tabArray[ci][cj]);
                }
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);

    }

    // This method is to read the test data from the Excel cell, in this we are
    // passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }


    public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
        int i;
        try {
            int rowCount = ExcelUtil.getRowUsed();
            for (i = 0; i < rowCount; i++) {
                if (ExcelUtil.getCellData(i, colNum).contains(sTestCaseName)) {
                    break;
                }
            }
            return i;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowUsed() throws Exception {

        try {
            int RowCount = ExcelWSheet.getLastRowNum();
            return RowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

}
