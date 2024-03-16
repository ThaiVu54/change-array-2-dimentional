//package com.example.testall.service;
//
//import com.example.testall.model.Item;
////import com.example.testall.repository.ItemRepository;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ResourceUtils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//public class ItemService {
////    @Autowired
////    private ItemRepository itemRepository;
//    public byte[] getItemReport(List<Item> items, String format) throws FileNotFoundException, JRException {
//
//        File file = ResourceUtils.getFile("classpath:template/item-report.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("title", "Item Report");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//        byte[] reportContent = null;
//        try {
//            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//            switch (format) {
//                case "pdf" -> reportContent = JasperExportManager.exportReportToPdf(jasperPrint);
//                case "xml" -> reportContent = JasperExportManager.exportReportToXml(jasperPrint).getBytes();
//                default -> throw new RuntimeException("Unknown report format");
//            }
//        } catch (JRException e) {
//            log.error("Error: " + e.getMessage());
//        }
//
//        return reportContent;
//    }
//    public String printPdf(String printName) throws IOException, JRException {
//        String filePath = printName + ".jrxml";
////        List<Item> items = itemRepository.findAll();
//        Map<String, Object> map = new HashMap<>();
////        JRDataSource dataSource = new JRBeanCollectionDataSource(items);
////        map.put("dataSource", dataSource);
//        JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("templates/" + filePath).getInputStream());
////        byte[] pdfByte = JasperExportManager.exportReportToPdf(JasperFillManager.fillReport(jasperReport, map, dataSource));
////        return Base64.getEncoder().encodeToString(pdfByte);
//    }
//
//}
