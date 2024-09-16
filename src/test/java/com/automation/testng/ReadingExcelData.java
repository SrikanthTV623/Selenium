package com.automation.testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadingExcelData {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("PositiveData");
        //to print single cell from excel sheet
        XSSFRow row1 = sheet.getRow(0);
        XSSFCell cell1 = row1.getCell(1);
        System.out.print(cell1.getStringCellValue());
        System.out.println();

        //to print the entire table from excel sheet
        int noOfRows = sheet.getLastRowNum();
        for(int i=0;i<=noOfRows;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                System.out.print(getCellData(cell)+" ");
            }
            System.out.println();
        }
    }
    //to take all values of int,string,null etc... should be printed
    public static String getCellData(Cell cell){
        if(cell == null){
            return "";
        }
        CellType cellType = cell.getCellType();

        switch(cellType){
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BLANK:
                return "";
        }
        return null;
    }
}
