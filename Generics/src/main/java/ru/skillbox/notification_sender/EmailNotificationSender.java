package ru.skillbox.notification_sender;

import ru.skillbox.notification.EmailNotification;
import java.util.List;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(List notifications) {
        notifications.forEach(email -> send((EmailNotification) email));
    }
}
