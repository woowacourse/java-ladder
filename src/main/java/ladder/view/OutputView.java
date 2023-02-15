package ladder.view;

import java.util.List;

public class OutputView {
    public static void printPlayers(List<String> playerNames) {
        System.out.print(playerNames.get(0));
        for (int i = 1; i < playerNames.size(); i++) {
            printNameOnSquares(playerNames.get(i));
        }
        System.out.println();
    }

    private static void printNameOnSquares(String playerName) {
        int nameLength = playerName.length();
        System.out.print(" ".repeat(7 - nameLength));
        System.out.print(playerName);
    }
}
