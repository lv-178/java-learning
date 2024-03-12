package ru.skillbox.notification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailNotification implements Notification {

    private final String message;
    private final String subject;
    private final String receivers;

    @Override
    public String formattedMessage() {
        return "<p>" + message + "</p>";
    }

    @Override
    public String otherInformation() {
        return "\nEMAIL\nsubject: " + subject + "\nreceivers: " + receivers;
    }
}
