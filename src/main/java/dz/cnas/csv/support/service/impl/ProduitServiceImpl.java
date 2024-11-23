package dz.cnas.csv.support.service.impl;

import dz.cnas.csv.support.domain.Produit;
import dz.cnas.csv.support.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository productRepository;

    public List<Produit> getAllProducts() {
       /* List a=new ArrayList();

        for (int i=0 ; i<1000; i++){
            Produit produit=Produit.builder().nom("produit "+ i).prix(0.00).build();
            a.add(produit);

        }

        productRepository.saveAll(a);*/
        return  productRepository.findAll();
    }

    public void writeProductsToCsvAndZip(OutputStream outputStream) {
        try (ZipOutputStream zipOut = new ZipOutputStream(outputStream)) {
            ZipEntry zipEntry = new ZipEntry("products.csv");
            zipOut.putNextEntry(zipEntry);

            StringWriter writer = new StringWriter();
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            csvPrinter.printRecord("ID", "Name", "Price");
            for (Produit product : getAllProducts()) {
                csvPrinter.printRecord(product.getId(), product.getName(), product.getPrice());
            }

            csvPrinter.flush();

            zipOut.write(writer.toString().getBytes());
            zipOut.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException("Failed to export data to CSV and zip", e);
        }
    }
}
