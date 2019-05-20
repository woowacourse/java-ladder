package laddergame.domain;

import java.util.*;

public class PlayersGenerator {
    public static PlayerGroup createPlayers(String input) {
        List<String> names = makeNames(input);
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            players.add(new Player(new PlayerName(name)));
        }

        return new PlayerGroup(players);
    }

    private static List<String> makeNames(String input) {
        PlayerNamesValidator.checkNullName(input);

        input = input.replaceAll(" ", "");
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));

        PlayerNamesValidator.checkNullName(input);
        PlayerNamesValidator.checkDuplicatedName(names);

        return names;
    }
}
