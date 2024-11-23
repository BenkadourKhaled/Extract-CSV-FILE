package dz.cnas.csv.support.repository;

import dz.cnas.csv.support.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {


}