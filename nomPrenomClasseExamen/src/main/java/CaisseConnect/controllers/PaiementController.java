package CaisseConnect.controllers;

import CaisseConnect.entities.Cheque;
import CaisseConnect.entities.Commande;
import CaisseConnect.entities.LettreEchange;
import CaisseConnect.entities.ModePaiement;
import CaisseConnect.services.PaimentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiment")

public class PaiementController {

    @Autowired
    PaimentService paimentService;

    public class PaiementDTO {
        private Cheque cheque;
        private LettreEchange lettreEchange;
        private ModePaiement modePaiement; // Add this field to decide the payment mode

        // Getters and setters
    }



    @PostMapping("/addLettreEchange/{idCommande}")
    public LettreEchange addLettreEchange(@RequestBody LettreEchange lettreEchange,@PathVariable Long idCommande) {
        return paimentService.addLettreEchange(lettreEchange, idCommande);
    }

    @PostMapping("/addCheque/{idCommande}")
    public Cheque addCheque(@RequestBody Cheque cheque, @PathVariable Long idCommande){
        return paimentService.addCheque(cheque, idCommande);
    }

    @GetMapping("/getLetters")
    public List<LettreEchange> getLetters(){
        return paimentService.getLetters();
    }

    @GetMapping("/getCheques")
    public List<Cheque> getCheques(){
        return paimentService.getCheques();
    }

    @GetMapping("/paiement/{idCommande}")
    public ResponseEntity<Object> getPaiementByCommande(@PathVariable Long idCommande) {
        Object paiement = paimentService.getPaiementByCommande(idCommande);

        if (paiement != null) {
            return ResponseEntity.ok(paiement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteCheque/{idCheque}")
    public void DeleteCheque(Long idCheque){
        paimentService.DeleteCheque(idCheque);


    }

    @DeleteMapping("/DeleteLettre/{idLettreEchange}")
    public void DeleteLettre(@PathVariable Long idLettreEchange){
        paimentService.DeleteLettre(idLettreEchange);
    }







    }
