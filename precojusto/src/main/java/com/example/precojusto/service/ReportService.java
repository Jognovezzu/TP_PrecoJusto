package com.example.precojusto.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.precojusto.repository.DTO.ReportProjection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



@Service
public class ReportService {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private VendaService vendaService;


    public byte[] generateReportPDF() throws JRException {
        try (InputStream reportStream = new ClassPathResource("PrecoJusto1.jrxml").getInputStream()) {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource.getConnection());

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (IOException | SQLException e) {
            System.err.println("Error generating PDF report: " + e.getMessage());
            throw new JRException("Error generating PDF report", e);
        }
    }
    

    public String generateReportXLSX(OutputStream outputStream){
        List<ReportProjection> patos = vendaService.makeReport();



        try ( Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Gerenciamento de Patos");

            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("GERENCIAMENTO DE PATOS");

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

            CellStyle titleStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();
            titleFont.setFontHeightInPoints((short) 16);
            titleFont.setBold(true);
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            titleCell.setCellStyle(titleStyle);

            // Header
            Row headerRow = sheet.createRow(1);
            String[] columns = {"Nome", "Disponivel", "Nome Cliente", "Desconto","Valor"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell((i));
                cell.setCellValue(columns[i]);
            }

            // Data
            int rowNum = 2;
            for (ReportProjection pato : patos) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(pato.getPatoNome() != null ? pato.getPatoNome() : "-");
                row.createCell(1).setCellValue(pato.getPatoDisponivel() != null ? (pato.getPatoDisponivel() ? "Sim" : "Não") : "-");
                row.createCell(2).setCellValue(pato.getClienteNome() != null ? pato.getClienteNome() : "-");
                row.createCell(3).setCellValue(pato.getClienteDesconto() != null ? (pato.getClienteDesconto() ? "Sim" : "Não") : "-");
                row.createCell(4).setCellValue(pato.getPatoValor() != null ? pato.getPatoValor() : 0);
                
            }


            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            workbook.write(outputStream);

            return "Relatório gerado com sucesso!";

        } catch (IOException e) {
            return e.getMessage();
        }

    }
}
