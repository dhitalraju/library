package com.raju.library.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author raju
 */
public class ExcelReader {

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};

    public static void createExcelFile(String fileName) throws FileNotFoundException, IOException {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper helper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("EMPLOYEE");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));
        FileOutputStream fileOut = new FileOutputStream(fileName + ".xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("DONE :: ");

    }

    public static void main(String[] args) {

        System.out.println("STARTED :: ");
        try {
            ExcelReader.createExcelFile("/home/raju/ABR/test/test");
        } catch (IOException ex) {
            System.out.println("Error ::: " +ex.getMessage());
        }

    }

}
