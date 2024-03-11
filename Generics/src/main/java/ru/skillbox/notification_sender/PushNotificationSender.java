package ru.skillbox.notification_sender;

import ru.skillbox.notification.PushNotification;
import java.util.List;

public class PushNotificationSender implements NotificationSender {

    @Override
    public void send(List notifications) {
        notifications.forEach(push -> send((PushNotification) push));
    }
}
