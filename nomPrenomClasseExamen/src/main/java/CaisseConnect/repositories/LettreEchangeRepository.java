package CaisseConnect.repositories;

import CaisseConnect.entities.Commande;
import CaisseConnect.entities.LettreEchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LettreEchangeRepository extends JpaRepository<LettreEchange,Long> {

    @Query("SELECT l FROM LettreEchange l WHERE l.commande.idCommande = :idCommande")
    LettreEchange findLettreByCommandeId(@Param("idCommande") Long idCommande);

}
