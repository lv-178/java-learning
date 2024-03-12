package ru.skillbox.notification_sender;

import ru.skillbox.notification.PushNotification;
import java.util.List;

public class PushNotificationSender implements NotificationSender<PushNotification> {

    @Override
    public void send(List<PushNotification> notifications) {
        notifications.forEach(this::send);
    }
}
