package com.automation.testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadingExcelDataUsingForLoop {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("PositiveData");
        for(Row row:sheet){
            for(Cell cell:row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
