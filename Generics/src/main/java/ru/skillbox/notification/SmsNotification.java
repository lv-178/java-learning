package ru.skillbox.notification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmsNotification implements Notification {

    private final String message;
    private final String receivers;
    private String otherInformation = "";

    @Override
    public String formattedMessage() {
        return message;
    }

    @Override
    public String otherInformation() {
        otherInformation = "\nSMS\nreceivers: " + receivers;
        return otherInformation;
    }
}
