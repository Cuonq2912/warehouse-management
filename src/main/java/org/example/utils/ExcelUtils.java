package org.example.utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;

public class ExcelUtils {

    public static void exportToExcel(String filePath, String sheetName,
                                     List<String> headers, List<Map<String, Object>> data) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            validateInput(filePath, sheetName, headers, data);
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers.get(i));
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Map<String, Object> rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String header : headers) {
                    Cell cell = row.createCell(colNum++);
                    Object value = rowData.get(header);
                    setCellValue(cell, value);
                }
            }

            for (int i = 0; i < headers.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fileOutput = new FileOutputStream(filePath)) {
                workbook.write(fileOutput);
            } catch (IOException e) {
                throw new IOException("Failed to write Excel file: " + e.getMessage(), e);
            }
        }
    }

    private static void setCellValue(Cell cell, Object value) {
        if (value == null) {
            cell.setCellValue("");
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(value.toString());
        }
    }

    private static void validateInput(String filePath, String sheetName, List<String> headers,
                                      List<Map<String, Object>> data) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        if (sheetName == null || sheetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Sheet name cannot be null or empty");
        }
        if (headers == null || headers.isEmpty()) {
            throw new IllegalArgumentException("Headers cannot be null or empty");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
    }
}