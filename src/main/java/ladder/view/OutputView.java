package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.LadderGamePlayers;
import ladder.domain.LadderGameRewards;

import static ladder.view.constants.OutputViewConstants.*;

public class OutputView {

    public static void printLadder(LadderGamePlayers players, Ladder ladder, LadderGameRewards rewards) {
        printMassage(PAINT_LADDER_MESSAGE + NEXT_LINE);
        printMassage(players.toString() + NEXT_LINE);
        printMassage(ladder.toString() + NEXT_LINE);
        printMassage(rewards.toString() + NEXT_LINE);
    }

    public static void printResult(GameResult result) {

        String message = BLANK;
        while (!message.equals(STOP_MESSAGE)) {
            message = InputView.getResult();
            String resultMassage = getResultMessage(result, message);
            printMassage(PRINT_RESULT_MESSAGE);
            printMassage(resultMassage);
            printMassage(NEXT_LINE);
        }
    }

    private static String getResultMessage(GameResult result, String message) {
        try {
            return result.getResult(message);
        } catch (IllegalArgumentException ie) {
            return ie.getMessage();
        }
    }

    static void printMassage(String message) {
        System.out.println(message);
    }
}
