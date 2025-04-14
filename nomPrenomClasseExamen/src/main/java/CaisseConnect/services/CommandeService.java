package CaisseConnect.services;

import CaisseConnect.entities.Cheque;
import CaisseConnect.entities.Client;
import CaisseConnect.entities.Commande;
import CaisseConnect.entities.Etat;
import CaisseConnect.repositories.ClientRepository;
import CaisseConnect.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Commande AjouterCommandeEtAffecterAClient (Commande c , Long idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        c.setClient(client);
        return commandeRepository.save(c);

    }
    public Commande UpdateCommande (Commande c ) {

        return commandeRepository.save(c);

    }

    public Commande getCommande(Long idCommande){
        return commandeRepository.findById(idCommande).orElse(null);
    }
    public List<Commande> getCommandes(){
        return commandeRepository.findAll();
    }
    public void DeleteCommande(Long idCommande ){
         commandeRepository.deleteById( idCommande);

    }

    public Commande getCommandebyCheque( Long idCheque){
        return commandeRepository.findCommandeByChequeId(idCheque);
    }

    public Commande getCommandebyLettre(Long idLettreEchange){
        return commandeRepository.findCommandeByLettreId(idLettreEchange);
    }

    public List<Commande> findCommandeByDate(Date DateCommande) {
        return commandeRepository.findCommandeByDateCommande(DateCommande);
    }

    public List<Commande> findCommandeByEtat(Etat etat){

        return commandeRepository.findCommandeByEtat(etat);
    }
}
