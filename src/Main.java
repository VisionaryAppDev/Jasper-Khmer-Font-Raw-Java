import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] str) throws JRException, FileNotFoundException {
        generateSamplePdf();
    }


    private static void generateSamplePdf() throws FileNotFoundException, JRException {
        ///Load template
        File file = new File("src/static_khmer_font_sample.jrxml");
        InputStream input = new FileInputStream(file);


        // Load data from data source
        List<String> listOfData = Arrays.asList("1", "2", "3");
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(listOfData);


        /// Compile
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, source);


        /// Generate
        JasperExportManager.exportReportToPdfFile(jasperPrint, "src/generate-khmer-font.pdf" );
        System.out.println("PDF File Generated !!");
    }
}