package CaisseConnect.services;

import CaisseConnect.entities.Cheque;
import CaisseConnect.repositories.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private MailService mailService;

    public List<String> envoyerNotifications() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextDay = now.plusHours(24);

        List<String> notificationsEnvoyees = new ArrayList<>();

        try {
            // Récupérer les chèques avec échéance proche
            List<Cheque> cheques = chequeRepository.findChequesWithEcheanceProche(now, nextDay);
            System.out.println("Nombre de chèques récupérés : " + cheques.size());

            if (cheques.isEmpty()) {
                System.out.println("Aucun chèque avec une échéance proche trouvé.");
                return notificationsEnvoyees; // Retourne une liste vide
            }

            // Traiter chaque chèque
            for (Cheque cheque : cheques) {
                System.out.println("Traitement du chèque : " + cheque);

                String emailBody = String.format(
                        "Bonjour Ms Amara,\n\n" +
                                "Ce Client : %s %s,\n" +
                                "Son chèque arrive à échéance le %s.\n" +
                                "Informations :\n" +
                                "- Montant : %.2f\n" +
                                "- Date de création : %s\n\n" +
                                "Merci de prendre les mesures nécessaires.\n\nCordialement,\nVotre Service Client.",
                        cheque.getCommande().getClient().getNom(),
                        cheque.getCommande().getClient().getPrenom(),
                        cheque.getDateFin(),
                        cheque.getMontant(),
                        cheque.getDateCreation()
                );

                try {
                    // Envoi de l'email
                    mailService.envoyerEmail(
                            "laamerisayf@gmail.com",
                            "Rappel : Ce chèque arrive à échéance",
                            emailBody
                    );

                    // Ajouter le détail de la notification à la liste
                    notificationsEnvoyees.add(String.format(
                            "Notification envoyée pour le chèque de %s %s : Montant %.2f, Échéance le %s",
                            cheque.getCommande().getClient().getNom(),
                            cheque.getCommande().getClient().getPrenom(),
                            cheque.getMontant(),
                            cheque.getDateFin()
                    ));

                    System.out.println("Email envoyé pour le chèque : " + cheque);
                } catch (Exception e) {
                    System.err.println("Erreur lors de l'envoi de l'email pour le chèque : " + cheque);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur globale lors de l'envoi des notifications : " + e.getMessage());
            e.printStackTrace();
        }

        return notificationsEnvoyees;
    }
}
