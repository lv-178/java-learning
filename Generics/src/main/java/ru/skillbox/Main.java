package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotificationSender;
import ru.skillbox.notification_sender.PushNotificationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmailNotificationSender emailSender = new EmailNotificationSender();
        SmsNotificationSender smsSender = new SmsNotificationSender();
        PushNotificationSender pushSender = new PushNotificationSender();

        EmailNotification email1 = new EmailNotification("Создан новый аккаунт",
                "Успешная регистрация", "skillbox@mail.ru");
        EmailNotification email2 = new EmailNotification("Переделать! " +
                "ВАХ реального диода (прямая ветвь) - увеличить прямое смещение до 1,5 В!",
                "Ответ", "k124@mail.ru");
        EmailNotification email3 = new EmailNotification("Внимание! (Тут что-нибудь важное)",
                "Важная информация", "skillbox3@mail.ru");

        List<EmailNotification> emails = Arrays.asList(email1, email2, email3);
        emailSender.send(emails);

        SmsNotification sms1 = new SmsNotification("Спасибо за регистрацию",
                "+79212122222");
        SmsNotification sms2 = new SmsNotification("Код подтверждения: 86400",
                "+79808080802");
        SmsNotification sms3 = new SmsNotification("Ваша карта заблокирована. " +
                "Сообщите нам CVV и код из смс, чтобы исправить проблему.",
                "+79808080802");

        List<SmsNotification> sms = Arrays.asList(sms1, sms2, sms3);
        smsSender.send(sms);

        PushNotification push1 = new PushNotification("Your task is finished",
                "Process", "mary123, alex");
        PushNotification push2 = new PushNotification("hi there",
                ":)", "user67");
        PushNotification push3 = new PushNotification("Поздравляем! \uD83C\uDF1F " +
                "Вы прошли последний уровень! Будем рады, если оставите отзыв",
                "Оцените приложение", "mooncat, tele4, noone");

        List<PushNotification> push = Arrays.asList(push1, push2, push3);
        pushSender.send(push);
    }
}
