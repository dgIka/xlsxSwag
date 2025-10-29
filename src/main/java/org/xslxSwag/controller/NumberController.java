package org.xslxSwag.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xslxSwag.Service.ExcelReadService;
import org.xslxSwag.Service.SelectNService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/n-min")
@RequiredArgsConstructor
public class NumberController {
    private final ExcelReadService excelReadService;
    private final SelectNService selectNService;


    @GetMapping
    @Operation(summary = "Возвращает N-ое минимальное число")
    public Integer findNMin(@Parameter(description = "Путь к .XLSX файлу") @RequestParam("path") String path
            , @Parameter(description = "Порядковый номер числа") @RequestParam("n") Integer n) {
        try {
            List<Integer> numbers = excelReadService.readColumn(path);
            return selectNService.findNSmallest(numbers, n);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}
