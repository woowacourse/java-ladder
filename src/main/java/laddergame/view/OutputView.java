package laddergame.view;


import java.util.List;
import java.util.Map;
import laddergame.domain.ladder.line.Line;
import laddergame.view.util.LadderResultFormatter;

public class OutputView {

    private static final String MESSAGE_LADDER_RESULT = "사다리 결과";
    private static final String MESSAGE_GAME_RESULT = "실행 결과";

    private static final String FORMAT_PLAYER_RESULT = "%s : %s" + System.lineSeparator();

    public static void showLadderResult(List<String> players, List<Line> lines, List<String> results) {
        System.out.println();
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println(LadderResultFormatter.extractLadderResult(players, lines, results));
    }

    public static void showAllItemsByPlayer(Map<String, String> allResults) {
        System.out.println();
        System.out.println(MESSAGE_GAME_RESULT);
        allResults.forEach((name, result) -> System.out.printf(FORMAT_PLAYER_RESULT, name, result));
    }

    public static void showItemByPlayer(String result) {
        System.out.println();
        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println(result);
    }
}
