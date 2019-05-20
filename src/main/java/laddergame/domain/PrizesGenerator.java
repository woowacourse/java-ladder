package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrizesGenerator {
    public static PrizeGroup createPrizes(String input, int countOfPlayers) {
        List<String> inputs = Arrays.asList(input.split(","));

        PrizesValidator.checkConditions(inputs, countOfPlayers);

        List<Prize> prizes = new ArrayList<>();
        for (String name : inputs) {
            prizes.add(new Prize(name));
        }

        return new PrizeGroup(prizes);
    }
}
