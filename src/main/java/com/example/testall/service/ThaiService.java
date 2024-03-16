package com.example.testall.service;

import com.example.testall.model.HoiCacEmNyc;
import com.example.testall.model.Thai;
import com.example.testall.repository.CacEmNycRepository;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jsoup.helper.W3CDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.*;

@Service
public class ThaiService {
    @Autowired
    private CacEmNycRepository cacEmNycRepository;

    public String exportFile(String file) throws IOException, JRException {
        String path = "F:/TestAll/savefile";
        List<Thai> thais = Thai.getListThai();
        Map<String, Object> parameters = new HashMap<>();
        //load file and compile it
//        File fileTemplate = ResourceUtils.getFile("classpath:templates/thai.jrxml");
        JRDataSource dataSource = new JRBeanCollectionDataSource(thais);
        JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("templates/" + "thai.jrxml").getInputStream());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (file.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/thai.html");
        }
        if (file.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/thai.pdf");
        }
        byte[] pdfByte = JasperExportManager.exportReportToPdf(jasperPrint);
        return Base64.getEncoder().encodeToString(pdfByte);
//        if (file.equalsIgnoreCase("html")) {
//            File htmlFile = new File("F:\\TestAll\\savefile\\thai.html");
//            Document doc = Jsoup.parse(htmlFile, "UTF-8");
//            doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
//            try (OutputStream os = new FileOutputStream("F:/TestAll/savefile/thaifix.pdf")) {
//                ITextRenderer renderer = new ITextRenderer();
//                SharedContext cntxt = renderer.getSharedContext();
//                cntxt.setPrint(true);
//                cntxt.setInteractive(false);
//                String baseUrl = FileSystems.getDefault().getPath("F:\\TestAll\\savefile")
//                        .toUri().toURL().toString();
//                renderer.setDocumentFromString(doc.html(), baseUrl);
//                renderer.layout();
//                renderer.createPDF(os);
//            }
//        }
//        try (OutputStream os = new FileOutputStream("thai.html")) {
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//            builder.withUri("F:\\TestAll\\savefile\\");
//                        Document doc = Jsoup.parse(new File("F:\\TestAll\\savefile\\thai.html"), "UTF-8");
//            builder.toStream(os);
//            builder.withW3cDocument(new W3CDom().fromJsoup(doc), "/");
//            builder.run();
//            String baseUrl = FileSystems.getDefault()
//                    .getPath("F:\\TestAll\\savefile\\")
//                    .toUri().toURL().toString();
//            builder.withW3cDocument(new W3CDom().fromJsoup(doc), baseUrl);
//        }
//        return "report generated in path : " + path;
    }

    public String exportReportFileNyc(String nameFile) throws IOException, JRException {
        String base64 = "";
        switch (nameFile) {
            case "Bang_thong_ke_cac_em_nyc":
                String path = "F:/TestAll/savefile/";
                List<HoiCacEmNyc> hoiCacEmNycList = cacEmNycRepository.findAll();
                Map<String, Object> parameters = new HashMap<>();
                //load file and compile it
                //File fileTemplate = ResourceUtils.getFile("classpath:templates/thai.jrxml");
                JRDataSource dataSource = new JRBeanCollectionDataSource(hoiCacEmNycList);
                parameters.put("thongKeNycData", dataSource);
                JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("templates/" + nameFile+ ".jrxml").getInputStream());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
                //export to html
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + nameFile + ".html");
                //export to pdf
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + nameFile + ".pdf");
                byte[] pdfByte = JasperExportManager.exportReportToPdf(jasperPrint);
                base64 = Base64.getEncoder().encodeToString(pdfByte);
                break;
            default:
                return "Không có gì";
        }

        return base64;
    }
}


