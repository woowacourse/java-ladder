package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrizesGenerator {
    public static List<Prize> createPrizes(String input, int numOfPlayers) {
        List<String> inputs = new ArrayList<>(Arrays.asList(input.split(",")));
        PrizesValidator.checkConditions(inputs, numOfPlayers);

        List<Prize> prizes = new ArrayList<>();
        for (String name : inputs) {
            prizes.add(new Prize(name));
        }

        return prizes;
    }
}
