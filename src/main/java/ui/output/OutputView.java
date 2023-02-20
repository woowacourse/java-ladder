package ui.output;

import domain.Lines;
import domain.Players;

import java.util.NoSuchElementException;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
public class OutputView {

    private static final String EXECUTE_RESULT = "실행결과";

    public static void printResult(final Players players, final Lines lines) {
        System.out.println("\n" + EXECUTE_RESULT + "\n");
        printPlayersName(players);
        printLadder(lines, players);
    }

    private static void printPlayersName(Players players) {
        int maxPlayerNameLength = getMaxLength(players);
        calculateNamePosition(players, maxPlayerNameLength);
    }

    private static int getMaxLength(Players players) {
        return players.getPlayers().stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow();
    }

    private static void calculateNamePosition(Players players, int maxPlayerNameLength) {
        players.getPlayers().stream()
                .forEach(player ->
                        System.out.print(" ".repeat(maxPlayerNameLength - player.getName().length()) + player.getName() + " ")
                );
    }

    private static void printLadder(Lines lines, Players players) {
        LadderShape.getLadderForm(lines);
    }

}
