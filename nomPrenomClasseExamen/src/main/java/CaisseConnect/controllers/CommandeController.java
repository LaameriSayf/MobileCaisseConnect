package CaisseConnect.controllers;

import CaisseConnect.entities.Commande;
import CaisseConnect.entities.Etat;
import CaisseConnect.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commande")

public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/AjouterCommandeEtAffecterAClient/{idClient}")
    public Commande AjouterCommandeEtAffecterAClient (@RequestBody Commande c , @PathVariable Long idClient){
        return commandeService.AjouterCommandeEtAffecterAClient(c, idClient);

    }
    @PutMapping("/UpdateCommande/")
    public Commande UpdateCommande (@RequestBody Commande c ){
        return commandeService.UpdateCommande(c);
    }

    @GetMapping("/getCommande/{idCommande}")
    public Commande getCommande(@PathVariable Long idCommande){
        return commandeService.getCommande(idCommande);
    }

    @GetMapping("/getCommandes")
    public List<Commande> getCommandes(){
        return commandeService.getCommandes();
    }

    @DeleteMapping("/DeleteCommande/{idCommande}")
    public void DeleteCommande(@PathVariable Long idCommande ){
        commandeService.DeleteCommande(idCommande);
    }

    @GetMapping("/getCommandebyCheque/{idCheque}")
    public Commande getCommandebyCheque(@PathVariable Long idCheque){
        return commandeService.getCommandebyCheque(idCheque);
    }

    @GetMapping("/getCommandebyCheque/{idLettreEchange}")
    public Commande getCommandebyLettre(@PathVariable Long idLettreEchange){
        return commandeService.getCommandebyLettre(idLettreEchange);
    }

    @GetMapping("/findCommandeByDate/{DateCommande}")
    public List<Commande> findCommandeByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateCommande){
        return commandeService.findCommandeByDate(DateCommande);
    }
    @GetMapping("/findCommandeByEtat/{etat}")
    public List<Commande> finCommandeByEtat(@PathVariable Etat etat){
        return commandeService.findCommandeByEtat(etat);
    }


}
