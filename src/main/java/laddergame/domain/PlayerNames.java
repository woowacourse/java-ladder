package laddergame.domain;

import java.util.*;

public class PlayerNames {
    public static List<String> makeNames(String input) {
        PlayerNamesValidator.checkNullName(input);

        input = input.replaceAll(" ", "");
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));

        PlayerNamesValidator.checkConditions(input, names);

        return names;
    }
}
