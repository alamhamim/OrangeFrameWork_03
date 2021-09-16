package com.dataProvider;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpreadSheetReader {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        FileInputStream file = null;
        XSSFSheet sheet = null;
        XSSFWorkbook book = null;
        Object[][] data = null;

        try {
           file = new FileInputStream(new File("Test-Data.xlsx"));
           book = new XSSFWorkbook(file);
           sheet = book.getSheetAt(0);

            int rowNum = sheet.getLastRowNum();
            int cellNum = sheet.getRow(0).getLastCellNum();

            data = new Object[rowNum][cellNum];

            for (int r = 1; r <= rowNum; r++) {
                for (int c = 0; c < cellNum; c++) {
                    XSSFCell cell = sheet.getRow(r).getCell(c);

                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            data[r][c] = cell.getNumericCellValue();
                        case XSSFCell.CELL_TYPE_STRING:
                            data[r][c] = cell.getStringCellValue();

                        default:
                            break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Check the book file");

        }

        //
        //
        return data;

    }

}
