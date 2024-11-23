package dz.cnas.csv.support.service.impl;

import dz.cnas.csv.support.domain.Produit;

import java.io.OutputStream;
import java.util.List;


public interface ProduitService {
    List<Produit> getAllProducts();
    void writeProductsToCsvAndZip(OutputStream outputStream);
}
