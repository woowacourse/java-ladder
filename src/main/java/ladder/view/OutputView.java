package ladder.view;

import ladder.domain.exception.CustomException;
import ladder.domain.ladder.Stool;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_MAKE_MESSAGE = "사다리 결과";
    private static final String LADDER_FRAME = "|";
    private static final String LADDER_BLOCK = "-----";
    private static final String LADDER_EMPTY_BLOCK = "     ";

    private static final String LADDER_GAME_MESSAGE = "실행 결과";
    private static final String LADDER_GAME_RESULT_FRAME = "%s : %s\n";

    public static void printErrorMessage(CustomException exception) {
        MessageSelector messageSelector = new MessageSelector();
        messageSelector.printMessageFor(exception);
    }

    public static void printGameResultHeader() {
        System.out.println();
        System.out.println(LADDER_MAKE_MESSAGE);
        System.out.println();
    }

    public static void printOneGameResult(Map.Entry<Player, String> gameResult) {
        System.out.println(LADDER_GAME_MESSAGE);
        System.out.println(gameResult.getValue());
    }

    public static void printAllGameResult(Map<Player, String> gameResult) {
        System.out.println(LADDER_GAME_MESSAGE);

        gameResult.forEach((k, v) -> System.out.printf(LADDER_GAME_RESULT_FRAME, k.getPlayerName().getName(), v));
    }

    public static void printWithFormat(final List<String> playersName) {
        for (String name : playersName) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            printOneLine(line);
            System.out.println();
        }
    }

    private static void printOneLine(final Line line) {
        printLadderFrame();
        for (Stool stool : line.getStools()) {
            printBlock(stool);
            printLadderFrame();
        }
    }

    private static void printBlock(final Stool stool) {
        if (stool.isExistStool()) {
            System.out.print(LADDER_BLOCK);
            return;
        }
        System.out.print(LADDER_EMPTY_BLOCK);
    }

    private static void printLadderFrame() {
        System.out.print(LADDER_FRAME);
    }
}
