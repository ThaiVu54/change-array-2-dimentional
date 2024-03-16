package com.example.testall.controller;

import com.example.testall.service.ThaiService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class ThaiController {
    @Autowired
    private ThaiService thaiService;
    @GetMapping(value = "export")
    public ResponseEntity<String> exportFile(@RequestParam String file) throws JRException, IOException {
        return ResponseEntity.ok(thaiService.exportFile(file));
    }

    @PostMapping(value = "/nyc/report")
    public ResponseEntity<?> reportNyc(@RequestParam String nameFile) throws JRException, IOException {
        return ResponseEntity.ok(thaiService.exportReportFileNyc(nameFile));
    }
}
