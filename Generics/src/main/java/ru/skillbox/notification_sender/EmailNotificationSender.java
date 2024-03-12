package ru.skillbox.notification_sender;

import ru.skillbox.notification.EmailNotification;
import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {

    @Override
    public void send(List<EmailNotification> notifications) {
        notifications.forEach(this::send);
    }
}
