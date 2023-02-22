package ladder.view;


import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.StepPoint;

/*
 * pobi  honux crong   jk
 *     |-----|     |-----|
 *     |     |-----|     |
 *     |-----|     |     |
 *     |     |-----|     |
 *     |-----|     |-----|
 */
public class OutputView {

    private static final String VERTICAL = "|";
    private static final String STEP_EXIST = "-";
    private static final String STEP_NONE = " ";

    private static final String MESSAGE_LADDER_RESULT = "사다리 결과";
    private static final String MESSAGE_GAME_RESULT = "실행 결과";

    private static final String FORMAT_PLAYER_RESULT = "%s : %s" + System.lineSeparator();

    public static void showLadderResult(List<String> players, List<Line> lines, List<String> results) {
        int pointWidth = Math.max(computeMaxNameLength(players), computeMaxNameLength(results));

        System.out.println();
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println(" " + extractWords(players, pointWidth));
        lines.stream()
                .map(line -> extractLine(line, pointWidth))
                .forEach(System.out::println);
        System.out.println(" " + extractWords(results, pointWidth));
    }

    private static String extractWords(List<String> players, int pointWidth) {
        String nameFormat = "%" + pointWidth + "s";
        return players.stream()
                .map(name -> String.format(nameFormat, name))
                .collect(Collectors.joining(" "));
    }

    private static int computeMaxNameLength(List<String> players) {
        return players.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("게임 참여자가 존재하지 않습니다."));
    }

    private static String extractLine(Line line, int pointWidth) {
        List<Direction> directions = line.toDirections();
        StringJoiner result = new StringJoiner(VERTICAL, VERTICAL, VERTICAL);

        for (int i = 0; i < directions.size() - 1; i++) {
            Direction direction = directions.get(i);
            String stepPointFormat = toStepPointFormat(direction.getRightStepPoint(), pointWidth);
            result.add(stepPointFormat);
        }
        return toStepPointFormat(StepPoint.NONE, pointWidth) + result;
    }

    private static String toStepPointFormat(StepPoint point, int pointWidth) {
        if (point == StepPoint.EXIST) {
            return STEP_EXIST.repeat(pointWidth);
        }
        return STEP_NONE.repeat(pointWidth);
    }

    public static void showGameResultMessage() {
        System.out.println();
        System.out.println(MESSAGE_GAME_RESULT);
    }

    public static void showAllResultsByPlayer(Map<String, String> allResults) {
        allResults.forEach((name, result) -> System.out.printf(FORMAT_PLAYER_RESULT, name, result));
    }

    public static void showResultByPlayer(String result) {
        System.out.println(result);
    }
}
