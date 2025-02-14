package org.example.service.user.IMPL;

import org.example.utils.ExcelUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportServiceIMPL implements org.example.service.user.ReportService {
    public ReportServiceIMPL() {
    }

    @Override
    public void generateReport(String filePath, String sheetName,
                               List<String> headers, List<Map<String, Object>> data) throws IOException {
        ExcelUtils.exportToExcel(filePath, sheetName, headers, data);
    }
}
