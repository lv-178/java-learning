package ru.skillbox.notification_sender;

import ru.skillbox.notification.SmsNotification;
import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {

    @Override
    public void send(List<SmsNotification> notifications) {
        notifications.forEach(this::send);
    }
}
