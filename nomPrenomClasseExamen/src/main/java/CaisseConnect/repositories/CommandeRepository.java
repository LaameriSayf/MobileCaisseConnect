package CaisseConnect.repositories;

import CaisseConnect.entities.Cheque;
import CaisseConnect.entities.Commande;
import CaisseConnect.entities.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {

    @Query("SELECT c FROM Commande c WHERE c.cheque.idCheque = :idCheque")
    Commande findCommandeByChequeId(@Param("idCheque") Long idCheque);


    @Query("SELECT c FROM Commande c WHERE c.lettreechange.idLettreEchange = :idLettreEchange")
    Commande findCommandeByLettreId(@Param("idLettreEchange") Long idLettreEchange);

    @Query("SELECT c FROM Commande c WHERE c.DateCommande = :DateCommande")
    List<Commande> findCommandeByDateCommande(@Param("DateCommande") Date DateCommande);


    List<Commande> findCommandeByEtat(Etat etat);


}
