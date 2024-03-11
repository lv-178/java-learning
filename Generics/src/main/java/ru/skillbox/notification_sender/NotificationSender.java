package ru.skillbox.notification_sender;

import ru.skillbox.notification.Notification;
import java.util.List;

/**
 * Сервис по отправке уведомлений
 *
 * @param <T> Вид отправляемого уведомления
 */
public interface NotificationSender<T extends Notification> {

    /**
     * Отправить одно уведомление
     *
     * @param notification уведомление
     */
    default void send(T notification){
        System.out.println(notification.otherInformation());
        System.out.println("message: " + notification.formattedMessage());
    }

    /**
     * Отправка множества уведомлений
     *
     * @param notifications список уведомлений
     */
    void send(List<T> notifications);
}
