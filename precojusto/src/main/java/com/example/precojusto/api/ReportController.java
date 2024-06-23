package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.precojusto.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    @GetMapping("/pdf")
    public ResponseEntity <byte[]> generateReporty() {
        try {
            byte[]pdfReport = reportService.generateReportPDF();
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "report.pdf");

            return new ResponseEntity<>(pdfReport, headers, HttpStatus.OK);
        } catch (JRException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/xlsx")
    public String generateReportXLSX(HttpServletResponse res) throws IOException {
        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        res.setHeader("Content-Disposition", "attachment; filename=report.xlsx");
        return reportService.generateReportXLSX(res.getOutputStream());
    }

    
    
}
