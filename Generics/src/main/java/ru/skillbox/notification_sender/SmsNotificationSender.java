package ru.skillbox.notification_sender;

import ru.skillbox.notification.SmsNotification;
import java.util.List;

public class SmsNotificationSender implements NotificationSender {

    @Override
    public void send(List notifications) {
        notifications.forEach(sms -> send((SmsNotification) sms));
    }
}
