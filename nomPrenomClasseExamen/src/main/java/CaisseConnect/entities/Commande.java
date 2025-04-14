package CaisseConnect.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande ;
    private double Quantite ;
    private Date DateCommande ;
    private String Remarque ;

    private double Montant ;
    @Enumerated(EnumType.STRING)
    private Etat etat ;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne
    @JsonIgnore
    Client client;

    @OneToOne
    @JsonIgnore
    private Cheque cheque;

    @OneToOne
    @JsonIgnore
    private LettreEchange lettreechange;



}
