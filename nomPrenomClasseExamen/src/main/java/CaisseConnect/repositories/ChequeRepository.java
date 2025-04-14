package CaisseConnect.repositories;

import CaisseConnect.entities.Cheque;
import CaisseConnect.entities.LettreEchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque,Long> {

    @Query("SELECT k FROM Cheque k WHERE k.commande.idCommande = :idCommande")
    Cheque findChequeByCommandeId(@Param("idCommande") Long idCommande);


    @Query("SELECT c FROM Cheque c WHERE c.DateFin BETWEEN :now AND :nextDay")
    List<Cheque> findChequesWithEcheanceProche(@Param("now") LocalDateTime now, @Param("nextDay") LocalDateTime nextDay);


}
