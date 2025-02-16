package org.example.service.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReportService {
    public void generateReport(String filePath, String sheetName,
                               List<String> headers, List<Map<String, Object>> data) throws IOException;
}
