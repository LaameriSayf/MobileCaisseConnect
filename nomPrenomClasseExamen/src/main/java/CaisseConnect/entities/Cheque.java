package CaisseConnect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheque ;
    private double Montant ;
    private Date DateCreation;
    private Date DateFin;



    @OneToOne(mappedBy = "cheque")
    private Commande commande;







}
