package view;

import domain.Ladder;
import domain.Players;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과\n");
    }
    public static void printPlayers(Players players) {
        System.out.println(players.getPlayersNames());
    }

    public static void printLadder(Ladder ladder) {
        for (String ladderLine : ladder.getLadderLines()) {
            System.out.println(ladderLine);
        }
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
