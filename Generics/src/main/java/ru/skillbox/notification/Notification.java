package ru.skillbox.notification;

/**
 * Уведомления для пользователей
 */
public interface Notification {
    /**
     * @return форматированное тело сообщения
     */
    String formattedMessage();
    String otherInformation();
}
