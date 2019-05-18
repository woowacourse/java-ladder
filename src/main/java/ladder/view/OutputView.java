package ladder.view;

import ladder.LadderGame;
import ladder.domain.LadderGameBoard;
import ladder.domain.Player;
import ladder.domain.UserOutput;

import java.util.List;

public class OutputView {
    public static void printLadderGameBoard(LadderGameBoard board) {
        printLadderValues(board.getNames());
        System.out.println(board.getLadder());
        printLadderValues(board.getResults());
    }

    private static void printLadderValues(List<String> values) {
        for (String value : values) {
            System.out.printf("%-6s", value);
        }
        System.out.println();
    }

    public static void printResult(List<Player> players) {
        System.out.println(UserOutput.PRINT_RESULT_INDEX.getOutputMessage());

        for (Player player : players) {
            String result = LadderGame.getResults().get(player.getPosition());
            System.out.println(player.getName() + " : " + result);
        }

        System.out.println(UserOutput.PRINT_GUIDE_FOR_END.getOutputMessage());
    }

    public static void printEnd() {
        System.out.println(UserOutput.PRINT_END_GAME.getOutputMessage());
    }
}
