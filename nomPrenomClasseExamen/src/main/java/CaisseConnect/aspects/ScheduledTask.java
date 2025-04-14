package CaisseConnect.aspects;

import CaisseConnect.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

   @Autowired
   NotificationService notificationService;


    @Scheduled(cron = "0 0 9 * * ?") // Tous les jours à 9h
    public void notifierClients() {
        notificationService.envoyerNotifications();
    }
}
