package org.xslxSwag.Service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReadService {
    public List<Integer> readColumn(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath); Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        }
        return numbers;
    }
}
