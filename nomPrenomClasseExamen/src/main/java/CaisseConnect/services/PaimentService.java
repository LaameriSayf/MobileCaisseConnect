package CaisseConnect.services;

import CaisseConnect.entities.Cheque;
import CaisseConnect.entities.Commande;
import CaisseConnect.entities.LettreEchange;
import CaisseConnect.entities.ModePaiement;
import CaisseConnect.repositories.ChequeRepository;
import CaisseConnect.repositories.CommandeRepository;
import CaisseConnect.repositories.LettreEchangeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class PaimentService {

    @Autowired
    ChequeRepository chequeRepository;
    @Autowired
    LettreEchangeRepository lettreEchangeRepository;
    @Autowired
    CommandeRepository commandeRepository;

    // Add the missing method to fetch a commande by its ID
    public Commande getCommandeById(Long idCommande) {
        return commandeRepository.findById(idCommande)
                .orElseThrow(() -> new IllegalArgumentException("Commande with ID " + idCommande + " not found."));
    }

    public Cheque addCheque(Cheque cheque, Long idCommande) {
        Commande commande = getCommandeById(idCommande);

        if (commande.getModePaiement()==ModePaiement.CHEQUE) {
            cheque = chequeRepository.save(cheque);

            commande.setCheque(cheque);
            cheque.setCommande(commande);

            commandeRepository.save(commande);

            return cheque;
        } else {
            throw new IllegalArgumentException("The payment method is not cheque.");
        }
    }


    public LettreEchange addLettreEchange(LettreEchange lettreEchange, Long idCommande) {

        Commande commande = getCommandeById(idCommande);
        if (commande.getModePaiement()==ModePaiement.LETTRE_ECHANGE) {
            lettreEchange = lettreEchangeRepository.save(lettreEchange);

            commande.setLettreechange(lettreEchange);
            lettreEchange.setCommande(commande);

            commandeRepository.save(commande);

            return lettreEchange;
        } else {
            throw new IllegalArgumentException("The payment method is not lettre echange.");
        }
    }

    public List<LettreEchange> getLetters(){
        return lettreEchangeRepository.findAll();
    }

    public List<Cheque> getCheques(){
        return chequeRepository.findAll();
    }

    public Object getPaiementByCommande(Long idCommande) {
        Commande commande = commandeRepository.findById(idCommande).orElse(null);



        if (commande.getModePaiement() != null) {
            if (commande.getModePaiement()==ModePaiement.CHEQUE) {
                return chequeRepository.findChequeByCommandeId(idCommande);
            } else if (commande.getModePaiement()==ModePaiement.LETTRE_ECHANGE) {
                return lettreEchangeRepository.findLettreByCommandeId(idCommande);
            }
        }

        return null;
    }

    public void DeleteCheque(Long idCheque){
        chequeRepository.deleteById(idCheque);
    }

    public void DeleteLettre(Long idLettreEchange){
        lettreEchangeRepository.deleteById(idLettreEchange);
    }


}


