package com.skillbox.redisdemo;

import static java.lang.System.out;

public class RedisTest {

    private static final int SLEEP = 1000;

    private static void log(int nextUser) {
        String log = "На главной странице показываем пользователя " + nextUser;
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int i = 1; i <= 20; i++) {
            redis.add(i);
        }

        for(;;) {
            for (int i = 0; i < 10; i++) {
                log(redis.nextUser());
                Thread.sleep(SLEEP);
            }
            int randomUser = (int) Math.round(Math.random()*20)+1;
            out.println("Пользователь " + randomUser + " оплатил платную услугу");
            redis.add(randomUser, 0);
        }
    }
}
