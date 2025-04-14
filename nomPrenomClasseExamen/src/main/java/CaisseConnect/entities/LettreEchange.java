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

public class LettreEchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLettreEchange ;
    private double Montant ;
    private Integer numLE ;
    private Date DateCreation ;
    private Date DateEcheance ;
    @Column(unique = true)
    private Integer RIB ;
    private String image ;

    @OneToOne
    private Commande commande;

}
