package plaindoll;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class Welcomer {

    public String sayWelcome() {
        return "Welcome hunter!";
    }

    public String sayFarewell() {
        return "Farewell hunter!";
    }

    public String sayNeedGold() {
        return "Need gold";
    }

    public String saySome() {
        return "something";
    }

    // НОВЫЙ МЕТОД ДЛЯ ЗАДАНИЯ
    public String sayHunterReply() {
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