package CaisseConnect.controllers;

import CaisseConnect.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send-notifications")
    public String sendNotifications() {
        notificationService.envoyerNotifications();
        return "Notifications envoyées avec succès.";
    }
}
