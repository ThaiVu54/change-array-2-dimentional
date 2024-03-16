//package com.example.testall.controller;
//
//import com.example.testall.model.Item;
////import com.example.testall.repository.ItemRepository;
////import com.example.testall.service.ItemService;
//import net.sf.jasperreports.engine.JRException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//public class ItemController {
////    @Autowired
////    ItemRepository itemRepository;
//
////    @Autowired
////    ItemService itemService;
//
//    @GetMapping("item-report/{format}")
//    public ResponseEntity<Resource> getItemReport(@PathVariable String format) throws JRException, IOException {
//        List<Item> items = itemRepository.findAll();
//        byte[] reportContent = itemService.getItemReport(itemRepository.findAll(), format);
//
//        ByteArrayResource resource = new ByteArrayResource(reportContent);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .contentLength(resource.contentLength())
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        ContentDisposition.attachment()
//                                .filename("item-report." + format)
//                                .build().toString())
//                .body(resource);
//    }
//
//    @GetMapping(value = "/printPdf")
//    public ResponseEntity printPostageGeneration(@RequestParam String printName) throws IOException, JRException {
//        return new ResponseEntity(itemService.printPdf(printName), HttpStatus.OK);
//    }
//
//}
