package com.netology;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class Welcomer {

    public String welcome() {
        return "Welcome to Netology!";
    }

    // НОВЫЙ МЕТОД ДЛЯ ЗАДАНИЯ
    public String getHunterReply() {
        List<String> replies = Arrays.asList(
            "The hunter is always watching",
            "Every hunter needs a prey",
            "Hunter's instinct never fails",
            "The night hunter awakens",
            "A true hunter never rests",
            "The hunter becomes the hunted",
            "Hunter's moon is rising"
        );
        return replies.get(new Random().nextInt(replies.size()));
    }
}