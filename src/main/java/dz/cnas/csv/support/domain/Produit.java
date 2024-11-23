package dz.cnas.csv.support.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUIT")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Stratégie d'auto-incrémentation de l'ID
    @Column(name = "id_produit")
    private Long id;

    @Column(name = "nom_produit", nullable = false, length = 100)
    private String name;

    @Column(name = "description_produit", length = 255)
    private String descriptionProduit;

    @Column(name = "code_produit", unique = true, nullable = false)
    private String codeProduit;

    @Column(name = "categorie_produit")
    private String categorieProduit;

    @Column(name = "quantite_en_stock")
    private Integer quantiteEnStock;

    @Column(name = "seuil_reapprovisionnement")
    private Integer seuilReapprovisionnement;

    @Column(name = "prix_achat", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "prix_vente", precision = 10, scale = 2)
    private BigDecimal prixVente;

    @Column(name = "date_ajout")
    private LocalDate dateAjout;

    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    @Column(name = "poids", precision = 10, scale = 2)
    private BigDecimal poids;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "etat_produit")
    private String etatProduit;

    @Column(name = "fournisseur")
    private String fournisseur;

    @Column(name = "image_produit")
    private String imageProduit; // URL ou chemin vers l'image du produit

    @Column(name = "marque")
    private String marque;

    @Column(name = "disponibilite")
    private Boolean disponibilite;

    @Column(name = "date_mise_a_jour")
    private LocalDateTime dateMiseAJour;

}
