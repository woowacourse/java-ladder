package ladder.view;


import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
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
    private static final String MESSAGE_GAME_RESULT = "실행 결과";

    public static void showGameResult(List<String> players, List<Line> lines) {
        int pointWidth = computeMaxNameLength(players);

        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println(" " + extractPlayerNames(players, pointWidth));
        lines.stream()
                .map(line -> extractLine(line, pointWidth))
                .forEach(System.out::println);
    }

    private static String extractPlayerNames(List<String> players, int pointWidth) {
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
        List<StepPoint> stepPoints = line.toUnmodifiableStepPoints();
        StringJoiner result = new StringJoiner(VERTICAL, VERTICAL, VERTICAL);

        for (StepPoint point : stepPoints) {
            String stepPointFormat = toStepPointFormat(point, pointWidth);
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
}
