package view;

import dto.LadderGameResults;
import java.util.List;

public class OutputView {
    public static void print(String string) {
        System.out.println(string);
    }

    public static void printPlayers(List<String> playerNames) {
        print(PlayersPrinter.from(playerNames));
    }

    public static void printLadder(List<List<Boolean>> rawLadder) {
        print(LadderPrinter.from(rawLadder));
    }

    public static void printGifts(List<String> giftNames) {
        print(GiftsPrinter.from(giftNames));
    }

    public static void printLadderGameResults(LadderGameResults ladderGameResults) {
        print(LadderGameResultsPrinter.from(ladderGameResults));
    }
}
