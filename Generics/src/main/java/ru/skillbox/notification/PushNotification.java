package ru.skillbox.notification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PushNotification implements Notification {

    private final String message;
    private final String title;
    private final String receivers;

    @Override
    public String formattedMessage() {
        return "\uD83D\uDC4B " + message;
    }

    @Override
    public String otherInformation() {
        return "\nPUSH\ntitle: " + title + "\nreceivers: " + receivers;
    }
}
