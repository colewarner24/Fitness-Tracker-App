package fitnesstracker.designs.notifications;

import java.util.ArrayList;
import java.util.List;
import fitnesstracker.designs.notifications.NotificationService;
import fitnesstracker.model.User;
import fitnesstracker.model.Progress;

public class NotificationManager {

    private NotificationService notificationService = new NotificationService();

    public void sendDailyNotification(User user) {
        notificationService.dailyNotification(user);
    }
}