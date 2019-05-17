package laddergame.domain;

import java.util.List;

public class GameResult {
    public static String makeResult(List<Player> players, List<Prize> prizes, String input) {
        validateExistedInputException(players, input);
        return "abc";
    }

    private static void validateExistedInputException(List<Player> players, String input) {
        if (input.equals("all")) {
            return;
        }

        boolean isNamePresent = false;
        for (int i = 0; i < players.size() && !isNamePresent; i++) {
            isNamePresent = players.get(i).contains(input);
        }

        if (!isNamePresent) {
            throw new IllegalArgumentException();
        }
    }
}
